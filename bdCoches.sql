CREATE TABLE coches (
    matricula varchar(7),
    marca varchar(50),
    modelo varchar(50),
    color varchar(100),
    anno int,
    cilindrada int,
    caballos int,
    vendido varchar(5),
    constraint "PK_COCHES" primary key (matricula)
);

INSERT INTO  coches(matricula,     marca, modelo,  color, anno, cilindrada, caballos, vendido)
			VALUES ('1111aaa', 'Peugeot',  '206', 'rojo', 2013,        400,      400, 'false');