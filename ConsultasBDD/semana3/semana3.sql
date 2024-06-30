SELECT 
    TO_CHAR(run_emp, '09G999G999'), 
    TO_CHAR(fecha_ini_prestamo, 'MM/YYYY'),
    COUNT(*)
FROM 
    prestamo
WHERE 
    EXTRACT(YEAR FROM fecha_ini_prestamo) = (EXTRACT(YEAR FROM SYSDATE) - 1) 
GROUP BY 
    run_emp,
    TO_CHAR(fecha_ini_prestamo, 'MM/YYYY')

HAVING 
    COUNT(*) > 2
ORDER BY   
    TO_CHAR(fecha_ini_prestamo, 'MM/YYYY') ASC,
    COUNT(*) DESC,
    run_emp DESC;
