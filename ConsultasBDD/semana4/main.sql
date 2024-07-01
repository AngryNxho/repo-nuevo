SELECT TO_CHAR(numrun, '09G999G999') || '-' || dvrun,
    PNOMBRE || ' ' || SNOMBRE || ' ' || APPATERNO || ' ' || APMATERNO "NOMBRE CLIENTE"
FROM cliente
ORDER BY appaterno ASC;

SELECT cod_credito FROM CREDITO_CLIENTE;


