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
    sueldo_base * 12 "SUELDO BASE MENSUAL",
    CASE WHEN (EXTRACT(YEAR FROM SYSDATE)) - EXTRACT(YEAR FROM fecha_contrato) >= 12
    THEN ((sueldo_base * 0.012) * 12)
    ELSE (sueldo_base * 1.05)
    END AS "BONOS POR AÑO ACTUAL"
FROM empleado
ORDER BY numrun_emp ASC;

