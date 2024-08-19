--Funcion 1
CREATE OR REPLACE FUNCTION fn_cantidad_atenciones(p_rut_medico IN VARCHAR2, p_periodo IN VARCHAR2)
RETURN NUMBER IS

    v_can_atenciones NUMBER;

BEGIN
    SELECT COUNT(*) INTO v_can_atenciones
    FROM atencion   
    WHERE med_run = p_rut_medico
    AND fecha_atencion >= TO_DATE('01-' || p_periodo, 'DD-MM-YYYY')
    AND fecha_atencion < ADD_MONTHS(TO_DATE('01-' || p_periodo, 'DD-MM-YYYY'), 1);

    RETURN v_can_atenciones;
END;


--Funcion 2
CREATE OR REPLACE FUNCTION fn_promedio_sueldos(p_id_cargo IN NUMBER)
RETURN NUMBER IS

    v_sueldo_promedio NUMBER;

BEGIN
    SELECT ROUND(AVG(sueldo_base), 2) INTO v_sueldo_promedio
    FROM medico
    WHERE car_id = p_id_cargo;
    
    RETURN v_sueldo_promedio;
END;


--Funcion 3
CREATE OR REPLACE FUNCTION fn_periodo_atenciones(p_periodo IN VARCHAR2) 
RETURN NUMBER IS 

    v_costo_total NUMBER;

BEGIN
    SELECT SUM(costo) INTO v_costo_total
    FROM atencion
    WHERE fecha_atencion >= TO_DATE('01-' || p_periodo, 'DD-MM-YYYY')
    AND fecha_atencion < ADD_MONTHS(TO_DATE('01-' || p_periodo, 'DD-MM-YYYY'), 1);

    RETURN v_costo_total;
END;


--Funcion Informe
CREATE OR REPLACE PROCEDURE sp_generador_informes
(p_codigo_unidad IN NUMBER, p_periodo IN VARCHAR2)
IS
    v_costo_total NUMBER := 0;
BEGIN
    v_costo_total := NVL(fn_periodo_atenciones(p_periodo), 0);

    FOR registro IN (
        SELECT m.med_run, m.dv_run
        FROM medico m
        WHERE m.uni_id = p_codigo_unidad
    ) LOOP
        IF v_costo_total = 0 THEN
            INSERT INTO detalle_atenciones
            VALUES (
                TO_CHAR(registro.med_run) || '-' || registro.dv_run, 
                p_periodo, 
                0, 
                0, 
                0
            );
        ELSE
            INSERT INTO detalle_atenciones
            VALUES (
                TO_CHAR(registro.med_run) || '-' || registro.dv_run,
                p_periodo,
                fn_cantidad_atenciones(registro.med_run, p_periodo),
                NVL(fn_periodo_atenciones(p_periodo), 0),
                NVL(fn_periodo_atenciones(p_periodo), 0) / v_costo_total
            );
        END IF;
    END LOOP;

    FOR registro IN (
        SELECT
            m.med_run, 
            m.dv_run,
            m.pnombre || ' ' || m.snombre || ' ' || m.apaterno || ' ' || m.amaterno AS nombre_medico,
            m.car_id,  
            c.nombre AS nombre_cargo,
            u.nombre AS nombre_unidad,
            m.sueldo_base
        FROM
            medico m
        JOIN
            cargo c ON c.car_id = m.car_id
        JOIN
            unidad u ON u.uni_id = m.uni_id
        WHERE
            m.uni_id = p_codigo_unidad
    ) LOOP
        INSERT INTO resumen_medico
        VALUES (
            TO_CHAR(registro.med_run) || '-' || registro.dv_run,
            registro.nombre_medico,
            registro.nombre_cargo,
            registro.nombre_unidad,
            registro.sueldo_base,
            ABS(ROUND(NVL(fn_promedio_sueldos(registro.car_id), 0) - registro.sueldo_base, 0)),
            CASE
                WHEN NVL(fn_promedio_sueldos(registro.car_id), 0) < registro.sueldo_base THEN 'SI'
                ELSE 'NO'
            END
        );
    END LOOP;
    
    COMMIT; 
END sp_generador_informes;



--Generar informe
BEGIN
    sp_generador_informes(700, '06-2021');
    DBMS_OUTPUT.PUT_LINE('El informe ha sido generado exitosamente.');
END;


SELECT 
    * FROM detalle_atenciones;
    
SELECT *
FROM resumen_medico;
