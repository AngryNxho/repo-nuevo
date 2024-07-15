-- Creación de los usuarios 
CREATE USER MDY2131_ET_FA IDENTIFIED BY "ConsultaBase_de_datos_1_FA"
DEFAULT TABLESPACE data
TEMPORARY TABLESPACE temp
QUOTA UNLIMITED ON data;

CREATE USER MDY2131_ET_FA_DES IDENTIFIED BY "ConsultaBase_de_datos_2_DES"
DEFAULT TABLESPACE data
TEMPORARY TABLESPACE temp
QUOTA UNLIMITED ON data;

CREATE USER MDY2131_ET_FA_CON IDENTIFIED BY "ConsultaBase_de_datos_3_CON"
DEFAULT TABLESPACE data
TEMPORARY TABLESPACE temp
QUOTA UNLIMITED ON data;

-- Asignación de privilegios a usuario MDY2131_ET_FA
GRANT ALTER ANY TABLE, DROP ANY TABLE, ALTER ANY SEQUENCE, DROP ANY SEQUENCE, CREATE ANY INDEX, DROP ANY INDEX TO MDY2131_ET_FA;
GRANT CREATE PUBLIC SYNONYM TO MDY2131_ET_FA;

-- Asignación de privilegios a usuario MDY2131_ET_FA_DES
GRANT CREATE PROCEDURE, CREATE TRIGGER, CREATE VIEW, CREATE MATERIALIZED VIEW TO MDY2131_ET_FA_DES;

-- Índices en tablas
CREATE INDEX idx_fecha_pago ON MDY2131_ET_FA.pago_gasto_comun(fecha_cancelacion_pgc);
CREATE INDEX idx_depto_edif ON MDY2131_ET_FA.pago_gasto_comun(id_edif, nro_depto);

CREATE INDEX idx_nombre_edif ON MDY2131_ET_FA.edificio(nombre_edif);
CREATE INDEX idx_comuna_edif ON MDY2131_ET_FA.edificio(id_comuna);

-- Creación de sinónimos
CREATE OR REPLACE PUBLIC SYNONYM syn_edificio FOR MDY2131_ET_FA.edificio;
CREATE OR REPLACE PUBLIC SYNONYM syn_comuna FOR MDY2131_ET_FA.comuna;
CREATE OR REPLACE PUBLIC SYNONYM syn_administrador FOR MDY2131_ET_FA.administrador;
CREATE OR REPLACE PUBLIC SYNONYM syn_departamento FOR MDY2131_ET_FA.departamento;
CREATE OR REPLACE PUBLIC SYNONYM syn_pago_comun FOR MDY2131_ET_FA.pago_gasto_comun;
CREATE OR REPLACE PUBLIC SYNONYM syn_forma_pago FOR MDY2131_ET_FA.forma_pago;
CREATE OR REPLACE PUBLIC SYNONYM syn_periodo_cobro FOR MDY2131_ET_FA.periodo_cobro_gasto_comun;
CREATE OR REPLACE PUBLIC SYNONYM syn_estado_pago FOR MDY2131_ET_FA.estado_pago;
CREATE OR REPLACE PUBLIC SYNONYM syn_estado_periodo FOR MDY2131_ET_FA.estado_periodo;
CREATE OR REPLACE PUBLIC SYNONYM syn_tipo_persona FOR MDY2131_ET_FA.tipo_persona;
CREATE OR REPLACE PUBLIC SYNONYM syn_multa_atraso FOR MDY2131_ET_FA.multa_atraso;
CREATE OR REPLACE PUBLIC SYNONYM syn_responsable_pago FOR MDY2131_ET_FA.responsable_pago_gasto_comun;
CREATE OR REPLACE PUBLIC SYNONYM syn_gasto_comun_cero FOR MDY2131_ET_FA.gasto_comun_pago_cero;
CREATE OR REPLACE PUBLIC SYNONYM syn_gasto_comun FOR MDY2131_ET_FA.gasto_comun;

-- Permisos para MDY2131_ET_FA_DES
GRANT SELECT, INSERT, UPDATE, DELETE ON syn_edificio TO MDY2131_ET_FA_DES;
GRANT SELECT, INSERT, UPDATE, DELETE ON syn_comuna TO MDY2131_ET_FA_DES;
GRANT SELECT, INSERT, UPDATE, DELETE ON syn_administrador TO MDY2131_ET_FA_DES;
GRANT SELECT, INSERT, UPDATE, DELETE ON syn_departamento TO MDY2131_ET_FA_DES;
GRANT SELECT, INSERT, UPDATE, DELETE ON syn_pago_comun TO MDY2131_ET_FA_DES;

