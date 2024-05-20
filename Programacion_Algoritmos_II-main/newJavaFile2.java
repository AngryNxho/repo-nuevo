import java.util.Scanner;
public class newJavaFile2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese clave de seguridad:");
        String clave = lector.nextLine();
        String caracteres = "abcdefghijklmnñopqrstuvwxyz";
        String numeros = "1234567890";
        clave = clave.toLowerCase();
        System.out.println(clave);-- borrado de objetos
        DROP TABLE estado_civil CASCADE CONSTRAINTS;
        DROP TABLE propiedad CASCADE CONSTRAINTS;
        DROP TABLE empleado CASCADE CONSTRAINTS;
        DROP TABLE propietario CASCADE CONSTRAINTS;
        DROP TABLE cliente CASCADE CONSTRAINTS;
        DROP TABLE tipo_propiedad CASCADE CONSTRAINTS;
        DROP TABLE comuna CASCADE CONSTRAINTS;
        DROP TABLE categoria_empleado CASCADE CONSTRAINTS;
        DROP TABLE propiedad_arrendada CASCADE CONSTRAINTS;
        DROP SEQUENCE sq_cat;
        DROP SEQUENCE sq_com;
         
        -- creacion de objetos
        CREATE SEQUENCE sq_cat;
        CREATE SEQUENCE sq_com START WITH 80;
        
        CREATE TABLE comuna (
            id_comuna NUMBER(3) NOT NULL,
            nombre_comuna VARCHAR2(30) NOT NULL,
            CONSTRAINT pk_comuna PRIMARY KEY (id_comuna)
        );
        
        CREATE TABLE categoria_empleado (
            id_categoria_emp NUMBER(1) NOT NULL,
            desc_categoria_emp VARCHAR2(30) NOT NULL,
            CONSTRAINT pk_categoria_empleado PRIMARY KEY (id_categoria_emp)
        );
        
        CREATE TABLE tipo_propiedad (
            id_tipo_propiedad VARCHAR2(1) NOT NULL,
            desc_tipo_propiedad VARCHAR2(30) NOT NULL,
            CONSTRAINT pk_tipo_propiedad PRIMARY KEY (id_tipo_propiedad)
        );
        
        CREATE TABLE estado_civil (
            id_estcivil NUMBER(1) NOT NULL,
            desc_Estcivil VARCHAR2(25) NOT NULL,
            CONSTRAINT pk_estado_civil PRIMARY KEY(id_estcivil)
        );
        
        CREATE TABLE propietario (
            numrut_prop NUMBER(10) NOT NULL,
            dvrut_prop VARCHAR2(1) NOT NULL,
            appaterno_prop VARCHAR2(15) NOT NULL,
            apmaterno_prop VARCHAR2(15) NOT NULL,
            nombre_prop VARCHAR2(25) NOT NULL,
            direccion_prop VARCHAR2(60) NOT NULL,
            id_estcivil NUMBER(1) NOT NULL,
            fonofijo_prop VARCHAR2(15) NOT NULL,
            celular_prop VARCHAR2(15),
            id_comuna NUMBER(3),
            CONSTRAINT pk_propietario PRIMARY KEY (numrut_prop)
        );
        
        CREATE TABLE cliente (
            numrut_cli NUMBER(10) NOT NULL,
            dvrut_cli VARCHAR2(1) NOT NULL,
            appaterno_cli VARCHAR2(15) NOT NULL,
            apmaterno_cli VARCHAR2(15) NOT NULL,
            nombre_cli VARCHAR2(25) NOT NULL,
            direccion_cli VARCHAR2(60) NOT NULL,
            id_estcivil NUMBER(1) NOT NULL, 
            fonofijo_cli VARCHAR2(15),
            celular_cli VARCHAR2(15),
            renta_cli NUMBER(7) NOT NULL,
            CONSTRAINT pk_cliente PRIMARY KEY (numrut_cli)
        );
        
        CREATE TABLE empleado (
            numrut_emp NUMBER(10) NOT NULL,
            dvrut_emp VARCHAR2(1) NOT NULL,
            appaterno_emp VARCHAR2(15) NOT NULL,
            apmaterno_emp VARCHAR2(15) NOT NULL,
            nombre_emp VARCHAR2(25) NOT NULL,
            direccion_emp VARCHAR2(60) NOT NULL,
            id_estcivil NUMBER(1) NOT NULL,
            fonofijo_emp VARCHAR2(15) NOT NULL,
            celular_emp VARCHAR2(15),
            fecnac_emp DATE,
            fecing_emp DATE NOT NULL,
            sueldo_emp NUMBER(7) NOT NULL,
            id_comuna NUMBER(3),
            id_categoria_emp NUMBER(1),
            numrut_supervisor NUMBER(10),
            CONSTRAINT pk_empleado PRIMARY KEY (numrut_emp)
        );
        
        CREATE TABLE propiedad (
            nro_propiedad NUMBER(6) NOT NULL,
            direccion_propiedad VARCHAR2(60) NOT NULL,
            superficie NUMBER(8,2) NOT NULL,
            nro_dormitorios NUMBER(1),
            nro_banos NUMBER(1),
            valor_arriendo NUMBER(7) NOT NULL,
            valor_gasto_comun NUMBER(6),
            id_tipo_propiedad VARCHAR2(1) NOT NULL,
            id_comuna NUMBER(3) NOT NULL,
            numrut_prop NUMBER(10) NOT NULL,
            numrut_emp NUMBER(10),
            CONSTRAINT pk_propiedad PRIMARY KEY (nro_propiedad)
        );
        
        CREATE TABLE propiedad_arrendada (
            nro_propiedad NUMBER(6) NOT NULL,
            fecini_arriendo DATE NOT NULL,
            fecter_arriendo DATE, 
            numrut_cli NUMBER(10) NOT NULL,
            CONSTRAINT pk_propiedad_arrendada PRIMARY KEY (nro_propiedad, fecini_arriendo)
        );
        
        -- creacion de llaves foraneas 
        ALTER TABLE empleado
            ADD CONSTRAINT fk_empleado_comuna FOREIGN KEY (id_comuna)
            REFERENCES comuna (id_comuna);
        
        ALTER TABLE propietario
            ADD CONSTRAINT fk_propietario_comuna FOREIGN KEY (id_comuna)
            REFERENCES comuna (id_comuna);
        
        ALTER TABLE empleado
            ADD CONSTRAINT fk_empleado_categoria_empleado FOREIGN KEY (id_categoria_emp)
            REFERENCES categoria_empleado (id_categoria_emp);
        
        ALTER TABLE empleado
            ADD CONSTRAINT fk_empleado_supervisor FOREIGN KEY (numrut_supervisor)
            REFERENCES empleado (numrut_emp);
        
        ALTER TABLE propiedad
            ADD CONSTRAINT fk_propiedad_tipo_propiedad FOREIGN KEY (id_tipo_propiedad)
            REFERENCES tipo_propiedad (id_tipo_propiedad);
        
        ALTER TABLE propiedad
            ADD CONSTRAINT fk_propiedad_comuna FOREIGN KEY (id_comuna)
            REFERENCES comuna (id_comuna);
        
        ALTER TABLE propiedad
            ADD CONSTRAINT fk_propiedad_propietario FOREIGN KEY (numrut_prop)
            REFERENCES propietario (numrut_prop);
        
        ALTER TABLE propiedad
            ADD CONSTRAINT fk_propiedad_empleado FOREIGN KEY (numrut_emp)
            REFERENCES empleado (numrut_emp);
            
        ALTER TABLE propiedad_arrendada
            ADD CONSTRAINT fk_propiedad_arrendada_cliente FOREIGN KEY (numrut_cli)
            REFERENCES cliente(numrut_cli);
        
        ALTER TABLE propiedad_arrendada
            ADD CONSTRAINT fk_propiedad_arrendada_prop FOREIGN KEY (nro_propiedad)
            REFERENCES propiedad(nro_propiedad);
        
        ALTER TABLE propietario
            ADD CONSTRAINT fk_propietario_estado_civil FOREIGN KEY (id_estcivil)
            REFERENCES estado_civil (id_estcivil);
        
        ALTER TABLE cliente
            ADD CONSTRAINT fk_cliente_estado_civil FOREIGN KEY (id_estcivil)
            REFERENCES estado_civil (id_estcivil);
        
        ALTER TABLE empleado
            ADD CONSTRAINT fk_empleado_estado_civil FOREIGN KEY (id_estcivil)
            REFERENCES estado_civil (id_estcivil);
           
        -- insercion de datos
        
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Las Condes');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Providencia');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Santiago');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Ñuñoa');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Vitacura');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'La Reina');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'La Florida');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Maipú');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Lo Barnechea');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Macul');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'San Miguel');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Peñalolén');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Puente Alto');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Recoleta');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Estación Central');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'San Bernardo');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Independencia');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'La Cisterna');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Quilicura');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Quinta Normal');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Conchalí');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'San Joaquín');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Huechuraba');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'El Bosque');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Cerrillos');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Cerro Navia');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'La Granja');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'La Pintana');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Lo Espejo');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Lo Prado');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Pedro Aguirre Cerda');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Pudahuel');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Renca');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'San Ramón');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Melipilla');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'San Pedro');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Alhué');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'María Pinto');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Curacaví');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Talagante');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'El Monte');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Buin');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Paine');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Peñaflor');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Isla de Maipo');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Colina');
        INSERT INTO comuna VALUES (sq_com.NEXTVAL, 'Pirque');
        
        INSERT INTO categoria_empleado VALUES (sq_cat.NEXTVAL, 'Gerente');
        INSERT INTO categoria_empleado VALUES (sq_cat.NEXTVAL, 'Supervisor');
        INSERT INTO categoria_empleado VALUES (sq_cat.NEXTVAL, 'Ejecutivo de Arriendo');
        INSERT INTO categoria_empleado VALUES (sq_cat.NEXTVAL, 'Auxiliar');
        
        INSERT INTO tipo_propiedad VALUES ('A', 'Casa sin Amoblar');
        INSERT INTO tipo_propiedad VALUES ('B', 'Casa Amoblada');
        INSERT INTO tipo_propiedad VALUES ('C', 'Departamento sin Amoblar');
        INSERT INTO tipo_propiedad VALUES ('D', 'Departamento Amoblado');
        INSERT INTO tipo_propiedad VALUES ('E', 'Local Comercial');
        INSERT INTO tipo_propiedad VALUES ('F', 'Parcela sin Casa');
        INSERT INTO tipo_propiedad VALUES ('G', 'Parcela con Casa');
        INSERT INTO tipo_propiedad VALUES ('H', 'Sitio');
        
        INSERT INTO estado_civil VALUES (1, 'Soltero');
        INSERT INTO estado_civil VALUES (2, 'Casado');
        INSERT INTO estado_civil VALUES (3, 'Separado');
        INSERT INTO estado_civil VALUES (4, 'Divorciado');
        INSERT INTO estado_civil VALUES (5, 'Viudo');
        
        INSERT INTO empleado VALUES (11649964, '0', 'GALVEZ', 'CASTRO', 'MARTA', 'CLOVIS MONTERO 0260 D/202', 1, '23417556', '25273328', TO_DATE('1971-12-20', 'YYYY-MM-DD'), TO_DATE('1994-08-11', 'YYYY-MM-DD'), 1515239, 80, 3, NULL);
        INSERT INTO empleado VALUES (12113369, '4', 'ROMERO', 'DIAZ', 'NANCY', 'TENIENTE RAMON JIMENEZ 4753', 4, '25631567', '22623877', TO_DATE('1968-06-09', 'YYYY-MM-DD'), TO_DATE('1989-08-31', 'YYYY-MM-DD'), 2710153, 81, 3, 11649964);
        INSERT INTO empleado VALUES (12456905, '1', 'CANALES', 'BASTIAS', 'JORGE', 'GENERAL CONCHA PEDREGAL #885', 2, '27779827', '27413395', TO_DATE('1957-12-21', 'YYYY-MM-DD'), TO_DATE('1981-08-12', 'YYYY-MM-DD'), 2945675, 81, 3, 11649964);
        INSERT INTO empleado VALUES (12466553, '2', 'VIDAL', 'PEREZ', 'TERESA', 'FCO. DE CAMARGO 14515 D/14', 3, '28583700', '28122603', TO_DATE('1969-11-20', 'YYYY-MM-DD'), TO_DATE('1994-08-13', 'YYYY-MM-DD'), 1202614, 82, 3, 12456905);
        INSERT INTO empleado VALUES (11745244, '3', 'VENEGAS', 'SOTO', 'KARINA', 'ARICA 3850', 1, '27790734', '27494190', TO_DATE('1963-06-23', 'YYYY-MM-DD'), TO_DATE('1986-08-14', 'YYYY-MM-DD'), 1439042, 83, 3, 12456905);
        INSERT INTO empleado VALUES (11999100, '4', 'CONTRERAS', 'CASTILLO', 'CLAUDIO', 'ISABEL RIQUELME 6075', 2, '27764142', '25232677', TO_DATE('1966-03-15', 'YYYY-MM-DD'), TO_DATE('1992-08-15', 'YYYY-MM-DD'), 364163, 84, 4, 11649964);
        INSERT INTO empleado VALUES (12888868, '5', 'PAEZ', 'MACMILLAN', 'JOSE', 'FERNANDEZ CONCHA 500', 3, '22399493', '27735417', TO_DATE('1964-07-25', 'YYYY-MM-DD'), TO_DATE('1989-08-16', 'YYYY-MM-DD'), 1896155, 85, 3, 12456905);
        INSERT INTO empleado VALUES (12811094, '6', 'MOLINA', 'GONZALEZ', 'PAULA', 'PJE.TIMBAL 1095 V/POMAIRE', 4, '25313830', NULL, TO_DATE('1978-08-26', 'YYYY-MM-DD'), TO_DATE('2001-08-17', 'YYYY-MM-DD'), 1757577, 86, 3, 12456905);
        INSERT INTO empleado VALUES (14255602, '7', 'MUÑOZ', 'ROJAS', 'CARLOTA', 'TERCEIRA 7426 V/LIBERTAD', 1, '26490093', '27414886', TO_DATE('1982-09-27', 'YYYY-MM-DD'), TO_DATE('2004-08-18', 'YYYY-MM-DD'), 2658577, 87, 2, 11649964);
        INSERT INTO empleado VALUES (11630572, '8', 'ARAVENA', 'HERBAGE', 'GUSTAVO', 'FERNANDO DE ARAGON 8420', 3, '25588481', '26256661', TO_DATE('1966-03-15', 'YYYY-MM-DD'), TO_DATE('1999-08-19', 'YYYY-MM-DD'), 1957095, 88, 3, 12113369);
        INSERT INTO empleado VALUES (11636534, '9', 'ADASME', 'ZÚÑIGA', 'LUIS', 'LITTLE ROCK 117 V/PDTE.KENNEDY', 1, '26483081', '26213403', TO_DATE('1973-10-29', 'YYYY-MM-DD'), TO_DATE('1994-08-20', 'YYYY-MM-DD'), 1614934, 89, 3, 12113369);
        INSERT INTO empleado VALUES (12272880, 'K', 'LAPAZ', 'SEPULVEDA', 'MARCO', 'GUARDIA MARINA. RIQUELME 561', 2, '26038967', '22814034', TO_DATE('1989-10-01', 'YYYY-MM-DD'), TO_DATE('2012-08-21', 'YYYY-MM-DD'), 1352596, 92, 3, 12456905);
        INSERT INTO empleado VALUES (11846972, '5', 'OGAZ', 'VARAS', 'MARCO', 'OVALLE Nº5798 V/ OHIGGINS', 3, '27763209', '27377830', TO_DATE('1959-12-31', 'YYYY-MM-DD'), TO_DATE('1983-08-22', 'YYYY-MM-DD'), 253590, 94, 4, 11649964);
        INSERT INTO empleado VALUES (14283083, '6', 'MONDACA', 'COLLAO', 'AUGUSTO', 'NUEVA COLON Nº1152', 4, '27357104', '25376873', TO_DATE('1989-10-01', 'YYYY-MM-DD'), TO_DATE('2011-08-23', 'YYYY-MM-DD'), 1144245, 95, 2, 11649964);
        INSERT INTO empleado VALUES (14541837, '7', 'ALVAREZ', 'RIVERA', 'MARCO', 'HONDURAS B/8908 D/102 L.BRISAS', 1, '22875902', '25292497', TO_DATE('1977-01-02', 'YYYY-MM-DD'), TO_DATE('1994-08-24', 'YYYY-MM-DD'), 1541418, 97, 3, 12113369);
        INSERT INTO empleado VALUES (12482036, '8', 'OLAVE', 'CASTILLO', 'ADRIAN', 'ELISA CORREA 188', 2, '22888897', '28441077', TO_DATE('1956-01-03', 'YYYY-MM-DD'), TO_DATE('1984-08-25', 'YYYY-MM-DD'), 1068086, 98, 3, 12113369);
        INSERT INTO empleado VALUES (12468081, '9', 'SANCHEZ', 'GONZALEZ', 'PAOLA', 'AV.OSSA 01240 V/MI VIÑITA', 3, '25273328', '25581593', TO_DATE('1987-10-04', 'YYYY-MM-DD'), TO_DATE('2010-08-26', 'YYYY-MM-DD'), 1330355, 99, 3, 12113369);
        INSERT INTO empleado VALUES (12260812, '0', 'RIOS', 'ZÚÑIGA', 'RAFAEL', 'LOS CASTAÑOS 1427 VILLA C.C.U.', 4, '26410462', '28501857', TO_DATE('1991-11-05', 'YYYY-MM-DD'), TO_DATE('2011-08-27', 'YYYY-MM-DD'), 367056, 106, 4, 11649964);
        INSERT INTO empleado VALUES (12899759, '1', 'CACERES', 'JIMENEZ', 'ERIKA', 'PJE.NAVARINO 15758 V/P.DE OÑA', 1, '28593881', '22650316', TO_DATE('1974-01-06', 'YYYY-MM-DD'), TO_DATE('1992-08-28', 'YYYY-MM-DD'), 2281415, 107, 3, 12456905);
        INSERT INTO empleado VALUES (12868553, '2', 'CHACON', 'AMAYA', 'PATRICIA', 'LO ERRAZURIZ 530 V/EL SENDERO', 2, '25577963', NULL, TO_DATE('1985-11-07', 'YYYY-MM-DD'), TO_DATE('2004-08-29', 'YYYY-MM-DD'), 1723055, 108, 3, 12456905);
        INSERT INTO empleado VALUES (12648200, '3', 'NARVAEZ', 'MUÑOZ', 'LUIS', 'AMBRIOSO OHIGGINS 2010', 3, '27742268', '25317272', TO_DATE('1993-10-08', 'YYYY-MM-DD'), TO_DATE('2012-08-30', 'YYYY-MM-DD'), 1966613, 80, 3, 12456905);
        INSERT INTO empleado VALUES (11670042, '5', 'GONGORA', 'DEVIA', 'VALESKA', 'PASAJE VENUS 2765', 1, '23244270', '26224817', TO_DATE('1975-01-10', 'YYYY-MM-DD'), TO_DATE('1996-09-01', 'YYYY-MM-DD'), 1635086, 82, 3, 12113369);
        INSERT INTO empleado VALUES (12642309, 'K', 'NAVARRO', 'SANTIBAÑEZ', 'JUAN', 'SANTA ELENA 300 V/LOS ALAMOS', 2, '27441530', '25342599', TO_DATE('1986-10-11', 'YYYY-MM-DD'), TO_DATE('2009-09-02', 'YYYY-MM-DD'), 1659230, 83, 3, 12456905);
        
        INSERT INTO cliente VALUES (10639521, '0', 'UVAL', 'RIQUELME', 'MIGUEL', 'SAN PABLO 7545 B/2 DPTO. 12', 5, '26439756', '52710253', 1300000);
        INSERT INTO cliente VALUES (13074837, '1', 'AMENGUAL', 'SALDIAS', 'CESAR', 'PJE.CODORNICES 1550 V/EL RODEO', 1, '22168405', '55212406', 1400000);
        INSERT INTO cliente VALUES (12251882, '2', 'MORICE', 'DONOSO', 'CLAUDIO', 'CHACALLUTA 9519', 2, '22814948', '77413705', 1200000);
        INSERT INTO cliente VALUES (10238830, '3', 'SOTO', 'ARMAZAN', 'JUAN', 'LOS MORELOS 803', 5, '25237022', '92853737', 1200000);
        INSERT INTO cliente VALUES (12777063, '4', 'VILLENA', 'CAVERO', 'PABLO', 'NAVIDAD 1345 SEC.LA PALMILLA', 3, '26234565', '27497042', 600000);
        INSERT INTO cliente VALUES (12467572, '5', 'RIQUELME', 'BRIGNARDELLO', 'MIGUEL', 'AMERICO VESPUCIO 1505 V/MEXICO', 5, '25381416', '52794874', 500000);
        INSERT INTO cliente VALUES (12866487, '6', 'STOLLER', 'VARGAS', 'LORENA', 'PASCUAL BABURIZZA 655', 1, '22773144', '85450443', 1250000);
        INSERT INTO cliente VALUES (13463138, '7', 'BRAVO', 'HENRIQUEZ', 'PABLO', 'FLACO MARIN #107 V/ C. NORTE', 2, '27766349', '55341874', 1380000);
        INSERT INTO cliente VALUES (11657132, '8', 'ACUÑA', 'BARRERA', 'RONNY', 'OBS.ASTRONOMICO UC PAR.METROP.', 5, '27370770', '62737281', 1420000);
        INSERT INTO cliente VALUES (12487147, '9', 'MARIN', 'ARAVENA', 'JUAN', 'LAS PALMAS 134 V/CALIFORNIA', 1, '27780321', '97773749', 560000);
        INSERT INTO cliente VALUES (12817700, 'K', 'VARGAS', 'GARAY', 'CLAUDIA', 'PJE.BELEN Nº8 P/GERALDINE', 2, '2425678', '88122441', 1400000);
        INSERT INTO cliente VALUES (9499044, '5', 'ROJAS', 'ACHA', 'CLAUDIO', 'DR LUIS BISQUERT 2924 DPTO. 4', 5, '22380333', '25262465', 1300000);
        INSERT INTO cliente VALUES (11996940, '6', 'ORELLANA', 'SAAVEDRA', 'JUAN', 'SANTA MARTA 9415 P/STA. TERESA', 1, '56434256', '25421693', 1200000);
        INSERT INTO cliente VALUES (14558221, '7', 'PASTEN', 'JORQUERA', 'ALAN', 'BALMACEDA Nº15', 2, '28421196', '62278556', 1180000);
        INSERT INTO cliente VALUES (12459100, '8', 'POBLETE', 'FUENTES', 'SERGIO', 'TINGUIRIRICA 3553 V/FORESTA', 3, '27464857', '75631102', 1340000);
        INSERT INTO cliente VALUES (8716085, '9', 'HORMAZABAL', 'SAGREDO', 'HUGO', 'DORSAL 5912 V/MANUEL RODRIGUEZ', 1, '27789260', '76432652', 1260000);
        INSERT INTO cliente VALUES (12503185, '0', 'SILVA', 'GONZALEZ', 'PAUL', 'CALLE HOLANDA 073 V/PORVENIR', 2, '28509240', '67416145', 1300000);
        INSERT INTO cliente VALUES (10586995, '1', 'MUÑOZ', 'FERNANDEZ', 'JOSE', 'AV.LAS TORRES 152', 4, '26434104', NULL, 1200000);
        INSERT INTO cliente VALUES (11949670, '2', 'CONTRERAS', 'MIRANDA', 'CLAUDIO', 'VISTA HERMOSA 2126 P/H.ALTO', 5, '28310255', '65582082', 500000);
        INSERT INTO cliente VALUES (9771046, '3', 'ZAMORANO', 'ELIZONDO', 'LUIS', 'ALAMEDA 301', 1, '26332876', '52811129', 1320000);
        INSERT INTO cliente VALUES (12095272, '4', 'ROJAS', 'RODRIGUEZ', 'DAMASO', 'URMENETA 1124 D.302', 2, '26210614', NULL, 1160000);
        INSERT INTO cliente VALUES (14632410, '5', 'VILLANUEVA', 'YEPES', 'MONICA', 'GASPAR DE LA BARRERA 2815', 4, '26830779', '56832705', 1240000);
        INSERT INTO cliente VALUES (15353262, 'K', 'BARRIOS', 'HIDALGO', 'LUIS', 'BALMACEDA 966', 5, '28213310', '96255762', 1260000);
        INSERT INTO cliente VALUES (4604866, '0', 'AGUIRRE', 'MUÑOZ', 'LUIS', 'VICHUQUEN 1462', 1, '26238494', NULL, 1300000);
        INSERT INTO cliente VALUES (14148957, '1', 'MARTIN', 'DONOSO', 'JUAN', 'PJE. LOS FLORENTINOS 1804', 2, '25428017', '82936654', 1400000);
        INSERT INTO cliente VALUES (12831482, '2', 'ORELLANA', 'GARRIDO', 'PATRICIO', 'LOS GUAITECAS 1751', 5, '28572849', '76442200', 1200000);
        INSERT INTO cliente VALUES (12186256, '3', 'FUENTES', 'MORENO', 'MANUEL', 'HANOI 7474', 1, '26493855', '55311880', 1200000);
        INSERT INTO cliente VALUES (11976208, '4', 'OPAZO', 'AGUILERA', 'MARIA', 'LOS TILOS 8924 P/LUIS BELTRAN', 2, '26442611', '65351928', 1600000);
        INSERT INTO cliente VALUES (12998853, '5', 'TRINKE', 'TRINKE', 'CRISTIAN', 'MANCO CAPAC 1756', 3, '27461014', '67765258', 500000);
        INSERT INTO cliente VALUES (12947165, '6', 'HISI', 'DIAZ', 'ROSA', 'ICARO 3580 V/SANTA INES', 5, '27360251', '52893123', 1250000);
        INSERT INTO cliente VALUES (13043565, '7', 'AGUILERA', 'ROMAN', 'WILLIBALDO', 'ANDES 4717', 1, '27748105', '55285702', 1380000);
        INSERT INTO cliente VALUES (13072743, '8', 'ORELLANA', 'SERQUEIRA', 'JAIME', 'AV. 5 DE ABRIL 5693 A DPTO. 42', 2, '27417338', '8491680', 1420000);
        INSERT INTO cliente VALUES (16960649, '9', 'RIQUELME', 'CHAVEZ', 'ROCIO', 'BALMACEDA 1070', 4, '28598452', '92871989', 560000);
        INSERT INTO cliente VALUES (12468646, 'K', 'ALVAREZ', 'MUÑOZ', 'MANUEL', 'EDUARDO MATTE 2180', 2, '25557973', '95292190', 1400000);
        INSERT INTO cliente VALUES (12656375, '5', 'SALDIAS', 'ROJAS', 'DAVID', 'LOS TURISTAS 0735 P/EL SALTO', 4, '26224280', NULL, 1300000);
        INSERT INTO cliente VALUES (11635470, '6', 'RAMIREZ', 'GUTIERREZ', 'JOEL', 'SIERRA BELLA 1687', 5, '25225838', NULL, 1200000);
        INSERT INTO cliente VALUES (14415848, '7', 'MACHUCA', 'ADONIS', 'MIGUEL', 'LOS JAZMINES 1537 DPTO. 41 V.O', 1, '22383938', '58152298', 1180000);
        INSERT INTO cliente VALUES (12241168, '8', 'RAMIREZ', 'GUTIERREZ', 'RODRIGO', 'GUIDO RENNI 4225', 2, '25225838', '85286676', 1340000);
        INSERT INTO cliente VALUES (9798044, '9', 'MALTRAIN', 'CORTES', 'JUAN', 'ENZO PINZA 3330', 5, '25554298', '95577263', 1260000);
        INSERT INTO cliente VALUES (12832359, '0', 'SALAS', 'TORO', 'CARLOS', 'PJE.LLEUQUE 0861 V/EL PERAL 3', 1, '22959031', '77764463', 1300000);
        INSERT INTO cliente VALUES (12302426, '1', 'ALVARADO', 'ARAUNA', 'ALEX', 'PJE.CHONCHI 6678 V/LOS TRONCOS', 2, '25230195', '67783253', 1200000);
        INSERT INTO cliente VALUES (12859931, '2', 'CESPEDES', 'LANDEROS', 'CRISTIAN', 'BAUTISTA IBARRAL 277', 4, '27765868', '65296851', 1500000);
        INSERT INTO cliente VALUES (12467533, '3', 'HERNANDEZ', 'DIAZ', 'JUAN', 'VARGAS SALCEDO 1541', 5, '25332923', '55417672', 320000);
        INSERT INTO cliente VALUES (12470801, '4', 'SANCHEZ', 'RIVERA', 'JACQUELINE', 'LUIS INFANTE CERDA 5315', 1, '27412764', '26399737', 1160000);
        INSERT INTO cliente VALUES (13035746, '5', 'LARA', 'LECAROS', 'DANIEL', 'FRANCISCO ESCALONA 3790', 5, '26210890', '68111801', 1240000);
        INSERT INTO cliente VALUES (12866998, 'K', 'AVILA', 'RETAMALES', 'CRISTIAN', 'TURMALINA 1495 V/LA SALUD', 1, '25457317', '78172323', 1260000);
        INSERT INTO cliente VALUES (11872936, '0', 'VIDAL', 'OSSES', 'LUIS', 'C.NUEVA IMPERIAL 1045 B/1 DEPTO. 25', 2, '25293595', '88111254', 1300000);
        INSERT INTO cliente VALUES (14526736, '1', 'VALENZUELA', 'MONTOYA', 'ROSA', 'GENARO PRIETO 910 P/EL TRANQUE', 5, '28503179', '96469095', 1400000);
        INSERT INTO cliente VALUES (9964101, '2', 'MENESES', 'RUBIO', 'CARLOS', 'SANTA MARTA 0713', 1, '25293285', '26438047', 1200000);
        INSERT INTO cliente VALUES (12495120, '3', 'RUIZ', 'BRIONES', 'CRISTIAN', 'PJE. FREIRINA 3630', 2, '23243232', '85289043', 1200000);
        INSERT INTO cliente VALUES (13050707, '4', 'VALLE', 'CASTRIZELO', 'FREDY', 'PALERMO P/LA RAZON 2023', 3, '27378107', '98725363', 600000);
        INSERT INTO cliente VALUES (12415220, '5', 'CASTRO', 'TOBAR', 'ALEJANDRA', 'RODR. DE ARAYA 4651B B/11 DEPTO. 42', 5, '22763621', '68546237', 500000);
        INSERT INTO cliente VALUES (12459400, '6', 'PICHIHUINCA', 'JORQUERA', 'RAFAEL', 'INGENIERO GIROZ 6035', 1, '27783484', '72940059', 1250000);
        INSERT INTO cliente VALUES (12649413, '7', 'MANZANO', 'QUINTANILLA', 'JESSICA', 'PJE. LAMPA 1391 V/LOS MINERALE', 2, '26259699', '66213729', 1380000);
        INSERT INTO cliente VALUES (12610458, '8', 'BARTLAU', 'VARGAS', 'MACARENA', 'MARIA VIAL 8028', 4, '25273848', NULL, 1420000);
        INSERT INTO cliente VALUES (12364085, '9', 'ARAYA', 'CAMUS', 'FREDDY', 'CARRERA 027', 5, '28461589', '62514074', 560000);
        INSERT INTO cliente VALUES (12460769, 'K', 'DAZA', 'GUERRERO', 'ERIC', 'HERRERA 618', 1, '26813742', '56215369', 400000);
        INSERT INTO cliente VALUES (13072796, '5', 'MEDINA', 'CAMUS', 'WANDA', 'ICTINOS 1162 VILLA PEDRO LAGOS', 2, '22797176', '95586941', 1300000);
        INSERT INTO cliente VALUES (12649650, '6', 'CUADRA', 'DISSI', 'DIEGO', 'PJE.OLGA DONOSO 4047 P/E.GONEL', 4, '26251788', NULL, 1200000);
        INSERT INTO cliente VALUES (13078214, '7', 'CONCHA', 'MONTECINOS', 'KATHERINE', 'AV. GRECIA 5055 BL/2 DPTO. 22', 5, '22724039', NULL, 1180000);
        INSERT INTO cliente VALUES (12189232, '8', 'DELGADO', 'GALLEGOS', 'XIMENA', 'LUXEMBURGO Nº9609', 1, '22202264', NULL, 1340000);
        INSERT INTO cliente VALUES (8533901, '9', 'QUEZADA', 'VILLENA', 'CRISTIAN', 'P. LOS INCAS 1734 V/OLIMPO II', 2, '25321876', '27344236', 1260000);
        INSERT INTO cliente VALUES (12871924, '0', 'VENEGAS', 'TORRES', 'JESSICA', 'GARCIA REYES Nº55C', 5, '26817651', '95596474', 1300000);
        INSERT INTO cliente VALUES (13072368, '1', 'JORQUERA', 'VERA', 'ALEX', 'SENDA 12 B/1157 DEPTO. A V/C.18 NOR', 1, '22424598', NULL, 1200000);
        INSERT INTO cliente VALUES (11226732, '2', 'CAVANELA', 'ORTEGA', 'JUAN', 'PJE BATUCO #9457 V/OHIGGINS', 2, '22816328', '88582729', 500000);
        INSERT INTO cliente VALUES (11695597, '3', 'BASOALTO', 'ARANGUIZ', 'JUAN', 'SANTA FILOMENA DE NOS', 4, '28575175', '72850346', 1320000);
        INSERT INTO cliente VALUES (13082881, '4', 'FUENTES', 'FAUNDEZ', 'FELIPE', 'GUAYACAN # 063 V/FABERIO', 5, '28510780', '66228120', 1160000);
        INSERT INTO cliente VALUES (14319321, '5', 'SALVO', 'GUTIERREZ', 'PATRICIA', 'PJE # 1 Nº675 P/ANTUPILLAN', 1, '28587242', '57787241', 2240000);
        INSERT INTO cliente VALUES (10268208, 'K', 'REYES', 'MORALES', 'LUIS', 'BUENOS AIRES #429', 2, '28586286', '97417379', 2260000);
        INSERT INTO cliente VALUES (13050258, '0', 'SALAS', 'CORNEJO', 'CARLOS', 'VALLE DEL SOL Nº4028', 3, '87418813', '25287698', 2300000);
        INSERT INTO cliente VALUES (13057574, '1', 'CORNEJO', 'GONZALEZ', 'ALEJANDRO', 'CIENCIAS #8442 P/BIAUT', 5, '25586841', '72950789', 1400000);
        INSERT INTO cliente VALUES (13264443, '2', 'SAN', 'GARCIA', 'MARTIN', 'ALAMEDA #4272 DPTO. 104', 2, '27783600', '62895758', 2200000);
        INSERT INTO cliente VALUES (12861354, '3', 'CADIZ', 'SANDOVAL', 'FERNANDO', 'CALLE LUGO 4671 P.10 PAJARITO', 4, '27445878', '58214142', 800000);
        INSERT INTO cliente VALUES (12959989, '4', 'JEREZ', 'CHACON', 'PAMELA', 'INES DE SUARES 220', 5, '209388532', '57813075', 600000);
        INSERT INTO cliente VALUES (12721101, '5', 'JORQUERA', 'SANCHEZ', 'LEONEL', 'ALMIRANTE RIVEROS #9653', 1, '25580425', '67813075', 500000);
        INSERT INTO cliente VALUES (10711069, '6', 'CISTERNAS', 'SAAVEDRA', 'VICTOR', 'LAGO GRIS 4673 V/EL ALBA', 2, '26983708', '67813075', 1250000);
        INSERT INTO cliente VALUES (12871979, '7', 'RODRIGUEZ', 'LEMUS', 'PAOLA', 'JOAQUIN EDWARDS BELLO #10529', 4, '25410073', '65428513', 3180000);
        INSERT INTO cliente VALUES (10320840, '8', 'DURAN', 'REBOLLEDO', 'JAIME', 'AV.3 PONIENTE 1548 V/VIENA', 5, '25327648', '77446858', 1420000);
        INSERT INTO cliente VALUES (13034352, '9', 'MUÑOZ', 'ASCORRA', 'CLAUDIA', 'LOS ÑANDUES #509 V/PAJARITOS', 1, '22570673', NULL, 1560000);
        INSERT INTO cliente VALUES (10539484, 'K', 'OSORIO', 'MELLA', 'JUAN', 'LO SALINAS 1695', 2, '28213010', '92796904', 1400000);
        INSERT INTO cliente VALUES (12000035, '5', 'ROJAS', 'ROJAS', 'MARIO', 'AV.I.CARRERA PINTO 1041', 4, '98112545', NULL, 1300000);
        INSERT INTO cliente VALUES (7108724, '6', 'QUILODRAN', 'GARCIA', 'MARIA', 'PJE.VARSOVIA 1439 V/ESQUINA B.', 5, '25382800', '25317903', 1200000);
        INSERT INTO cliente VALUES (13083936, '7', 'QUINTANA', 'MARDONES', 'RUTH', 'PASAJE LA RAIZ Nº10591', 1, '22876325', '95281124', 1180000);
        INSERT INTO cliente VALUES (12158268, '8', 'ERICES', 'MOLINA', 'ELIGIO', 'PJE.COLORADO 5528 DEPTO. 302', 2, '25230176', '85283675', 3140000);
        INSERT INTO cliente VALUES (12946000, '9', 'CASTILLO', 'VALENCIA', 'PAULA', 'LAS AMAPOLAS 1931 P/PEDRO MONT', 5, '26833380', '82886471', 2160000);
        INSERT INTO cliente VALUES (13085998, '0', 'SUAZO', 'RIQUELME', 'OSCAR', 'PJE.PAULINA 1678 V/BLANCA', 1, '25111798', '68153576', 3100000);
        INSERT INTO cliente VALUES (13032090, '1', 'GONZALEZ', 'JOFRE', 'JUAN', 'PJE.LOS TILOS 8926 P/L.BELTRAN', 2, '26446917', '55212127', 1200000);
        INSERT INTO cliente VALUES (10293552, '2', 'FRITIS', 'CHAMBLAS', 'JOSE', 'PEDRO AGUIRRE CERDA 5962', 4, '26252858', '55212127', 1500000);
        INSERT INTO cliente VALUES (12960006, '3', 'MARILLANCA', 'CARVAJAL', 'ANTONIO', 'SITIO 37B PINTUE LAGUNA ACULEO', 5, '28249080', '62562637', 1320000);
        INSERT INTO cliente VALUES (10776845, '4', 'NAVARRO', 'VELASQUEZ', 'HECTOR', 'PJE. CAPRI 909 B/5 DEPTO. 103', 1, '25577804', '56813593', 1160000);
        INSERT INTO cliente VALUES (12407575, '5', 'GONZALEZ', 'LILLO', 'MARCELA', 'RODRIGO DE ARAYA 4871 DEPTO. 14', 2, '22762321', '56812350', 1240000);
        INSERT INTO cliente VALUES (14319236, 'K', 'ARRIARAN', 'ROJAS', 'OSCAR', '12 DE FEBRERO 850', 4, '28580076', '68500893', 1260000);
        INSERT INTO cliente VALUES (11339557, '0', 'BUSTOS', 'MARTINEZ', 'IVONNE', 'ALDUNATE 1932', 5, '25540604', '57762111', 560000);
        INSERT INTO cliente VALUES (11749379, '1', 'MORALES', 'ZAMORANO', 'FABIOLA', 'EL QUETZAL 675', 1, '66431810', NULL, 1400000);
        INSERT INTO cliente VALUES (12270989, '2', 'RAMIREZ', 'CARDENAS', 'MAURICIO', 'CALLE LOS NOGALES 9583', 2, '25271068', NULL, 1300000);
        INSERT INTO cliente VALUES (14254526, '3', 'MARTINEZ', 'RODRIGUEZ', 'ERIC', 'PJE.LAGO RAPEL 1297 V/SENDERO', 4, '22919311', NULL, 1200000);
        INSERT INTO cliente VALUES (12820018, '4', 'ACEVEDO', 'SANDOVAL', 'ALEXANDER', 'LAS CODORNICES 2963-H DPTO. 21', 5, '22836901', '92894026', 1180000);
        INSERT INTO cliente VALUES (12468736, '5', 'GONZALEZ', 'MUÑOZ', 'OSVALDO', 'MARIA LUISA BOMBAL 384', 1, '27414835', '95412144', 1340000);
        INSERT INTO cliente VALUES (13088742, '6', 'CID', 'PADILLA', 'CAROLINA', 'AV.FRATERNAL 3910', 2, '25225759', '88721366', 1260000);
        INSERT INTO cliente VALUES (13455413, '7', 'JIMENEZ', 'PINILLA', 'CRISTIAN', 'RICARDO CUMMING 1346 CASA 13', 3, '86966329', NULL, 1300000);
        INSERT INTO cliente VALUES (12685035, '8', 'PEREZ', 'PINTO', 'NELSON', 'EL CARMEN 10364 V/STA.MARIA', 5, '22825520', '86229671', 1200000);
        INSERT INTO cliente VALUES (11514737, '9', 'MORENO', 'GONZALEZ', 'CLAUDIA', 'GRACIOSA 7815 CERRO NAVIA', 1, '26491988', NULL, 1500000);
        INSERT INTO cliente VALUES (13072851, 'K', 'SUAREZ', 'GONZALEZ', 'KARINA', 'PAUL HARRIS 901', 2, '22012371', NULL, 3120000);
        INSERT INTO cliente VALUES (11540908, '5', 'BARRERA', 'RIOS', 'LUISA', 'PASAJE 36 Nº4789 V/EYZAGUIRRE', 4, '22097186', NULL, 760000);
        INSERT INTO cliente VALUES (13269751, '6', 'VALLE', 'DIAZ', 'ALEXIS', 'CUATRO REMOS 580 V/ANT. VARAS', 5, '27782342', '57788381', 1240000);
        INSERT INTO cliente VALUES (12684459, '7', 'CARVAJAL', 'REYES', 'PABLO', 'VICTORIA 615', 2, '25558281', '67415270', 1260000);
        INSERT INTO cliente VALUES (9969366, '8', 'FUENTES', 'CORTES', 'LUIS', 'IGNACIO CARRERA PINTO 6013', 4, '26232094', '57719055', 600000);
        INSERT INTO cliente VALUES (10917199, '9', 'ACUÑA', 'OLIVARES', 'ELIZABETH', 'CERRO HUEMUL 1052', 5, '57736141', NULL, 1500000);
        INSERT INTO cliente VALUES (13098962, '0', 'SANTA', 'DIAZ', 'MARIA', 'AV.KENNEDY B/16 DEPTO. 31 P/MANSO', 1, '2253899', '76814737', 1250000);
        INSERT INTO cliente VALUES (12672729, '1', 'BARRAZA', 'LOBOS', 'EDUARDO', 'TRICAO 460 P/ EUGENIPO MATTE', 2, '28512060', '77735367', 1380000);
        INSERT INTO cliente VALUES (13041711, '2', 'ITURRIETA', 'GONZALEZ', 'PABLO', 'AV. TRANSITO 5291', 3, '27753384', '67356222', 795000);
        
        INSERT INTO propietario VALUES (12491094, '3', 'SAAVEDRA', 'VILLALOBOS', 'SERGIO', 'VIA 7 Nº1000 B/3 D/7', 5, '22398244', NULL, 82);
        INSERT INTO propietario VALUES (12651346, '4', 'MUÑOZ', 'PEREZ', 'CLAUDIA', 'SANTA ISABEL 463', 1, '26359178', '27412904', 83);
        INSERT INTO propietario VALUES (12116380, '5', 'BARAHONA', 'ORELLANA', 'JOSE', 'NTRA. SRA. SANTA GENOVEVA 9508', 2, '22871051', NULL, 82);
        INSERT INTO propietario VALUES (13024901, 'K', 'VALENCIA', 'URBINA', 'SERGIO', 'MARIA ELENA 1857 V/LOS NAVIOS', 3, '25417284', '26211095', 85);
        INSERT INTO propietario VALUES (12885975, '0', 'BARRIOS', 'MUÑOZ', 'BARBARA', 'PASAJE PUCON 5940', 5, '22215104', '26710430', 82);
        INSERT INTO propietario VALUES (13041308, '1', 'PARDO', 'ESPINOSA', 'RICHARD', 'PJE.PIRAMIDE 1477 P/BOROA', 1, '26811939', '27740990', 87);
        INSERT INTO propietario VALUES (11947288, '2', 'QUEZADA', 'GOMEZ', 'MARIO', 'LAS MALVAS 10470 V/PENSAMIENTO', 2, '25415191', '25410480', 88);
        INSERT INTO propietario VALUES (12783347, '3', 'CUBILLOS', 'FERRADA', 'JORGE', 'LAGO RUPANCO 1556 P/LANALHUE', 4, '22930493', '25377732', 89);
        INSERT INTO propietario VALUES (13195197, '4', 'GUERRERO', 'ROMO', 'MAURICIO', 'BROCKMAN 1326 VILLA ITALIA', 5, '2232366', '28113377', 92);
        INSERT INTO propietario VALUES (12676073, '5', 'PIZARRO', 'TORO', 'JAIME', 'FCO.BILBAO 1826 P/SAN RAFAEL', 1, '25426807', NULL, 94);
        INSERT INTO propietario VALUES (13471056, '6', 'MIRANDA', 'VALENZUELA', 'PRISCILLA', 'AV. COLECTOR 4866 P/SANTIAGO', 2, '27796916', '27790195', 95);
        INSERT INTO propietario VALUES (12064147, '7', 'ROBLES', 'VIDAL', 'LUIS', 'SEGUNDA TRANSVERSAL PJ.2 C/996', 3, '25573796', '25268570', 87);
        INSERT INTO propietario VALUES (14149786, '8', 'ROBLES', 'CAMIRUAGA', 'AQUILES', 'DIAGONAL PARAGUAY 360 DPTO 116', 5, '22227933', '25325139', 87);
        INSERT INTO propietario VALUES (13071695, '9', 'LOSADA', 'MALDONADO', 'LEONARDO', 'OCTAVA AV.PJE.JOSE READY 6256', 1, '25222006', '25311153', 80);
        INSERT INTO propietario VALUES (12870395, 'K', 'HERNANDEZ', 'VALLADARES', 'JONATHA', 'PJE.RENE OLIVARES 1294', 2, '25389883', '26413331', 106);
        INSERT INTO propietario VALUES (14412994, '5', 'ALARCON', 'QUIROGA', 'JOHN', 'CALLE 1 C/4452 P/SANTIAGO', 3, '27789352', '25261372', 107);
        INSERT INTO propietario VALUES (12878526, '6', 'RIQUELME', 'CORREA', 'JOHN', 'MOISES RIOS Nº1065', 5, '27375662', '25261372', 108);
        
        INSERT INTO propiedad VALUES (1001, 'Serrano 275', 180, 6, 2, 1250000, NULL, 'A', 80, 12491094, 12811094);
        INSERT INTO propiedad VALUES (1002, 'Luis Matte 1477', 81, 4, 1, 240000, 40000, 'C', 81, 12491094, 12113369);
        INSERT INTO propiedad VALUES (1003, 'Vicuña Mackenna 945', 62, 4, 2, 350000, 70000, 'A', 82, 12651346, 12456905);
        INSERT INTO propiedad VALUES (1004, 'Celerino Pereira 1567', 73, 3, 1, 375000, 40000, 'B', 83, 12116380, 12466553);
        INSERT INTO propiedad VALUES (1005, 'Vicuña Mackena 285', 62, 3, 2, 600000, 50000, 'C', 84, 12885975, 11745244);
        INSERT INTO propiedad VALUES (1006, 'Pardo 1288', 51, NULL, NULL, 145000, 30000, 'E', 85, 12885975, 12811094);
        INSERT INTO propiedad VALUES (1007, 'Pje. Patria Vieja 7272', 52, 2, 2, 165000, NULL, 'A', 81, 13041308, 12888868);
        INSERT INTO propiedad VALUES (1008, 'Jose Maria Caro 2551', 52, 2, 1, 220000, 25000, 'D', 82, 11947288, 12811094);
        INSERT INTO propiedad VALUES (1009, 'Galvarino 627', 73, 3, 2, 300000, NULL, 'A', 83, 12783347, 12811094);
        INSERT INTO propiedad VALUES (1010, 'Pje. Piave 1439', 72, 3, 1, 450000, 60000, 'B', 82, 13195197, 11630572);
        INSERT INTO propiedad VALUES (1011, 'Las Carretas 2089', 800, 4, 2, 700000, 35000, 'G', 122, 12676073, 11649964);
        INSERT INTO propiedad VALUES (1012, 'Donatello 7421 D. 107', 62, 3, 1, 320000, 46000, 'B', 82, 12676073, 12113369);
        INSERT INTO propiedad VALUES (1013, 'Totoralillo 1514', 63, NULL, NULL, 175000, NULL, 'E', 81, 13471056, 12456905);
        INSERT INTO propiedad VALUES (1014, 'Tres Oriente Nº6543', 62, 3, 1, 260000, NULL, 'A', 80, 12064147, 12466553);
        INSERT INTO propiedad VALUES (1015, 'Pablo Burchard 566 Depto. 1002', 41, 2, 2, 280000, 35000, 'C', 82, 14149786, 11745244);
        INSERT INTO propiedad VALUES (1016, 'Pje. Caboz 2 Pedro Nuñez 5879', 45, 2, 1, 160000, 25000, 'D', 83, 13071695, 11630572);
        INSERT INTO propiedad VALUES (1017, 'Domeyko 2109', 62, 3, 2, 600000, 90000, 'C', 84, 12870395, 12466553);
        INSERT INTO propiedad VALUES (1018, 'Abdon Cifuentes 61', 3500, 3, 1, 1700000, 120000, 'G', 126, 12870395, 12466553);
        INSERT INTO propiedad VALUES (1019, 'Club Hipico 473 Depto. 706', 66, 3, 2, 320000, NULL, 'A', 86, 12870395, 12456905);
        INSERT INTO propiedad VALUES (1020, 'San Pablo 6828 Depto. 201 BlocK. 5', 74, 3, 1, 342000, 49000, 'C', 87, 13071695, 11745244);
        INSERT INTO propiedad VALUES (1021, 'Sevilla Nº1782', 52, 2, 2, 250000, 50000, 'D', 81, 14412994, 11745244);
        INSERT INTO propiedad VALUES (1022, 'Emiliano Figueroa 9221', 53, 2, 1, 820000, 160000, 'B', 82, 14412994, 12888868);
        INSERT INTO propiedad VALUES (1023, 'Las Acacias S/N', 78, 4, 1, 800000, NULL, 'A', 82, 12878526, 11649964);
        INSERT INTO propiedad VALUES (1024, 'Los Duraznos 89', 70, 3, 1, 750000, NULL, 'B', 82, 12878526, 11649964);
        INSERT INTO propiedad VALUES (1025, 'Totoral S/N', 66, NULL, NULL, 1300000, 40000, 'F', 123, 12878526, 11630572);
        INSERT INTO propiedad VALUES (1026, 'Bandera 458', 34, NULL, 2, 300000, NULL, 'E', 82, 12878526, 11630572);
        INSERT INTO propiedad VALUES (1027, 'Avenida Ambrosio O''Higgins 1305', 100, NULL, NULL, 145000, 30000, 'H', 118, 12885975, 12811094);
        
        INSERT INTO propiedad_arrendada VALUES (1001, TO_DATE('2000-08-11', 'YYYY-MM-DD'), TO_DATE('2005-03-31', 'YYYY-MM-DD'), 12871924);
        INSERT INTO propiedad_arrendada VALUES (1001, TO_DATE('2005-08-09', 'YYYY-MM-DD'), TO_DATE('2010-02-28', 'YYYY-MM-DD'), 12610458);
        INSERT INTO propiedad_arrendada VALUES (1001, TO_DATE('2010-05-02', 'YYYY-MM-DD'), NULL, 14526736);
        INSERT INTO propiedad_arrendada VALUES (1002, TO_DATE('2012-02-01', 'YYYY-MM-DD'), NULL, 13057574);
        INSERT INTO propiedad_arrendada VALUES (1003, TO_DATE('2016-07-05', 'YYYY-MM-DD'), NULL, 12467533);
        INSERT INTO propiedad_arrendada VALUES (1004, TO_DATE('2009-09-09', 'YYYY-MM-DD'), TO_DATE('2015-03-24', 'YYYY-MM-DD'), 12610458);
        INSERT INTO propiedad_arrendada VALUES (1004, TO_DATE('2009-09-29', 'YYYY-MM-DD'), NULL, 12241168);
        INSERT INTO propiedad_arrendada VALUES (1005, TO_DATE('2008-03-02', 'YYYY-MM-DD'), TO_DATE('2023-03-02', 'YYYY-MM-DD'), 12186256);
        INSERT INTO propiedad_arrendada VALUES (1005, TO_DATE('2023-04-01', 'YYYY-MM-DD'), NULL, 15353262);
        INSERT INTO propiedad_arrendada VALUES (1006, TO_DATE('2015-05-04', 'YYYY-MM-DD'), NULL, 13050707);
        INSERT INTO propiedad_arrendada VALUES (1007, TO_DATE('2010-04-03', 'YYYY-MM-DD'), TO_DATE('2015-04-03', 'YYYY-MM-DD'), 13074837);
        INSERT INTO propiedad_arrendada VALUES (1007, TO_DATE('2015-11-01', 'YYYY-MM-DD'), NULL, 12251882);
        INSERT INTO propiedad_arrendada VALUES (1008, TO_DATE('2010-06-03', 'YYYY-MM-DD'), TO_DATE('2014-12-31', 'YYYY-MM-DD'), 12777063);
        INSERT INTO propiedad_arrendada VALUES (1008, TO_DATE('2014-08-01', 'YYYY-MM-DD'), NULL, 12467572);
        INSERT INTO propiedad_arrendada VALUES (1009, TO_DATE('2010-03-01', 'YYYY-MM-DD'), NULL, 13463138);
        INSERT INTO propiedad_arrendada VALUES (1010, TO_DATE('2010-02-01', 'YYYY-MM-DD'), TO_DATE('2014-03-31', 'YYYY-MM-DD'), 10917199);
        INSERT INTO propiedad_arrendada VALUES (1010, TO_DATE('2014-09-01', 'YYYY-MM-DD'), TO_DATE('2015-12-31', 'YYYY-MM-DD'), 11540908);
        INSERT INTO propiedad_arrendada VALUES (1010, TO_DATE('2016-04-01', 'YYYY-MM-DD'), NULL, 11657132);
        INSERT INTO propiedad_arrendada VALUES (1011, TO_DATE('2015-10-01', 'YYYY-MM-DD'), NULL, 12487147);
        INSERT INTO propiedad_arrendada VALUES (1016, TO_DATE('2010-10-01', 'YYYY-MM-DD'), TO_DATE('2015-08-31', 'YYYY-MM-DD'), 12817700);
        INSERT INTO propiedad_arrendada VALUES (1016, TO_DATE('2016-02-01', 'YYYY-MM-DD'), NULL, 11996940);
        INSERT INTO propiedad_arrendada VALUES (1017, TO_DATE('2012-05-01', 'YYYY-MM-DD'), NULL, 14558221);
        INSERT INTO propiedad_arrendada VALUES (1018, TO_DATE('2009-05-05', 'YYYY-MM-DD'), TO_DATE('2012-12-31', 'YYYY-MM-DD'), 12459100);
        INSERT INTO propiedad_arrendada VALUES (1018, TO_DATE('2013-06-01', 'YYYY-MM-DD'), NULL, 12503185);
        INSERT INTO propiedad_arrendada VALUES (1019, TO_DATE('2010-04-03', 'YYYY-MM-DD'), TO_DATE('2016-08-31', 'YYYY-MM-DD'), 10586995);
        INSERT INTO propiedad_arrendada VALUES (1020, TO_DATE('2012-06-01', 'YYYY-MM-DD'), TO_DATE('2015-08-09', 'YYYY-MM-DD'), 10586995);
        INSERT INTO propiedad_arrendada VALUES (1020, TO_DATE('2015-12-01', 'YYYY-MM-DD'), NULL, 12095272);
        INSERT INTO propiedad_arrendada VALUES (1021, TO_DATE('2010-05-03', 'YYYY-MM-DD'), TO_DATE('2023-03-31', 'YYYY-MM-DD'), 15353262);
        INSERT INTO propiedad_arrendada VALUES (1022, TO_DATE('2012-06-01', 'YYYY-MM-DD'), TO_DATE('2014-12-31', 'YYYY-MM-DD'), 14632410);
        INSERT INTO propiedad_arrendada VALUES (1022, TO_DATE('2015-06-01', 'YYYY-MM-DD'), TO_DATE('2016-12-31', 'YYYY-MM-DD'), 14148957);
        INSERT INTO propiedad_arrendada VALUES (1022, TO_DATE('2017-03-01', 'YYYY-MM-DD'), NULL, 4604866);
        INSERT INTO propiedad_arrendada VALUES (1023, TO_DATE('2014-07-07', 'YYYY-MM-DD'), NULL, 16960649);
        INSERT INTO propiedad_arrendada VALUES (1024, TO_DATE('2014-07-01', 'YYYY-MM-DD'), NULL, 14148957);
        INSERT INTO propiedad_arrendada VALUES (1025, TO_DATE('2013-09-09', 'YYYY-MM-DD'), TO_DATE('2016-12-31', 'YYYY-MM-DD'), 11635470);
        INSERT INTO propiedad_arrendada VALUES (1025, TO_DATE('2017-02-01', 'YYYY-MM-DD'), NULL, 9798044);
        INSERT INTO propiedad_arrendada VALUES (1026, TO_DATE('2010-09-01', 'YYYY-MM-DD'), TO_DATE('2017-08-31', 'YYYY-MM-DD'), 13035746);
        INSERT INTO propiedad_arrendada VALUES (1026, TO_DATE('2017-10-01', 'YYYY-MM-DD'), TO_DATE(TO_CHAR(TO_CHAR(SYSDATE,'YYYY')-1) || '-12-31', 'YYYY-MM-DD'), 11635470);
        COMMIT;
        
        Boolean bucle = false;
        Integer i = 0;

        Integer letra = 0;
        Integer numero = 0;
        Integer noNumeroLetra = 0;
            while (i < clave.length()){
                if (caracteres.contains(Character.toString(clave.charAt(i)))){
                    letra++ ;
                }
                else if (numeros.contains(Character.toString(clave.charAt(i)))){
                    numero++;
                }else {
                    noNumeroLetra++;
                }
                i++;
            }
    
            if (clave.length() >= 6 && letra >= 1 && numero >= 1 && noNumeroLetra >= 1){
                System.out.println("La clave cumple con los requisitos");
            }else{
                System.out.println("la clave no cumple con los requisitos");
            }
            // System.out.println(letra);
            // System.out.println(numero);
            // System.out.println(noNumeroLetra);
    
            lector.close();

    }
}

