
-- creacion de funcion para obtener la especialidad del doctor.

create or replace function fn_nombre_especialidad(id_esp IN NUMBER) return varchar2 is

v_nombre_especialidad especialidad.nombre%TYPE;

begin

    select 
        nombre
        into 
        v_nombre_especialidad
    from especialidad
    where esp_id=id_esp;
    
    return v_nombre_especialidad;

end;

--bloque anonimo para probar la funcion

declare
 v_dato varchar2(50);
begin
    v_dato := fn_nombre_especialidad(200);
    DBMS_OUTPUT.put_line('ESPECIALIDAD ::'||v_dato);
end;



-- creacion de funcion que lista los doctores a partir de la fecha de contrato
-- en esta funcion se invoca la funcion creada anteriormente de nombre fn_nombre_especialidad

create or replace function fn_lista_doctores(fecha_contrato_in IN varchar2) return varchar2 is

v_rut_medico varchar2(20);
v_nombre_completo_medico varchar2(200);
v_unidad medico.uni_id%TYPE;

v_encontre_datos varchar2(50) DEFAULT('No encontre datos');

v_nombre_especialidad varchar2(50);

cursor c_doctores is
    select 
    med_run||'-'||dv_run,
    pnombre ||' '||snombre||' '||apaterno||' '||amaterno,
    uni_id
    from medico
    where to_char(fecha_contrato,'mm-yyyy')=fecha_contrato_in;
    --12-2013

begin

  open c_doctores;
  loop
    fetch c_doctores into v_rut_medico,v_nombre_completo_medico,v_unidad;
    
    IF(c_doctores%FOUND) THEN
    DBMS_OUTPUT.put_line('******************************');
    DBMS_OUTPUT.put_line('RUT DOCTOR: '||v_rut_medico);
    DBMS_OUTPUT.put_line('NOMBRE DOCTOR: '||v_nombre_completo_medico);
    DBMS_OUTPUT.put_line('UNIDAD DOCTOR: '||v_unidad);    
    
    v_nombre_especialidad:=fn_nombre_especialidad(v_unidad);
    DBMS_OUTPUT.put_line('GLOSA UNIDAD DOCTOR: '||v_nombre_especialidad); 
    
    v_encontre_datos:='Encontre datos';
    ELSE
   
      CLOSE c_doctores;
      EXIT;
    END IF;
  exit when c_doctores%NOTFOUND;
  end loop;
return v_encontre_datos;
end;

--bloque anonimo para probar la funcion

declare
 v_dato varchar2(50);
begin
    v_dato := fn_lista_doctores('12-2013');
    DBMS_OUTPUT.put_line('RESULTADO ::'||v_dato);
end;