-- Permisos para MDY2131_ET_FA_CON
GRANT SELECT ON syn_edificio TO MDY2131_ET_FA_CON;
GRANT SELECT ON syn_comuna TO MDY2131_ET_FA_CON;
GRANT SELECT ON syn_forma_pago TO MDY2131_ET_FA_CON;

-- Creación de vistas para informes
CREATE OR REPLACE VIEW view_deptos_no_pago AS
SELECT e.nombre_edif, d.nro_depto, g.anno_mes_pcgc
FROM syn_edificio e
JOIN syn_departamento d ON e.id_edif = d.id_edif
LEFT JOIN syn_gasto_comun g ON d.id_edif = g.id_edif AND d.nro_depto = g.nro_depto
LEFT JOIN syn_pago_comun p ON g.anno_mes_pcgc = p.anno_mes_pcgc AND g.id_edif = p.id_edif AND g.nro_depto = p.nro_depto
WHERE p.fecha_cancelacion_pgc IS NULL;

CREATE OR REPLACE VIEW view_detalle_deptos_no_pago AS
SELECT e.nombre_edif, d.nro_depto, g.anno_mes_pcgc, g.fecha_desde_gc, g.fecha_hasta_gc, g.monto_total_gc
FROM syn_edificio e
JOIN syn_departamento d ON e.id_edif = d.id_edif
JOIN syn_gasto_comun g ON d.id_edif = g.id_edif AND d.nro_depto = g.nro_depto
WHERE g.fecha_pago_gc IS NULL;

-- Permisos para vistas
GRANT SELECT ON view_deptos_no_pago TO MDY2131_ET_FA_DES;
GRANT SELECT ON view_detalle_deptos_no_pago TO MDY2131_ET_FA_DES;
GRANT SELECT ON view_deptos_no_pago TO MDY2131_ET_FA_CON;
GRANT SELECT ON view_detalle_deptos_no_pago TO MDY2131_ET_FA_CON;

-- Informe 1: Totalización de departamentos que no han pagado los gastos comunes
SELECT nombre_edif, COUNT(nro_depto) AS deptos_no_pago
FROM view_deptos_no_pago
GROUP BY nombre_edif;

-- Informe 2: Información detallada de departamentos que no han pagado los gastos comunes
SELECT nombre_edif, nro_depto, anno_mes_pcgc, fecha_desde_gc, fecha_hasta_gc, monto_total_gc
FROM view_detalle_deptos_no_pago;

-- Alternativas de Información Detallada usando OPERADOR SET
CREATE OR REPLACE VIEW view_info_detalle_deptos_no_pago AS
SELECT
    pc.anno_mes_pcgc AS periodo_cobro,
    gc.id_edif AS id_edificio,
    e.nombre_edif AS nombre_edificio,
    gc.nro_depto AS numero_departamento,
    rpgc.numrun_rpgc AS run_responsable_pago,
    rpgc.pnombre_rpgc || ' ' || rpgc.appaterno_rpgc AS nombre_responsable_pago,
    gc.fecha_pago_gc AS fecha_pago,
    gc.monto_total_gc AS monto_total,
    gc.id_epago AS estado_pago
FROM syn_gasto_comun gc
JOIN syn_periodo_cobro pc ON gc.anno_mes_pcgc = pc.anno_mes_pcgc
JOIN syn_edificio e ON gc.id_edif = e.id_edif
JOIN syn_responsable_pago rpgc ON gc.numrun_rpgc = rpgc.numrun_rpgc
LEFT JOIN tmp_depto_no_pago t ON gc.id_edif = t.id_edif AND gc.nro_depto = t.nro_depto
WHERE t.id_edif IS NULL;

-- Permisos para vista detallada
GRANT SELECT ON view_info_detalle_deptos_no_pago TO MDY2131_ET_FA_DES;
GRANT SELECT ON view_info_detalle_deptos_no_pago TO MDY2131_ET_FA_CON;

