-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sistema_ventas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sistema_ventas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sistema_ventas` DEFAULT CHARACTER SET utf8 ;
USE `sistema_ventas` ;

-- -----------------------------------------------------
-- Table `sistema_ventas`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistema_ventas`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `sistema_ventas`.`Cliente` (
  `idCliente` INT(8) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `ApellidoPaterno` VARCHAR(45) NULL,
  `ApellidoMaterno` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `DocumentoIdentidad` INT(8) NULL,
    `Password` VARCHAR(25) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_ventas`.`ModoPago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistema_ventas`.`ModoPago` ;

CREATE TABLE IF NOT EXISTS `sistema_ventas`.`ModoPago` (
  `idModoPago` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`idModoPago`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_ventas`.`TipoPago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistema_ventas`.`TipoPago` ;

CREATE TABLE IF NOT EXISTS `sistema_ventas`.`TipoPago` (
  `idTipoPago` INT NOT NULL AUTO_INCREMENT,
  `Descripción` VARCHAR(45) NULL,
  PRIMARY KEY (`idTipoPago`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_ventas`.`DocumentoPago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistema_ventas`.`DocumentoPago` ;

CREATE TABLE IF NOT EXISTS `sistema_ventas`.`DocumentoPago` (
  `idDocumentoPago` INT NOT NULL AUTO_INCREMENT,
  `Fecha` DATE NULL,
  `PrecioTotal` DOUBLE NULL,
  `ModoPago_idModoPago` INT NOT NULL,
  `TipoPago_idTipoPago` INT NOT NULL,
  `Cliente_idCliente` INT(8) NOT NULL,
  PRIMARY KEY (`idDocumentoPago`),
  INDEX `fk_DocumentoPago_ModoPago1_idx` (`ModoPago_idModoPago` ASC),
  INDEX `fk_DocumentoPago_TipoPago1_idx` (`TipoPago_idTipoPago` ASC),
  INDEX `fk_DocumentoPago_Cliente1_idx` (`Cliente_idCliente` ASC),
  CONSTRAINT `fk_DocumentoPago_ModoPago1`
    FOREIGN KEY (`ModoPago_idModoPago`)
    REFERENCES `sistema_ventas`.`ModoPago` (`idModoPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DocumentoPago_TipoPago1`
    FOREIGN KEY (`TipoPago_idTipoPago`)
    REFERENCES `sistema_ventas`.`TipoPago` (`idTipoPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DocumentoPago_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `sistema_ventas`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_ventas`.`Categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistema_ventas`.`Categoria` ;

CREATE TABLE IF NOT EXISTS `sistema_ventas`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_ventas`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistema_ventas`.`Producto` ;

CREATE TABLE IF NOT EXISTS `sistema_ventas`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `NombreProducto` VARCHAR(45) NULL,
  `Precio` DOUBLE NULL,
  `Categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_Producto_Categoria1_idx` (`Categoria_idCategoria` ASC),
  CONSTRAINT `fk_Producto_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `sistema_ventas`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistema_ventas`.`Detalle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistema_ventas`.`Detalle` ;

CREATE TABLE IF NOT EXISTS `sistema_ventas`.`Detalle` (
  `Secuencia` INT NOT NULL,
  `DocumentoPago_idDocumentoPago` INT NOT NULL,
  `Cantidad` INT NULL,
  `Producto_idProducto` INT NOT NULL,
  `Precio_parcial` DOUBLE NULL,
  PRIMARY KEY (`Secuencia`, `DocumentoPago_idDocumentoPago`),
  INDEX `fk_Detalle_DocumentoPago1_idx` (`DocumentoPago_idDocumentoPago` ASC),
  INDEX `fk_Detalle_Producto1_idx` (`Producto_idProducto` ASC),
  CONSTRAINT `fk_Detalle_DocumentoPago1`
    FOREIGN KEY (`DocumentoPago_idDocumentoPago`)
    REFERENCES `sistema_ventas`.`DocumentoPago` (`idDocumentoPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `sistema_ventas`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- INSERTANDO CLIENTES

INSERT INTO CLIENTE (Nombre,ApellidoPaterno,ApellidoMaterno,Email,DocumentoIdentidad,Password) VALUES ('Almendra','Nunez','Calderon','almendra.nunezc@pucp.pe','74134794','12345678');
INSERT INTO CLIENTE (Nombre,ApellidoPaterno,ApellidoMaterno,Email,DocumentoIdentidad,Password) VALUES ('Brunella','Horna','Costa','babycandy@hotmail.com','11111111','12345678');
INSERT INTO CLIENTE (Nombre,ApellidoPaterno,ApellidoMaterno,Email,DocumentoIdentidad,Password) VALUES ('Tilsa','Lozano','Sibila','soltera@hotmail.com','22222222','12345678');
INSERT INTO CLIENTE (Nombre,ApellidoPaterno,ApellidoMaterno,Email,DocumentoIdentidad,Password) VALUES ('Olinda','Castaneda','Castaneda','lapartidora@hotmail.com','33333333','12345678');
INSERT INTO CLIENTE (Nombre,ApellidoPaterno,ApellidoMaterno,Email,DocumentoIdentidad,Password) VALUES ('Alejandra','Baigorrea','Alcala','larubiadegamarra@hotmail.com','44444444','12345678');

-- INSERTANDO CATEGORIAS
INSERT INTO CATEGORIA (Descripcion) VALUES ('CHOMPAS')
INSERT INTO CATEGORIA (Descripcion) VALUES ('ZAPATOS')
INSERT INTO CATEGORIA (Descripcion) VALUES ('ABRIGOS')
INSERT INTO CATEGORIA (Descripcion) VALUES ('CASACAS')

-- INSERTANTO PRODUCTOS
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Chompa Vivix7' , 77.4 , 1);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Sweater Plano Liso7' , 99, 1);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Sweater Apuesta Miniprint' , 79 , 1);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Sweater Temp V1' , 71.10 , 1);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Sweater Detalles DDM' ,55.30,1);

INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Zapatos Daelyn Hill' ,244.30,2);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Zapatos Hombre Dress' ,2330.10,2);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Zapatillas Urban' ,39.90,2);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Sandalias Mujer Kostas35' ,409,2);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Sandalias Mujer Prov-Prima Go' ,99,2);

INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Blazer Leli' ,259,3);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Blazer Jade Doble' ,167.40,3);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Chaquetón N4CQB510KA' ,259,3);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Chaleco Pelos' ,149,3);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Cárdigan Soda' ,149,3);

INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Casaca Vent Thermo_R Runner Jkt W' ,359.20,4);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Caftán Zen' ,179,4);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Blazer Boreal8' ,229,4);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Chaleco Nuptse' ,419.30,4);
INSERT INTO PRODUCTO (NombreProducto, Precio, Categoria_idCategoria)
VALUES ('Cárdigan Soda' ,149,4);








