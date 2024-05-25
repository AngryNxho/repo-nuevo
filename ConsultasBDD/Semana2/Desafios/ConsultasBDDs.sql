
--Actividad Truck Rental

--Desafio 1
-- Solucion mia 
SELECT (numrun_cli || '-' || dvrun_cli) AS "RUN CLIENTE",
(LOWER(pnombre_cli) || ' '|| INITCAP(snombre_cli) || ' ' || appaterno_cli || ' ' || apmaterno_cli )AS "NOMBRE COMPLETO CLIENTE",
fecha_nac_cli "FECHA NACIMIENTO",
celular_cli CELULAR,
fono_fijo_cli "FONO FIJO"
FROM CLIENTE
WHERE (EXTRACT(DAY FROM fecha_nac_cli) = 21 AND EXTRACT(MONTH FROM fecha_nac_cli) = 8)
ORDER BY appaterno_cli; 

//Solucion correcta que no me funciona
--SELECT (numrun_cli || '-' || dvrun_cli) AS "RUN CLIENTE",
--(LOWER(pnombre_cli) || ' '|| INITCAP(snombre_cli) || ' ' || appaterno_cli || ' ' || apmaterno_cli )AS "NOMBRE COMPLETO CLIENTE",
--fecha_nac_cli "FECHA NACIMIENTO",
--celular_cli CELULAR,
--fono_fijo_cli "FONO FIJO"
--FROM CLIENTE
--WHERE (EXTRACT(DAY FROM fecha_nac_cli)) = EXTRACT(DAY FROM SYSDATE) + 1
--AND EXTRACT(MONTH FROM fecha_nac_cli) = EXTRACT(MONTH FROM SYSDATE)
--ORDER BY appaterno_cli;




--DESAFIO 2

SELECT (numrun_emp || ' ' || dvrun_emp) "RUN EMPLEADO", 
(pnombre_emp || ' '|| snombre_emp || ' ' || appaterno_emp || ' ' || apmaterno_emp) "NOMBRE COMPLETO EMPLEADO",
sueldo_base "SUELDO BASE",
TRUNC(sueldo_base/100000) "PORCENTAJE MOVILIZACION",
ROUND(sueldo_base * TRUNC(sueldo_base/100000)/100) "VALOR MOVILIZACION"
FROM empleado
ORDER BY 4 DESC;

-- DESFAIO 3

SELECT numrun_emp || '' ||
dvrun_emp "RUN EMPLEADO",
pnombre_emp || '' ||
snombre_emp || '' ||
appaterno_emp || '' ||
apmaterno_emp "NOMBRE COMPLETO EMPLEADO",
sueldo_base "SUELDO BASE",
fecha_nac "FECHA NACIMIENTO",
UPPER(SUBSTR(pnombre_emp,1,3)) ||
LENGTH(pnombre_emp) || '*' ||
SUBSTR(sueldo_base,-1,1) ||
dvrun_emp ||
TO_CHAR(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM fecha_contrato))
"NOMBRE USUARIO",
SUBSTR(numrun_emp,3,1) ||
TO_CHAR(EXTRACT(YEAR FROM fecha_contrato)+2) ||
SUBSTR(TO_CHAR(sueldo_base-1), -3, 3) ||
SUBSTR(appaterno_emp,-2,2) ||
TRUNC(TO_CHAR(SYSDATE,'MM')) "CLAVE"
FROM empleado
ORDER BY appaterno_emp;

-- DESAFIO 5
SELECT TO_CHAR(SYSDATE, 'MM/YYYY') MES_ANNO_PROCESO,
nro_patente,
fecha_ini_arriendo,
dias_solicitados,
fecha_devolucion,
fecha_devolucion - fecha_ini_arriendo DIAS_ATRASO,
(fecha_devolucion - fecha_ini_arriendo) * &valor_diario VALOR_MULTA
FROM arriendo_camion
WHERE fecha_devolucion >= ADD_MONTHS(TRUNC(SYSDATE,'MM'),-1)
AND fecha_devolucion <= LAST_DAY(ADD_MONTHS(TRUNC(SYSDATE,'MM'),-1))
ORDER BY fecha_ini_arriendo, nro_patente;