-- Alternativas de Información Detallada usando subconsulta
CREATE OR REPLACE VIEW view_pendiente_detalle_deptos_no_pago AS
SELECT
    pc.anno_mes_pcgc AS periodo_cobro,
    gc.id_edif AS id_edificio,
    e.nombre_edif AS nombre_edificio,
    gc.nro_depto AS numero_departamento,
    rpgc.numrun_rpgc AS run_responsable_pago,
    rpgc.pnombre_rpgc || ' ' || rpgc.appaterno_rpgc AS nombre_responsable_pago,
    gc.fecha_pago_gc AS fecha_pago,
    gc.monto_total_gc AS monto_total,
    gc.id_epago AS estado_pago
FROM syn_gasto_comun gc
JOIN syn_periodo_cobro pc ON gc.anno_mes_pcgc = pc.anno_mes_pcgc
JOIN syn_edificio e ON gc.id_edif = e.id_edif
JOIN syn_responsable_pago rpgc ON gc.numrun_rpgc = rpgc.numrun_rpgc
LEFT JOIN tmp_depto_no_pago t ON gc.id_edif = t.id_edif AND gc.nro_depto = t.nro_depto
WHERE t.id_edif IS NULL
  AND gc.id_epago = (SELECT id_epago FROM syn_estado_pago WHERE descripcion_epago = 'PENDIENTE');

-- Permisos para vista con subconsulta
GRANT SELECT ON view_pendiente_detalle_deptos_no_pago TO MDY2131_ET_FA_DES;
GRANT SELECT ON view_pendiente_detalle_deptos_no_pago TO MDY2131_ET_FA_CON;

-- Actualización del estado de pago a "PENDIENTE"
UPDATE syn_gasto_comun gc
SET gc.id_epago = (SELECT id_epago FROM syn_estado_pago WHERE descripcion_epago = 'PENDIENTE')
WHERE EXISTS (
    SELECT 1
    FROM syn_gasto_comun_cero pgc
    WHERE pgc.anno_mes_pcgc = gc.anno_mes_pcgc
      AND pgc.id_edif = gc.id_edif
      AND pgc.nro_depto = gc.nro_depto
);
COMMIT;

-- Almacenamiento de información y actualización del estado de pago
CREATE TABLE tmp_depto_no_pago (
    id_edif NUMBER(5) NOT NULL,
    nro_depto NUMBER(5) NOT NULL
);

-- Insertar datos en la tabla temporal desde una subconsulta o procedimiento
INSERT INTO tmp_depto_no_pago
SELECT id_edif, nro_depto
FROM syn_gasto_comun
WHERE fecha_pago_gc IS NULL;

-- Actualización del estado de pago a "PENDIENTE"
UPDATE syn_gasto_comun
SET id_epago = (SELECT id_epago FROM syn_estado_pago WHERE descripcion_epago = 'PENDIENTE')
WHERE EXISTS (
    SELECT 1
    FROM tmp_depto_no_pago t
    WHERE t.id_edif = syn_gasto_comun.id_edif
    AND t.nro_depto = syn_gasto_comun.nro_depto
);
COMMIT;

-- Consultas de verificación para el usuario MDY2131_ET_FA_DES
SELECT *
FROM syn_gasto_comun_cero; 

SELECT * 
FROM syn_edificio;

SELECT * 
FROM syn_comuna;

SELECT * 
FROM syn_administrador;

SELECT * 
FROM syn_departamento;

SELECT * 
FROM syn_pago_comun;

SELECT *
FROM syn_forma_pago;

-- Consultas de verificación para el usuario MDY2131_ET_FA_CON
SELECT nombre_edif, COUNT(nro_depto) AS deptos_no_pago
FROM view_deptos_no_pago
GROUP BY nombre_edif;

SELECT nombre_edif, nro_depto, anno_mes_pcgc, fecha_desde_gc, fecha_hasta_gc, monto_total_gc
FROM view_detalle_deptos_no_pago;

SELECT
    periodo_cobro,
    id_edificio,
    nombre_edificio,
    numero_departamento,
    run_responsable_pago,
    nombre_responsable_pago,
    fecha_pago,
    monto_total,
    estado_pago
FROM view_info_detalle_deptos_no_pago;

SELECT
    periodo_cobro,
    id_edificio,
    nombre_edificio,
    numero_departamento,
    run_responsable_pago,
    nombre_responsable_pago,
    fecha_pago,
    monto_total,
    estado_pago
FROM view_pendiente_detalle_deptos_no_pago;

SELECT * FROM syn_edificio;
SELECT * FROM syn_comuna;
SELECT * FROM syn_forma_pago;
