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

-- Funcion 2

CREATE OR REPLACE FUNCTION fn_promedio_sueldos(p_id_cargo IN NUMBER)
RETURN NUMBER IS

v_sueldo_promedio NUMBER;

BEGIN
   SELECT ROUND(AVG(sueldo_base))
    INTO v_sueldo_promedio
    FROM medico
    WHERE car_id = p_id_cargo;
    
    RETURN v_sueldo_promedio;
END;

SET SERVEROUTPUT ON;
DECLARE
v_dato NUMBER;

BEGIN 
    v_dato := fn_promedio_sueldos(100);
    DBMS_OUTPUT.PUT_LINE('resultado: ' || v_dato);
END;

--Funcion 3

CREATE OR REPLACE FUNCTION fn_periodo_atenciones(p_periodo IN VARCHAR2) 
RETURN NUMBER IS 

v_costo_total NUMBER;
BEGIN
    SELECT SUM(costo)
    INTO v_costo_total
    FROM atencion
    WHERE fecha_atencion >= TO_DATE('01-' || p_periodo, 'DD-MM-YYYY')
    AND fecha_atencion < ADD_MONTHS(TO_DATE('01-' || p_periodo, 'DD-MM-YYYY'), 1);
    RETURN v_costo_total;
END;

SET SERVEROUTPUT ON;
DECLARE
v_dato NUMBER;
BEGIN
    v_dato := fn_periodo_atenciones('06-2023');

    IF(v_dato) IS NULL THEN
        DBMS_OUTPUT.PUT_LINE('Resultado: Sin datos');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Resultado: ' || v_dato);
        
    END IF;
END;



SELECT * FROM atencion;

--AND fecha_atencion >= TO_DATE(p_periodo || '-01', 'MM-YYYY-DD')
