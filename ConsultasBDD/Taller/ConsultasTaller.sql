SELECT TO_CHAR(SYSDATE, 'MM/YYYY') MES_ANNO_PROCESO,
nro_patente,
fecha_ini_arriendo,
dias_solicitados,
fecha_devolucion,
fecha_devolucion - fecha_ini_arriendo DIAS_ATRASO,
(fecha_devolucion - fecha_ini_arriendo) * &valor_diario VALOR_MULTA
FROM arriendo_camion
WHERE fecha_devolucion >= ADD_MONTHS(TRUNC(SYSDATE,'MM'),-1)
AND fecha_devolucion <= LAST_DAY(ADD_MONTHS(TRUNC(SYSDATE,'MM'),-1))
ORDER BY fecha_ini_arriendo, nro_patente;
