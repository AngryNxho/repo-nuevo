CREATE OR REPLACE FUNCTION fn_cantidad_atenciones(p_rut_medico IN VARCHAR2, p_periodo IN VARCHAR2)
RETURN NUMBER IS

v_can_atenciones NUMBER;

BEGIN
    SELECT COUNT(*) INTO v_can_atenciones
    FROM atencion   
    WHERE med_run = p_rut_medico
    AND fecha_atencion >= TO_DATE(p_periodo || '-01', 'MM-YYYY-DD')
    AND fecha_atencion < ADD_MONTHS(TO_DATE(p_periodo || '-01', 'MM-YYYY-DD'), 1);
    RETURN v_can_atenciones;
END;


SET SERVEROUTPUT ON;
DECLARE
v_dato NUMBER;

BEGIN
    v_dato := fn_cantidad_atenciones('11959315', '06-2024');
    DBMS_OUTPUT.PUT_LINE('Cantidad de atenciones: ' || v_dato);
END;
