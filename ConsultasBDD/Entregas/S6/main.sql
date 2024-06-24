ALTER SESSION SET NLS_DATE_FORMAT = 'DD/MM/YYYY';

DELETE FROM bonif_arriendos_mensual
WHERE anno_mes = TO_CHAR(SYSDATE, 'YYYYMM');

INSERT INTO bonif_arriendos_mensual(
    anno_mes, numrun_emp, nombre_empleado, sueldo_base, total_arriendos_mensual, bonif_por_arriendos
)
SELECT 
    TO_CHAR(SYSDATE, 'YYYYMM') AS ANNO_MES,
    emp.numrun_emp,
    TRIM(emp.pnombre_emp || ' ' || NVL(emp.snombre_emp, '') || ' ' || emp.appaterno_emp || ' ' || emp.apmaterno_emp) AS NOMBRE_EMPLEADO,
    emp.sueldo_base,
    COUNT(arr.id_arriendo) AS TOTAL_ARRIENDOS_MENSUAL,
    ROUND(emp.sueldo_base * COUNT(arr.id_arriendo) / 100) AS BONIF_POR_ARRIENDOS
FROM 
    empleado emp
JOIN
    camion cam ON emp.numrun_emp = cam.numrun_emp
JOIN
    arriendo_camion arr ON arr.nro_patente = cam.nro_patente
WHERE
    TO_CHAR(arr.fecha_ini_arriendo, 'YYYYMM') = TO_CHAR(SYSDATE, 'YYYYMM')
GROUP BY
    emp.numrun_emp,
    emp.pnombre_emp,
    emp.snombre_emp,
    emp.appaterno_emp,
    emp.apmaterno_emp,
    emp.sueldo_base
ORDER BY
    emp.appaterno_emp, emp.apmaterno_emp, emp.pnombre_emp, emp.snombre_emp;

SELECT *
FROM bonif_arriendos_mensual
WHERE ANNO_MES = TO_CHAR(SYSDATE, 'YYYYMM');


-- CASO 2

-- Consulta para obtener datos de los profesionales
SELECT 
    p.numrun_prof AS "RUN PROFESIONAL",
    TRIM(p.appaterno || ' ' || p.apmaterno || ' ' || p.nombre) AS "NOMBRE PROFESIONAL",
    prof.nombre_profesion AS "PROFESION"
FROM 
    profesional p
JOIN 
    profesion prof ON p.cod_profesion = prof.cod_profesion
ORDER BY 
    p.appaterno, p.apmaterno, p.nombre;


