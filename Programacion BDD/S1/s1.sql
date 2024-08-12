

-- -- funcion 1
-- CREATE OR REPLACE FUNCTION fn_periodo_atencion(fec_periodo IN VARCHAR2) 
-- RETURN NUMBER IS 
--     v_cantidad NUMBER;
    
-- BEGIN
--     SELECT 
--         COUNT(*)
--     INTO
--         v_cantidad
--     FROM 
--         atencion
--     WHERE TO_CHAR(fecha_atencion, 'mm-yyyy') = fec_periodo;
--     RETURN v_cantidad;
-- END;


-- SET SERVEROUTPUT ON;

-- DECLARE
--     v_periodo VARCHAR(7) := '10-2022';
--     v_cantidad NUMBER;
    
-- BEGIN 
--     v_cantidad := fn_periodo_atencion(v_periodo);
--     DBMS_OUTPUT.PUT_LINE('+++++++++++++++++++++++++++++++++++++++++');
--     DBMS_OUTPUT.PUT_LINE('------------Total atenciones: ' || v_cantidad);
-- END;


-- -- funcion 2



CREATE OR REPLACE FUNCTION periodo_especialidad(p_esp_id IN NUMBER, fec_periodo IN VARCHAR2) 
RETURN NUMBER IS
    v_cantidad NUMBER;
BEGIN 
    SELECT 
         COUNT(*)
     INTO
         v_cantidad
     FROM 
         atencion
     WHERE 
        (TO_CHAR(fecha_atencion, 'mm-yyyy') = fec_periodo)
        AND esp_id = p_esp_id;
     RETURN v_cantidad;
END;


SET SERVEROUTPUT ON;

DECLARE
    v_periodo VARCHAR2(7) := '08-2023'; 
    v_esp_id NUMBER := 1;                
    v_cantidad NUMBER;                   
BEGIN 
    v_cantidad := periodo_especialidad(v_esp_id, v_periodo);
    
    DBMS_OUTPUT.PUT_LINE('Cantidad de atenciones para la especialidad ' || v_esp_id || ' en el periodo ' || v_periodo || ': ' || v_cantidad);
END;
/



