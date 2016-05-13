ALTER TABLE `ci_sms_info` ADD COLUMN `done` INT(1) NULL DEFAULT 0
COMMENT '是否已经发送过了';
ALTER TABLE `ci_sms_info` ADD COLUMN `sms_type` INT(1) NULL DEFAULT 0
COMMENT '哪种发送模式，0代表，只会发送一次的。1代表可以循环发送';