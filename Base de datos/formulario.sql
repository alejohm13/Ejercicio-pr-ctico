-- Database: proveedores_db

-- DROP DATABASE IF EXISTS proveedores_db;

CREATE DATABASE proveedores_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;



CREATE TABLE paises (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE departamentos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    pais_id INTEGER NOT NULL,
    FOREIGN KEY (pais_id) REFERENCES paises(id)
);

CREATE TABLE ciudades (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    departamento_id INTEGER NOT NULL,
    FOREIGN KEY (departamento_id) REFERENCES departamentos(id)
);

CREATE TABLE proveedores (
    id SERIAL PRIMARY KEY,
    personeria_juridica VARCHAR(50) NOT NULL,
    nit_rut VARCHAR(50) NOT NULL,
    razon_social VARCHAR(255) NOT NULL,
    representante_legal VARCHAR(255) NOT NULL,
    telefono_contacto VARCHAR(50) NOT NULL,
    email_contacto VARCHAR(255) NOT NULL,
    ciudad_id INTEGER NOT NULL,
    pais_id INTEGER NOT NULL,
    departamento_id INTEGER NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    rut_path VARCHAR(255) NOT NULL,
    FOREIGN KEY (ciudad_id) REFERENCES ciudades(id),
    FOREIGN KEY (pais_id) REFERENCES paises(id),
    FOREIGN KEY (departamento_id) REFERENCES departamentos(id)
);


INSERT INTO paises (nombre) VALUES ('Colombia'), ('Argentina'), ('México');


-- Insertar datos en la tabla departamentos
INSERT INTO departamentos (nombre, pais_id) VALUES 
('Atlántico', (SELECT id FROM paises WHERE nombre = 'Colombia')), 
('Valle del Cauca', (SELECT id FROM paises WHERE nombre = 'Colombia')), 
('Santa Fe', (SELECT id FROM paises WHERE nombre = 'Argentina')), 
('Mendoza', (SELECT id FROM paises WHERE nombre = 'Argentina')), 
('Nuevo León', (SELECT id FROM paises WHERE nombre = 'México')), 
('Jalisco', (SELECT id FROM paises WHERE nombre = 'México')),
('Cundinamarca', (SELECT id FROM paises WHERE nombre = 'Colombia')), 
('Buenos Aires', (SELECT id FROM paises WHERE nombre = 'Argentina')), 
('Ciudad de México', (SELECT id FROM paises WHERE nombre = 'México')),
('Santander', (SELECT id FROM paises WHERE nombre = 'Colombia'));

-- Insertar datos en la tabla ciudades
INSERT INTO ciudades (nombre, departamento_id) VALUES 
('Barranquilla', (SELECT id FROM departamentos WHERE nombre = 'Atlántico')), 
('Cali', (SELECT id FROM departamentos WHERE nombre = 'Valle del Cauca')), 
('Rosario', (SELECT id FROM departamentos WHERE nombre = 'Santa Fe')), 
('San Rafael', (SELECT id FROM departamentos WHERE nombre = 'Mendoza')), 
('Monterrey', (SELECT id FROM departamentos WHERE nombre = 'Nuevo León')), 
('Guadalajara', (SELECT id FROM departamentos WHERE nombre = 'Jalisco')),
('Soacha', (SELECT id FROM departamentos WHERE nombre = 'Cundinamarca')), 
('La Plata', (SELECT id FROM departamentos WHERE nombre = 'Buenos Aires')), 
('Toluca', (SELECT id FROM departamentos WHERE nombre = 'Ciudad de México')),
('Bucaramanga', (SELECT id FROM departamentos WHERE nombre = 'Santander'));

