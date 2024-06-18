--CASO 1

VARIABLE total_ganancias NUMBER;
EXEC :total_ganancias := 2250000000;
VARIABLE total_ganancias NUMBER;
EXEC :total_ganancias := 2250000000;

WITH medicos_con_atenciones AS (
    SELECT m.med_run, 
           m.pnombre || ' ' || m.snombre || ' ' || m.apaterno || ' ' || m.amaterno AS nombre, 
           m.sueldo_base, 
           COUNT(a.med_run) AS total_atenciones
    FROM MEDICO m
    JOIN ATENCION a ON m.med_run = a.med_run
    GROUP BY m.med_run, m.pnombre, m.snombre, m.apaterno, m.amaterno, m.sueldo_base
    HAVING COUNT(a.med_run) > 7
),

bonificacion_medicos AS (
    SELECT med_run, 
           nombre, 
           sueldo_base, 
           total_atenciones,
           (:total_ganancias * 0.05) / (SELECT COUNT(*) FROM medicos_con_atenciones) AS bonificacion
    FROM medicos_con_atenciones
)

SELECT med_run AS "RUN MEDICO",
       nombre AS "NOMBRE MEDICO",
       total_atenciones AS "TOTAL ATENCIONES MEDICAS",
       TO_CHAR(sueldo_base, 'L999G999D99') AS "SUELDO BASE",
       TO_CHAR(bonificacion, 'L999G999D99') AS "BONIFICACION POR GANANCIAS",
       TO_CHAR(sueldo_base + bonificacion, 'L999G999D99') AS "SUELDO TOTAL"
FROM bonificacion_medicos
ORDER BY med_run, nombre;


-- CASO 2

VARIABLE total_ganancias NUMBER;
EXEC :total_ganancias := 2250000000;

WITH medicos_con_atenciones AS (
    SELECT m.med_run, 
           m.pnombre || ' ' || m.snombre || ' ' || m.apaterno || ' ' || m.amaterno AS nombre, 
           m.sueldo_base, 
           COUNT(a.med_run) AS total_atenciones
    FROM MEDICO m
    JOIN ATENCION a ON m.med_run = a.med_run
    GROUP BY m.med_run, m.pnombre, m.snombre, m.apaterno, m.amaterno, m.sueldo_base
),

medicos_mas_7 AS (
    SELECT med_run, nombre, sueldo_base, total_atenciones,
           'MEDICO CON BONIFICACION DEL 5% DE LAS GANANCIAS' AS tipo_bonificacion,
           (:total_ganancias * 0.05) / (SELECT COUNT(*) FROM medicos_con_atenciones WHERE total_atenciones > 7) AS bonificacion
    FROM medicos_con_atenciones
    WHERE total_atenciones > 7
),

medicos_menos_igual_7 AS (
    SELECT med_run, nombre, sueldo_base, total_atenciones,
           'MEDICO CON BONIFICACION DEL 2% DE LAS GANANCIAS' AS tipo_bonificacion,
           (:total_ganancias * 0.02) / (SELECT COUNT(*) FROM medicos_con_atenciones WHERE total_atenciones <= 7) AS bonificacion
    FROM medicos_con_atenciones
    WHERE total_atenciones <= 7
)

SELECT tipo_bonificacion AS "BONIFICACION GANANCIAS",
       med_run AS "RUN MEDICO",
       nombre AS "NOMBRE MEDICO",
       total_atenciones AS "TOTAL ATENCIONES MEDICAS",
       TO_CHAR(sueldo_base, 'L999G999D99') AS "SUELDO BASE",
       TO_CHAR(bonificacion, 'L999G999D99') AS "BONIFICACION POR GANANCIAS",
       TO_CHAR(sueldo_base + bonificacion, 'L999G999D99') AS "SUELDO TOTAL"
FROM medicos_mas_7
UNION ALL
SELECT tipo_bonificacion AS "BONIFICACION GANANCIAS",
       med_run AS "RUN MEDICO",
       nombre AS "NOMBRE MEDICO",
       total_atenciones AS "TOTAL ATENCIONES MEDICAS",
       TO_CHAR(sueldo_base, 'L999G999D99') AS "SUELDO BASE",
       TO_CHAR(bonificacion, 'L999G999D99') AS "BONIFICACION POR GANANCIAS",
       TO_CHAR(sueldo_base + bonificacion, 'L999G999D99') AS "SUELDO TOTAL"
FROM medicos_menos_igual_7
ORDER BY "RUN MEDICO";
