-- Practicando cursors
CREATE OR REPLACE FUNCTION fn_imprimir_nombre_medico(pnombre_med IN VARCHAR2, snombre_med IN VARCHAR2) 
RETURN VARCHAR2
IS

v_pnombre VARCHAR2(59);
v_snombre VARCHAR(50);
v_encontre_datos VARCHAR(50) DEFAULT('No encontre datos');

CURSOR n_medicos IS
    SELECT 
    pnombre, snombre
    FROM medico
    WHERE pnombre = pnombre_med;
BEGIN 
    OPEN n_medicos;
    LOOP
        FETCH n_medicos INTO v_pnombre, v_snombre;
        
    IF(n_medicos%FOUND) THEN
        dbms_output.put_line('Primer Nombre: ' || v_pnombre);
        dbms_output.put_line('Segundo Nombre: ' || v_snombre);

        v_encontre_datos:='Encontre Datos';
        
    ELSE 
        CLOSE n_medicos ;
        EXIT;
    END IF;
    EXIT WHEN n_medicos%NOTFOUND;
    END LOOP;
RETURN v_encontre_datos;
END;


SET SERVEROUTPUT ON;

DECLARE
v_dato VARCHAR2(50);

BEGIN
    v_dato := fn_imprimir_nombre_medico('Rosa', 'Elena');
    dbms_output.put_line('Resultado: ' || v_dato);
END;
