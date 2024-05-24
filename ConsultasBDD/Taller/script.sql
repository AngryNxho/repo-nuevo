SELECT numrun_cli || '-' || dvrun_cli,fecha_nac_cli 
FROM CLIENTE
WHERE (EXTRACT(MONTH FROM fecha_nac_cli) = 8 AND EXTRACT(DAT FROM fecha_nac_cli) > 20)
ORDER BY fecha_nac_cli;

