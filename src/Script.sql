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



-- INSERTANDO CATEGORIAS
INSERT INTO CATEGORIAS (Descripcion) VALUES ('CHOMPAS')
INSERT INTO CATEGORIAS (Descripcion) VALUES ('ZAPATOS')
INSERT INTO CATEGORIAS (Descripcion) VALUES ('CASACAS')


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