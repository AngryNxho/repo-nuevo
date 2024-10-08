﻿/* Creación de usuario si está trabajando con BD Oracle Cloud */
CREATE USER MDY2231_P6 
IDENTIFIED BY "MDY2231.practica_6"
DEFAULT TABLESPACE "DATA"
TEMPORARY TABLESPACE "TEMP";

ALTER USER MDY2231_P6 QUOTA UNLIMITED ON DATA;

GRANT CREATE SESSION TO MDY2231_P6;
GRANT "RESOURCE" TO MDY2231_P6;

ALTER USER MDY2231_P6 DEFAULT ROLE "RESOURCE"