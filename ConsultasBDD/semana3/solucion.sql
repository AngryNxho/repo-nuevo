SELECT 
    RUN_EMP AS "RUN EMPLEADO",  -- Selecciona el identificador del empleado
    TO_CHAR(FECHA_INI_PRESTAMO, 'MM/YYYY') AS "MES PRESTAMOS LIBROS",  -- Formatea la fecha de inicio del préstamo a MM/YYYY
    COUNT(*) AS "TOTAL PRESTAMOS ATENDIDOS",  -- Cuenta el total de préstamos atendidos por el empleado en el mes
    COUNT(*) * 10000 AS "ASIGNACION POR PRESTAMOS"  -- Calcula la asignación por préstamos
FROM 
    PRESTAMO
WHERE 
    EXTRACT(YEAR FROM FECHA_INI_PRESTAMO) = EXTRACT(YEAR FROM SYSDATE) - 1  -- Filtra los préstamos del año anterior al año actual
GROUP BY 
    RUN_EMP, 
    TO_CHAR(FECHA_INI_PRESTAMO, 'MM/YYYY')  -- Agrupa por empleado y mes/año del préstamo
HAVING 
    COUNT(*) > 2  -- Incluye solo los empleados que atendieron más de 2 préstamos
ORDER BY 
    TO_CHAR(FECHA_INI_PRESTAMO, 'MM/YYYY') ASC,  -- Ordena por mes/año del préstamo en orden ascendente
    COUNT(*) * 10000 DESC,  -- Ordena por asignación en orden descendente
    RUN_EMP DESC;  -- Ordena por identificador del empleado en orden descendente
