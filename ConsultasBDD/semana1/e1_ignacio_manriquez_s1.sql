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


SELECT nro_propiedad "NUMERO PROPIEDAD", 
TO_CHAR(fecha_entrega_propiedad, 'DD/MM/YYYY') "FECHA ENTREGA_PROPIEDAD",
direccion_propiedad DIRECCION,
superficie SUPERFICIE,
nro_dormitorios "CANTIDAD DE DORMITORIOS",
nro_banos "CANTIDAD DE BAÑOS",
valor_arriendo "VALOR DEL ARRIENDO"
FROM propiedad 
WHERE EXTRACT(YEAR FROM fecha_entrega_propiedad) = 2024
ORDER BY fecha_entrega_propiedad;