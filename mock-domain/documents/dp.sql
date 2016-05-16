CREATE SCHEMA `mock` ;


CREATE TABLE `mock`.`sys_company` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `CODE` VARCHAR(45) NULL COMMENT '',
  `NAME` VARCHAR(45) CHARACTER SET 'utf8' NULL COMMENT '',
  `STATUS` INT NULL COMMENT '',
  PRIMARY KEY (`ID`)  COMMENT '',
  UNIQUE INDEX `CODE_UNIQUE` (`CODE` ASC)  COMMENT '',
  INDEX `INX_SYS_COMPANY_CODE` (`CODE` ASC)  COMMENT '');

ALTER TABLE `mock`.`sys_company` 
CHANGE COLUMN `ID` `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '' ,
CHANGE COLUMN `CODE` `code` VARCHAR(45) NULL COMMENT '' ,
CHANGE COLUMN `NAME` `name` VARCHAR(45) NULL DEFAULT NULL COMMENT '' ,
CHANGE COLUMN `STATUS` `status` INT(11) NULL DEFAULT NULL COMMENT '' ;


CREATE TABLE `mock`.`sys_bank` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `NAME` VARCHAR(45) CHARACTER SET 'utf8' NULL COMMENT '',
  PRIMARY KEY (`ID`)  COMMENT '');

ALTER TABLE `mock`.`sys_bank` 
CHANGE COLUMN `ID` `id` BIGINT(20) NOT NULL COMMENT '' ,
CHANGE COLUMN `NAME` `name` VARCHAR(45) NULL COMMENT '' ,
ADD COLUMN `company_code` VARCHAR(45) NULL COMMENT '' AFTER `name`;

ALTER TABLE `mock`.`sys_bank` 
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '' ;

CREATE TABLE `mock`.`bank_card` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `bank_id` BIGINT(20) NOT NULL COMMENT '银行外键',
  `accno` VARCHAR(45) NULL COMMENT '帐号',
  `currtype` INT NULL COMMENT '币种',
  `mdcardno` VARCHAR(45) NULL COMMENT '帐户主卡卡号	6222330053902219',
  `cino` VARCHAR(45) NULL COMMENT '客户信息号	390100077152854',
  `lstbal` DECIMAL(20,4) NULL COMMENT '昨日余额	-268,402.00',
  `lsttrand` TIMESTAMP NULL COMMENT '最后客户交易日	2015-06-09',
  `letpaamt` DECIMAL(20,4) NULL COMMENT '最低还款额	13,410.00',
  `lfeegno` INT NULL COMMENT '滞纳金连续收取次数	2',
  `dtopamt` DECIMAL(20,4) NULL COMMENT '昨日最优还款额	134,102.00',
  `acpayamt` DECIMAL(20,4) NULL COMMENT '帐单应还款金额	134,102.00',
  `lstpbal` DECIMAL(20,4) NULL COMMENT '帐户本金	-265,351.00',
  `lstiint` DECIMAL(20,4) NULL COMMENT '表内利息	-3,051.00',
  `lstoint` DECIMAL(20,4) NULL COMMENT '表外利息	0.00',
  `lstlfee` DECIMAL(20,4) NULL COMMENT '表外滞纳金	0.00',
  PRIMARY KEY (`id`)  COMMENT '');


CREATE TABLE `mock`.`bank_card_fq` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `card_id` BIGINT(20) NULL COMMENT '',
  `mdcardno` VARCHAR(45) NULL COMMENT '协议号	6222330053902219',
  `accno` VARCHAR(45) NULL COMMENT '账号	39010000210037000',
  `amount` DECIMAL(20,4) NULL COMMENT '消费金额	4418200',
  `authamt` DECIMAL(20,4) NULL COMMENT '授权金额	3626100',
  `feeamt` DECIMAL(20,4) NULL COMMENT '持卡人手续费	419287',
  `eachamt` DECIMAL(20,4) NULL COMMENT '每期金额	122700',
  `currtype` INT NULL COMMENT '币种	001',
  `totnum` INT NULL COMMENT '总期数	036',
  `workdate` TIMESTAMP NULL COMMENT '申请日期	2014-09-09',
  `thisamt` DECIMAL(20,4) NULL COMMENT '上期扣款金额	122700',
  `realamt` DECIMAL(20,4) NULL COMMENT '已入账金额	1105300',
  `errnum` INT NULL COMMENT '累计违约次数	003',
  `errdate` TIMESTAMP NULL COMMENT '滞纳金最后收取日期	2015-05-25',
  `thispfee` DECIMAL(20,4) NULL COMMENT '上期扣款手续费	11600',
  `realpfee` DECIMAL(20,4) NULL COMMENT '已入账手续费	106087',
  `firstamt` DECIMAL(20,4) NULL COMMENT '首期金额	123700',
  `ortrxdate` TIMESTAMP NULL COMMENT '原消费日期	2014-09-05',
  `eachpfee` DECIMAL(20,4) NULL COMMENT '每期手续费	11600',
  `ortrxamt` DECIMAL(20,4) NULL COMMENT '原消费金额	4418200',
  `firstpfee` DECIMAL(20,4) NULL COMMENT '首期手续费	13287',
  `leftnum` INT NULL COMMENT '剩余期数	027',
  `paybamt` DECIMAL(20,4) NULL COMMENT '分期付款已还款本金	974249',
  `paybfee` DECIMAL(20,4) NULL COMMENT '分期付款已还款手续费	106087',
  `unpaybamt` DECIMAL(20,4) NULL COMMENT '分期付款未还款本金	131051',
  `unpaybfee` DECIMAL(20,4) NULL COMMENT '分期付款未还款手续费	0',
  `lstauamt` DECIMAL(20,4) NULL COMMENT '昨日授权本金	3,435,600.00',
  `conernum` INT NULL COMMENT '连续违约次数	002',
  `conerdate` TIMESTAMP NULL COMMENT '上次违约日期	2015-05-25',
  `backfamt` DECIMAL(20,4) NULL COMMENT '已退持卡人手续费	0.00',
  PRIMARY KEY (`id`)  COMMENT '');

ALTER TABLE `mock`.`sys_bank` 
RENAME TO  `mock`.`bank` ;

CREATE TABLE `mock`.`sys_operation` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `code` VARCHAR(45) NULL COMMENT '',
  `name` VARCHAR(45) CHARACTER SET 'utf8' NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `code_UNIQUE` (`code` ASC)  COMMENT '',
  INDEX `IDX_SYS_OPR_CODE` (`code` ASC)  COMMENT '');

ALTER TABLE `mock`.`bank` 
ADD COLUMN `version` BIGINT(20) NULL DEFAULT 0 COMMENT '' AFTER `company_code`;

ALTER TABLE `mock`.`bank_card` 
ADD COLUMN `version` BIGINT(20) NULL DEFAULT 0 COMMENT '' AFTER `lstlfee`;

ALTER TABLE `mock`.`bank_card_fq` 
ADD COLUMN `version` BIGINT(20) NULL DEFAULT 0 COMMENT '' AFTER `backfamt`;

CREATE TABLE `mock`.`sys_resouces` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `code` VARCHAR(45) NULL COMMENT '',
  `name` VARCHAR(45) CHARACTER SET 'utf8' NULL COMMENT '',
  `url` VARCHAR(200) NULL COMMENT '',
  `hierarchy` INT NULL DEFAULT 999 COMMENT '',
  `seq` INT NULL DEFAULT 999 COMMENT '',
  `show` TINYINT(1) NULL DEFAULT 0 COMMENT '',
  `deleted` TINYINT(1) NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');

ALTER TABLE `mock`.`sys_resouces` 
ADD INDEX `IDX_SYS_RES_CODE` (`code` ASC)  COMMENT '',
ADD UNIQUE INDEX `code_UNIQUE` (`code` ASC)  COMMENT '';

CREATE TABLE `mock`.`sys_permission` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `code` VARCHAR(45) NULL COMMENT '',
  `name` VARCHAR(45) CHARACTER SET 'utf8' NULL COMMENT '',
  `description` VARCHAR(200) CHARACTER SET 'utf8' NULL COMMENT '',
  `show` TINYINT(1) NULL DEFAULT 0 COMMENT '',
  `deleted` TINYINT(1) NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `code_UNIQUE` (`code` ASC)  COMMENT '',
  INDEX `IDX_SYS_PER_CODE` (`code` ASC)  COMMENT '');

CREATE TABLE `mock`.`sys_perm_res_opr` (
  `permission_code` VARCHAR(45) NULL COMMENT '',
  `res_code` VARCHAR(45) NULL COMMENT '',
  `opr_code` VARCHAR(45) NULL COMMENT '',
  INDEX `IDX_SYS_PERM_RES_OPR_CODE` (`permission_code` ASC)  COMMENT '');

CREATE TABLE `mock`.`sys_role` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `code` VARCHAR(45) NULL COMMENT '',
  `name` VARCHAR(45) CHARACTER SET 'utf8' NULL COMMENT '',
  `description` VARCHAR(200) CHARACTER SET 'utf8' NULL COMMENT '',
  `show` TINYINT(1) NULL DEFAULT 0 COMMENT '',
  `deleted` TINYINT(1) NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `code_UNIQUE` (`code` ASC)  COMMENT '',
  INDEX `IDX_SYS_ROLE_CODE` (`code` ASC)  COMMENT '');

CREATE TABLE `mock`.`sys_role_permission` (
  `role_code` VARCHAR(45) NULL COMMENT '',
  `permission_code` VARCHAR(45) NULL COMMENT '',
  INDEX `IDX_SYS_ROIE_PERM_CODE` (`role_code` ASC)  COMMENT '');

CREATE TABLE `mock`.`sys_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `username` VARCHAR(45) NULL COMMENT '',
  `name` VARCHAR(45) CHARACTER SET 'utf8' NULL COMMENT '',
  `version` BIGINT(20) NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `IDX_SYS_USER_USERNAME` (`username` ASC)  COMMENT '');

