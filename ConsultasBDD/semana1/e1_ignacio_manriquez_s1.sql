--CASO 1
SELECT (nombre_emp || ' ' || appaterno_emp || ' ' || apmaterno_emp) AS "Nombre Empleado", 
sueldo_emp SSALARIO,
(sueldo_emp * 0.055) COLACION,
(sueldo_emp * 0.178) MOVILIZACION,
(sueldo_emp * 0.078) SALUD,
(sueldo_emp * 0.065) AFP,
((sueldo_emp) + (sueldo_emp * 0.178) +(sueldo_emp * 0.055) - (sueldo_emp * 0.078) - (sueldo_emp * 0.065)) "ALCANCE LÍQUIDO"
FROM empleado
ORDER BY appaterno_emp ASC;

--CASO 2