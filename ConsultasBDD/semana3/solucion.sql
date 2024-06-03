SELECT 
    TO_CHAR(run_emp, '09G999G999') AS "RUN EMPLEADO",
    TO_CHAR(fecha_ini_prestamo, 'MM/YYYY') AS "MES PRESTAMOS LIBROS",  
    COUNT(*) AS "TOTAL PRESTAMOS ATENDIDOS", 
    '$' || TO_CHAR(COUNT(*) * 10000, '99G999') AS "ASIGNACION POR PRESTAMOS"  
FROM 
    prestamo
WHERE 
    EXTRACT(YEAR FROM fecha_ini_prestamo) = EXTRACT(YEAR FROM SYSDATE) - 1  
GROUP BY 
    run_emp, 
    TO_CHAR(fecha_ini_prestamo, 'MM/YYYY')  
HAVING 
    COUNT(*) > 2  
ORDER BY 
    TO_CHAR(fecha_ini_prestamo, 'MM/YYYY') ASC, 
    COUNT(*) * 10000 DESC, 
    run_emp DESC;
