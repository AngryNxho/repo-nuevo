        SELECT EXTRACT(YEAR FROM SYSDATE), 
        TO_CHAR(numrun_emp, '99G999G999') || '-' || dvrun_emp "RUN EMPLEADO",
        pnombre_emp || ' ' || snombre_emp || ' ' || appaterno_emp || ' ' || apmaterno_emp "NOMBRE EMPLEADO", 
        CASE
        WHEN EXTRACT(YEAR FROM fecha_contrato) < EXTRACT(YEAR FROM sysdate) - 1 THEN
        --Si fue contratado antes del año en estudio, se entiende que trabajó todo el año tributario

        --Por ende trabajó 12 meses
                12
        ELSE
        --Sino fue contratado antes del año de estudio, hay que contar cuántos meses trabajó en el año
        --Se cuentan los meses trabajados desde 31-dic del año tributario a la fecha que fue contratado
                ROUND(MONTHS_BETWEEN(TO_DATE('31/12/' || TO_CHAR(fecha_contrato, 'YY'),'DD/MM/YY'),fecha_contrato),1)
        END AS "MESES TRABAJADOS EN EL AÑO" ,
        
        EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM fecha_contrato) - 1 "AÑOS TRABAJADOS",
        --El cálculo de los meses trabajados se repite en todos los cálculos
        ROUND(sueldo_base /12 * 
                CASE
                WHEN EXTRACT(YEAR FROM fecha_contrato) < EXTRACT(YEAR FROM sysdate) - 1 THEN
                        12
                ELSE
                        ROUND(months_between(TO_DATE('31/12/' || TO_CHAR(fecha_contrato, 'YY'),'DD/MM/YY'),fecha_contrato),1)
                END
                ,0) AS "SUELDO BASE MENSUAL",
                
                ROUND(sueldo_base  * 
                CASE
                WHEN EXTRACT(YEAR FROM fecha_contrato) < EXTRACT(YEAR FROM sysdate) - 1 THEN
                        12
                ELSE
                        ROUND(months_between(TO_DATE('31/12/' || TO_CHAR(fecha_contrato, 'YY'),'DD/MM/YY'),fecha_contrato),1)
                END
                ,0) AS "SUELDO BASE ANUAL"
        FROM empleado
        ORDER BY numrun_emp;
