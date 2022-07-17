
USE almacen;

CREATE TABLE producto (
                          id_producto NUMERIC(9) NOT NULL,
                          tipo VARCHAR(100) NOT NULL,
                          nombre VARCHAR(100) NOT NULL,
                          descripcion VARCHAR(400) NOT NULL,
                          precio_regular NUMERIC(7,2) NOT NULL,
                          cantidad NUMERIC(4) NOT NULL,
                          url_imagen VARCHAR(200) NOT NULL,
                          PRIMARY KEY (id_producto)
);

ALTER TABLE producto
    add FOREIGN KEY (tipo) REFERENCES tipo_producto(tipo);

CREATE productoTABLE tipo_producto(
	tipo VARCHAR (100) NOT NULL,
	PRIMARY KEY (tipo)
);

INSERT INTO tipo_producto(tipo) VALUES ("computadora");
INSERT INTO tipo_producto(tipo) VALUES ("laptop");
INSERT INTO tipo_producto(tipo) VALUES ("audifonos");
INSERT INTO tipo_producto(tipo) VALUES ("mouse");
INSERT INTO tipo_producto(tipo) VALUES ("celular");
INSERT INTO tipo_producto(tipo) VALUES ("tablet");
INSERT INTO tipo_producto(tipo) VALUES ("teclado");

DROP TABLE tipo;


INSERT INTO producto(id_producto,tipo,nombre,descripcion,precio_regular,cantidad,url_imagen)

VALUES (1,"laptop","LG Gram 15",
        "LG Gram 15 - Ordenador portatil de negocios, pantalla IPS FHD de 15.6 pulgadas, i5-1135G7 de 4.2 GHz (> i7-1065G7), graficos Iris Xe, duracion de la bateria de 21 horas, Wi-Fi6, huella dactilar, KB retroiluminado, Thunderbolt 3, Win11 (16 GB RAM | SSD de 1TB)",
        937.49,300,"https://m.media-amazon.com/images/I/61uPHDPkDLL._AC_SX679_.jpg");

INSERT INTO producto(id_producto,tipo,nombre,descripcion,precio_regular,cantidad,url_imagen)
VALUES (2,"laptop","Portatil HP HD de 14 pulgadas",
        "Portatil HP HD de 14 pulgadas, Windows 11, procesador Intel Celeron de doble nucleo de hasta 2,60 GHz, 4 GB de RAM, SSD de 64 GB, camara web, Dale Pink",
        194.00,100,"https://m.media-amazon.com/images/I/61G9Yr3n6rL._AC_SX679_.jpg");

INSERT INTO producto(id_producto,tipo,nombre,descripcion,precio_regular,cantidad,url_imagen)
VALUES (3,"laptop","SAMSUNG Computadora portatil Galaxy Book2 Pro",
        "SAMSUNG Computadora portatil Galaxy Book2 Pro de 13.3 pulgadas, i7 / 8 GB / 512 GB, procesador Intel Core de 12
        generacion, certificado Evo, ligero, modelo 2022, grafito",
        1250.00,180,"https://m.media-amazon.com/images/I/61M-QNJf4pL._AC_SX679_.jpg");


INSERT INTO producto(id_producto,tipo,nombre,descripcion,precio_regular,cantidad,url_imagen)
VALUES (4,"tablet","Samsung Tableta Android Galaxy Tab A8",
        "Samsung Tableta Android Galaxy Tab A8, pantalla LCD de 10.5 pulgadas, almacenamiento de 32 GB",
        229.00,120,"https://m.media-amazon.com/images/I/61fV4UeHeLL._AC_SX679_.jpg");


commit


SELECT * FROM producto;



