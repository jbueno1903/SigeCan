CREATE DATABASE `sigecan` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */;

-- CREAMOS EL USUARIO DE LA APLICACION
CREATE USER 'dev_seek'@'%' IDENTIFIED BY 'dev@2024';
SET PASSWORD FOR 'dev_seek'@'%' = PASSWORD('dev@2024');
grant ALL privileges ON sigecan.* to 'dev_seek'@'%';