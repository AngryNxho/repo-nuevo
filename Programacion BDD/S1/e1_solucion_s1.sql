--FUNCION PARA CONTAR ATENCIONES
CREATE OR REPLACE FUNCTION fn_cantidad_atenciones(mes_requerido VARCHAR2)
  RETURN NUMBER
IS
  v_cant_atenciones NUMBER;
BEGIN
  SELECT count(ate_id)
  INTO   v_cant_atenciones
  FROM   atencion
  WHERE  to_char(fecha_atencion,'mm-yyyy') = mes_requerido;
  
  RETURN v_cant_atenciones;
END;


--FUNCION PARA CONTAR ATENCIONES SEGUN ESPECIALIDAD
CREATE OR REPLACE FUNCTION fn_cant_aten_esp(mes_requerido VARCHAR2,
                                            id_esp        VARCHAR2)
  RETURN NUMBER
IS
  v_cant_aten_esp NUMBER;
BEGIN
  SELECT count(ate_id)
  INTO   v_cant_aten_esp
  FROM   atencion
  WHERE  to_char(fecha_atencion,'mm-yyyy') = mes_requerido
  AND    esp_id = id_esp;
  
  RETURN v_cant_aten_esp;
END;


--FUNCION PARA CALCULAR COSTO SEGUN ESPECIALIDAD
CREATE OR REPLACE FUNCTION fn_costo_esp(mes_requerido VARCHAR2,
                                        id_esp        VARCHAR2)
  RETURN NUMBER
IS
  v_costo_esp NUMBER;
BEGIN
  SELECT avg(costo)
  INTO   v_costo_esp
  FROM   atencion
  WHERE  to_char(fecha_atencion,'mm-yyyy') = mes_requerido
  AND    esp_id = id_esp;
  
  RETURN v_costo_esp;
END;


--FUNCION PARA GENERAR INFORME
CREATE OR REPLACE FUNCTION fn_informe(mes_requerido VARCHAR2)
  RETURN BOOLEAN
IS
  v_retorno          BOOLEAN:=FALSE;
  v_especialidad     VARCHAR2(40);
  v_esp_id           NUMBER;
  v_atenciones_total NUMBER;
  v_costo            NUMBER;
  v_atencion_esp     NUMBER;
  v_porcentaje       NUMBER;
  CURSOR c_especialidades IS
    SELECT DISTINCT e.nombre,
                    e.esp_id
    FROM            especialidad e
    join            atencion a
    ON              e.esp_id=a.esp_id
    WHERE           to_char(fecha_atencion,'mm-yyyy') = mes_requerido;

BEGIN
  OPEN c_especialidades;
  LOOP
    FETCH c_especialidades
    INTO  v_especialidad,
          v_esp_id;
    
    EXIT
  WHEN c_especialidades%NOTFOUND;
    v_costo:=ROUND(fn_costo_esp(mes_requerido,v_esp_id),2);
    v_atenciones_total:=fn_cantidad_atenciones(mes_requerido);
    v_atencion_esp:=fn_cant_aten_esp(mes_requerido,v_esp_id);
    v_porcentaje:=ROUND((v_atencion_esp/v_atenciones_total)*100,2);
    dbms_output.Put_line ('+++++++++++++++++++++++++++++++++++++');
    dbms_output.Put_line (v_especialidad);
    dbms_output.Put_line ('------Costo promedio: $'||v_costo);
    dbms_output.Put_line ('------Total atenciones: '||v_atenciones_total);
    dbms_output.Put_line ('------% del total: '||v_porcentaje);
    v_retorno:=TRUE;
  END LOOP;
  CLOSE c_especialidades;
  RETURN v_retorno;
END;

--BLOQUE ANONIMO PARA PROBAR TODA LA SOLUCION
DECLARE
  --puedo probar con 01-2024
  v_num_atenciones NUMBER;
  v_mes_requerido  VARCHAR2(10):='&v_mes_requerido';
  v_informe        BOOLEAN;
BEGIN
  v_num_atenciones:=fn_cantidad_atenciones(v_mes_requerido);
  v_informe:=fn_informe(v_mes_requerido);
  IF v_informe THEN
    dbms_output.put_line('Informe generado correctamente');
  ELSE
    dbms_output.put_line('Informe no generado');
  END IF;
  dbms_output.put_line('Cantidad de atenciones del periodo:' ||v_num_atenciones);
END;