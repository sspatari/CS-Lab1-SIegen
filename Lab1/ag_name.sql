# phpMyAdmin SQL Dump
# version 2.5.6
# http://www.phpmyadmin.net
#
# Host: localhost
# Generation Time: Oct 06, 2005 at 06:13 PM
# Server version: 4.0.18
# PHP Version: 4.3.4
#
# Database : `csp_ue_ws_0506_data`
#

# --------------------------------------------------------

#
# Table structure for table `ag_name`
#

DROP TABLE IF EXISTS `ag_name`;
CREATE TABLE `ag_name` (
  `AG_ID` int(11) NOT NULL default '0',
  `AG_NAME` varchar(60) NOT NULL default '',
  PRIMARY KEY  (`AG_ID`)
) ENGINE=MyISAM COMMENT='RELATION AG_NAME zu AG_ID';

#
# Dumping data for table `ag_name`
#

INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (1, 'ADIDAS-SALOMON AG');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (2, 'ALLIANZ AG VNA O.N');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (3, 'ALTANA AG O.N.');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (4, 'BASF AG O.N.');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (5, 'BMW');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (6, 'Bayer');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (7, 'RWE');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (8, 'IBM');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (9, 'Volkswagen');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (10, 'MAN ST');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (11, 'DaimlerChrysler');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (12, 'Continental');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (13, 'Fresenius M.C.');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (14, 'Metro');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (15, 'Commerzbank');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (17, 'Linde');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (19, 'Dt.Telekom');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (20, 'ThyssenKrupp');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (21, 'E.ON');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (22, 'HypoVereinsbank');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (23, 'Lufthansa');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (24, 'Schering');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (25, 'Henkel Vz.');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (26, 'MLP');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (27, 'TUI');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (29, 'Siemens');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (30, 'Muenchener Rueck');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (18, 'Dt. Post');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (28, 'Infineon');
INSERT INTO `ag_name` (`AG_ID`, `AG_NAME`) VALUES (16, 'Porsche');
