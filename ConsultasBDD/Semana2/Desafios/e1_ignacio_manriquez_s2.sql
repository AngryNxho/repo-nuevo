--CASO 1
ALTER SESSION SET NLS_DATE_FORMAT='DD-mm-yy';
SELECT EXTRACT(YEAR FROM SYSDATE)"AÑO TRIBUTARIO",
    (TO_CHAR(numrun_emp,'99G999G999') 
    || '-' || dvrun_emp) "RUN EMPLEADO",
    (pnombre_emp || '-' ||snombre_emp || '-' || appaterno_emp || '-' || apmaterno_emp) "NOMBRE EMPLEADO",
    CASE 
    WHEN EXTRACT(YEAR FROM SYSDATE) - 1 = EXTRACT(YEAR FROM fecha_contrato)
    THEN ROUND(MONTHS_BETWEEN(TO_DATE('3112' || EXTRACT(YEAR FROM fecha_contrato)), fecha_contrato), 1)
    ELSE 12
    END "MESES TRABAJADOS EN EL AÑO",
    ((EXTRACT(YEAR FROM SYSDATE) - 1) - EXTRACT(YEAR FROM fecha_contrato))"AÑOS TRABAJADOS",
    sueldo_base "SUELDO BASE MENSUAL",
    sueldo_base * 12 "SUELDO BASE ANUAL",
    CASE 
    WHEN (EXTRACT(YEAR FROM SYSDATE)) - EXTRACT(YEAR FROM fecha_contrato) > 1
    THEN TRUNC(sueldo_base * 12 * (EXTRACT(YEAR FROM SYSDATE) -1 - EXTRACT(YEAR FROM fecha_contrato)) / 100)
    ELSE 0
    END AS "BONOS POR AÑO ACTUAL",
    ROUND((sueldo_base * 0.12) * 12) "MOVILIZACION ANUAL"

FROM empleado
ORDER BY numrun_emp ASC;

--CASO 2
SELECT
    ROUND((sueldo_base * 0.12) * 12) "MOVILIZACION ANUAL",
    ROUND((sueldo_base * .2) * 12) "COLACION ANUAL",
    (sueldo_base * 12 + 
    CASE 
        WHEN (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM fecha_contrato)) > 1
        THEN TRUNC(sueldo_base * 12 * (EXTRACT(YEAR FROM SYSDATE) - 1 - EXTRACT(YEAR FROM fecha_contrato)) / 100)
        ELSE 0
    END + 
    ROUND((sueldo_base * 0.12) * 12) + 
    ROUND((sueldo_base * 0.2) * 12)) AS "SUELDO BRUTO",
    (sueldo_base * 12 + CASE 
        WHEN (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM fecha_contrato)) > 1
        THEN TRUNC(sueldo_base * 12 * (EXTRACT(YEAR FROM SYSDATE) - 1 - EXTRACT(YEAR FROM fecha_contrato)) / 100)
        ELSE 0
    END) "RENTA IMPONIBLE ANUAL"
FROM empleado
ORDER BY numrun_emp ASC;
--•	Sueldo bruto: sueldo base + bono por años trabajados + movilización + colación.
--•	Renta imponible afecta a impuesto único: sueldo base + bono por años trabajados.
