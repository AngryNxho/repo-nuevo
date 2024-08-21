--funcion 1
CREATE OR REPLACE FUNCTION fn_obtener_total_atenciones(
    p_esp_id NUMBER,
    p_periodo VARCHAR2
) RETURN NUMBER IS
    v_total_atenciones NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_total_atenciones
    FROM ATENCION
    WHERE esp_id = p_esp_id
    AND fecha_atencion >= TO_DATE('01-' || p_periodo, 'DD-MM-YYYY')
    AND fecha_atencion < ADD_MONTHS(TO_DATE('01-' || p_periodo, 'DD-MM-YYYY'), 1);
    
    RETURN v_total_atenciones;
END;


SET SERVEROUTPUT ON;
DECLARE
    v_dato NUMBER;
    v_esp_id NUMBER := 1400;  -- ID de la especialidad a consultar
    v_periodo VARCHAR2(7) := '06-2023';  -- Período en formato MM-YYYY
BEGIN
    -- Llamada a la función fn_obtener_total_atenciones
    v_dato := fn_obtener_total_atenciones(v_esp_id, v_periodo);
    
    -- Mostrar el resultado
    DBMS_OUTPUT.PUT_LINE('Total de atenciones para la especialidad ' || v_esp_id || ' en el período ' || v_periodo || ': ' || v_dato);
END;


--funcion2
CREATE OR REPLACE FUNCTION obtener_costo_total(
    p_esp_id NUMBER,
    p_periodo VARCHAR2
) RETURN NUMBER IS
    v_costo_total NUMBER;
BEGIN
    SELECT NVL(SUM(costo), 0)
    INTO v_costo_total
    FROM ATENCION
    WHERE esp_id = p_esp_id
    AND fecha_atencion >= TO_DATE('01-' || p_periodo, 'DD-MM-YYYY')
    AND fecha_atencion < ADD_MONTHS(TO_DATE('01-' || p_periodo, 'DD-MM-YYYY'), 1);
    
    RETURN v_costo_total;
END;
DECLARE
    v_costo_total NUMBER;
    v_esp_id NUMBER := 1400;  -- ID de la especialidad a consultar
    v_periodo VARCHAR2(7) := '05-2023';  -- Período en formato MM-YYYY
BEGIN
    -- Llamada a la función obtener_costo_total
    v_costo_total := obtener_costo_total(v_esp_id, v_periodo);
    
    -- Mostrar el resultado
    DBMS_OUTPUT.PUT_LINE('Costo total de atenciones para la especialidad ' || v_esp_id || ' en el período ' || v_periodo || ': ' || v_costo_total);
END;