ALTER TABLE `mock`.`sys_user` 
ADD COLUMN `company_code` VARCHAR(45) NULL COMMENT '' AFTER `name`,
ADD UNIQUE INDEX `username_UNIQUE` (`username` ASC)  COMMENT '';

ALTER TABLE `mock`.`sys_user` 
ADD COLUMN `salt` VARCHAR(45) NULL COMMENT '' AFTER `username`,
ADD COLUMN `password` VARCHAR(45) NULL COMMENT '' AFTER `salt`;

CREATE TABLE `mock`.`sys_user_role` (
  `user_id` BIGINT(20) NULL COMMENT '',
  `role_code` VARCHAR(45) NULL COMMENT '',
  INDEX `IDX_SYS_USER_ROLE_ID` (`user_id` ASC)  COMMENT '');

ALTER TABLE `mock`.`sys_user_role` 
ADD COLUMN `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '' FIRST,
ADD PRIMARY KEY (`id`)  COMMENT '';

ALTER TABLE `mock`.`sys_perm_res_opr` 
ADD COLUMN `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '' FIRST,
ADD PRIMARY KEY (`id`)  COMMENT '';

ALTER TABLE `mock`.`sys_role_permission` 
ADD COLUMN `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '' FIRST,
ADD PRIMARY KEY (`id`)  COMMENT '';

ALTER TABLE `mock`.`sys_company` 
CHANGE COLUMN `status` `status` VARCHAR(10) NULL DEFAULT NULL COMMENT '' ;

ALTER TABLE `mock`.`sys_resouces` 
ADD COLUMN `parent_code` VARCHAR(45) NULL COMMENT '' AFTER `code`;


ALTER TABLE `mock`.`bank_card_fq` 
DROP COLUMN `ortrxamt`;

ALTER TABLE `mock`.`bank_card_fq` 
ADD COLUMN `overdue_fine` DECIMAL(20,4) NULL COMMENT '' AFTER `version`;
