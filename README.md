宿迁人口管控项目
====
宿迁人口管控项目

# 注意事项：
1. 当前登录的用户信息本来想从cookie里取到的，后来发现并不是总能够从request获取到，故改成前端传递当前登录人的警号，再去数据库里查询一次详细信息；
2. 登录的逻辑是在前端控制的，后端并没有写一个登录拦截器作登录验证
3. 下载走访核实单的WORD文件，使用低版本或WPS时样式错乱，可以使用打印功能里的另外为PDF格式文件解决
4. 用水异常信息列表及调查走访管理信息列表都有数据权限过滤
5. 页面上缺少返回功能的按钮，目前当再次进入原来已经筛选过条件的页面时，筛选条件丢失，后续可以解决掉
6. 由于去宿迁部署项目时，内网使用IP访问，并不是我们开发时用的 popc.jd.com，这个IP地址已经更新到前端页面里了，在后续开发时请注意这个问题


# SQL语句
CREATE DATABASE `popc`;

DROP TABLE IF EXISTS `app_house_water_using_info`;
CREATE TABLE `app_house_water_using_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `pro_coll_id` bigint(20) DEFAULT NULL COMMENT '房产总数据ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '小区名称',
  `community_district` varchar(50) DEFAULT NULL COMMENT '小区区域',
  `apartment_num` varchar(50) DEFAULT NULL COMMENT '楼栋名称',
  `house_unit` varchar(10) DEFAULT NULL COMMENT '单元',
  `room_num` varchar(10) DEFAULT NULL COMMENT '房（室）号',
  `house_status` varchar(20) DEFAULT NULL COMMENT '房屋状态',
  `landlord_name` varchar(20) DEFAULT NULL COMMENT '房东姓名',
  `landlord_id` varchar(20) DEFAULT NULL COMMENT '房东身份证',
  `landlord_phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `previous_water_consumption` varchar(50) DEFAULT NULL COMMENT '上次用水量',
  `current_water_consumption` varchar(50) DEFAULT NULL COMMENT '本次用水量',
  `avg_water_consumption` varchar(50) DEFAULT NULL COMMENT '平均月用水量',
  `month_on_month_growth` varchar(50) DEFAULT NULL COMMENT '环比增长',
  `coefficient_variation` varchar(50) DEFAULT NULL COMMENT '变异系数',
  `standard_score` varchar(50) DEFAULT NULL COMMENT '标准分数',
  `officer_no` varchar(10) DEFAULT NULL COMMENT '警员警号',
  `judge_abnormal_time` varchar(20) DEFAULT NULL COMMENT '判定异常时间',
  `house_water_status` varchar(20) DEFAULT NULL COMMENT '房屋用水状态 异常  正常(默认)',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `dt` varchar(10) DEFAULT NULL COMMENT '分区信息',
  PRIMARY KEY (`id`),
  KEY `INDEX_PROID` (`pro_coll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用水异常判定表';


DROP TABLE IF EXISTS `app_survey_visit_abnormal_info`;
CREATE TABLE `app_survey_visit_abnormal_info` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `pro_coll_id` bigint(20) DEFAULT NULL COMMENT '房产总数据ID',
  `abnormal_type` varchar(20) DEFAULT NULL COMMENT '异常类型',
  `abnormal_info` varchar(500) DEFAULT NULL COMMENT '异常信息',
  `community_district` varchar(50) DEFAULT NULL COMMENT '小区区域',
  `community_name` varchar(50) DEFAULT NULL COMMENT '小区名称',
  `apartment_num` varchar(50) DEFAULT NULL COMMENT '楼栋名称',
  `house_unit` varchar(10) DEFAULT NULL COMMENT '单元',
  `room_num` varchar(10) DEFAULT NULL COMMENT '房（室）号',
  `house_status` varchar(20) DEFAULT NULL COMMENT '房屋状态',
  `landlord_name` varchar(20) DEFAULT NULL COMMENT '房东姓名',
  `landlord_id` varchar(20) DEFAULT NULL COMMENT '房东身份证',
  `landlord_phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `judge_abnormal_time` varchar(20) DEFAULT NULL COMMENT '判定异常时间',
  `officer_name` varchar(50) DEFAULT NULL COMMENT '负责人--即判定异常操作人',
  `officer_phone` varchar(50) DEFAULT NULL COMMENT '联系方式--即判定异常操作人',
  `solve_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否处理异常: 0 已处理; 1 未处理',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQE_HOUSE` (`pro_coll_id`),
  KEY `INDEX_PROID` (`pro_coll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调查走访--异常信息表';



DROP TABLE IF EXISTS `app_survey_visit_check_form`;
CREATE TABLE `app_survey_visit_check_form` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `abnormal_info_id` bigint(20) DEFAULT NULL COMMENT 'app_survey_visit_abnormal_info表主键',
  `lodge_person` varchar(1000) DEFAULT NULL COMMENT '寄住人员，用分号隔开',
  `house_rent` varchar(1000) DEFAULT NULL COMMENT '房屋出租，用分号隔开',
  `other_reason` varchar(200) DEFAULT NULL COMMENT '其他原因',
  `check_person` varchar(100) DEFAULT NULL COMMENT '核实人员，用分号隔开',
  `visit_person` varchar(100) DEFAULT NULL COMMENT '走访人员，用分号隔开',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `INDEX_ABNORMALID` (`abnormal_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='调查走访--走访核实单';


DROP TABLE IF EXISTS `app_resident_base_info`;
CREATE TABLE `app_resident_base_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `resident_name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `resident_id_type` varchar(20) DEFAULT NULL COMMENT '证件类型',
  `resident_id` varchar(20) DEFAULT NULL COMMENT '证件号码',
  `birth_date` varchar(10) DEFAULT NULL COMMENT '出生日期',
  `resident_sex` varchar(5) DEFAULT NULL COMMENT '性别',
  `resident_type` varchar(10) DEFAULT NULL COMMENT '人员类型/户籍人口/寄住人口/',
  `house_number` varchar(50) DEFAULT NULL COMMENT '户号',
  `relat_2_landlord` varchar(20) DEFAULT NULL COMMENT '跟户主关系',
  `census_register` varchar(50) DEFAULT NULL COMMENT '户籍地址',
  `contact_info` varchar(20) DEFAULT NULL COMMENT '联系方式',
  `habitant_address` varchar(50) DEFAULT NULL COMMENT '居住地址',
  `address_match_status` tinyint(4) DEFAULT NULL COMMENT '地址是否匹配成功 1 是 0 否',
  `property_right_certificate` varchar(50) DEFAULT NULL COMMENT '产权证书',
  `criminal_info` varchar(500) DEFAULT NULL COMMENT '涉警犯罪记录',
  `company_info` varchar(500) DEFAULT NULL COMMENT '单位信息',
  `company_address` varchar(50) DEFAULT NULL COMMENT '单位地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `data_flag` tinyint(4) DEFAULT NULL COMMENT '指系统数据新录入数据 flag=2',
  `pro_coll_id` bigint(20) DEFAULT NULL COMMENT '房产总ID',
  PRIMARY KEY (`id`),
  KEY `INDEX_PROID` (`pro_coll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人口信息表';


DROP TABLE IF EXISTS `app_houses_basic_infromation_da`;
CREATE TABLE `app_houses_basic_infromation_da` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `pro_coll_id` bigint(20) DEFAULT NULL COMMENT '房产总数据ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '小区名称',
  `community_district` varchar(50) DEFAULT NULL COMMENT '区域',
  `apartment_num` varchar(50) DEFAULT NULL COMMENT '楼栋名称',
  `house_unit` varchar(50) DEFAULT NULL COMMENT '单元',
  `room_num` varchar(50) DEFAULT NULL COMMENT '房(室)号',
  `house_status` varchar(50) DEFAULT NULL COMMENT '房屋状态',
  `landlord_name` varchar(50) DEFAULT NULL COMMENT '房东姓名',
  `landlord_id` varchar(50) DEFAULT NULL COMMENT '房东身份证',
  `landlord_phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `property_right_certificate` varchar(50) DEFAULT NULL COMMENT '产权证书',
  `resident_name` varchar(50) DEFAULT NULL COMMENT '入住人员姓名',
  `resident_id` varchar(50) DEFAULT NULL COMMENT '入住人员证件号码',
  `resident_sex` varchar(50) DEFAULT NULL COMMENT '入住人员性别',
  `birth_date` varchar(50) DEFAULT NULL COMMENT '入住人员出生日期',
  `contact_info` varchar(50) DEFAULT NULL COMMENT '入住人员联系方式',
  PRIMARY KEY (`id`),
  KEY `INDEX_PROID` (`pro_coll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房屋基础信息表';



DROP TABLE IF EXISTS `app_houses_deal_infromation_da`;
CREATE TABLE `app_houses_deal_infromation_da` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `pro_coll_id` bigint(20) DEFAULT NULL COMMENT '房产总数据ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '小区名称',
  `community_district` varchar(50) DEFAULT NULL COMMENT '区域',
  `apartment_num` varchar(50) DEFAULT NULL COMMENT '楼栋名称',
  `house_unit` varchar(50) DEFAULT NULL COMMENT '单元',
  `room_num` varchar(50) DEFAULT NULL COMMENT '房(室)号',
  `property_issue_date` varchar(50) DEFAULT NULL COMMENT '产权证发证日期',
  `landlord_name` varchar(50) DEFAULT NULL COMMENT '买房人姓名',
  `landlord_id` varchar(50) DEFAULT NULL COMMENT '买房人身份证',
  `property_right_certificate_number` varchar(50) DEFAULT NULL COMMENT '产权证书',
  PRIMARY KEY (`id`),
  KEY `INDEX_PROID` (`pro_coll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房屋交易信息表';



DROP TABLE IF EXISTS `app_houses_infromation_query_da`;
CREATE TABLE `app_houses_infromation_query_da` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `pro_coll_id` bigint(20) DEFAULT NULL COMMENT '房产总数据ID',
  `community_name` varchar(50) DEFAULT NULL COMMENT '小区名称',
  `community_district` varchar(50) DEFAULT NULL COMMENT '区域',
  `apartment_num` varchar(50) DEFAULT NULL COMMENT '楼栋名称',
  `house_unit` varchar(50) DEFAULT NULL COMMENT '单元',
  `room_num` varchar(50) DEFAULT NULL COMMENT '房(室)号',
  `house_status` varchar(50) DEFAULT NULL COMMENT '房屋状态',
  `landlord_name` varchar(50) DEFAULT NULL COMMENT '房东姓名',
  `landlord_id` varchar(50) DEFAULT NULL COMMENT '房东身份证',
  `landlord_phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `property_right_certificate_number` varchar(50) DEFAULT NULL COMMENT '产权证号',
  PRIMARY KEY (`id`),
  KEY `INDEX_PROID` (`pro_coll_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房屋信息查询表';



DROP TABLE IF EXISTS `app_community_info`;
CREATE TABLE `app_community_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `community_name` varchar(50) DEFAULT NULL COMMENT '小区名',
  `community_alias` varchar(50) DEFAULT NULL COMMENT '小区别名',
  `community_address` varchar(100) DEFAULT NULL COMMENT '小区地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `INDEX_COMMUNITYNAME` (`community_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='小区信息';



DROP TABLE IF EXISTS `app_community_officer`;
CREATE TABLE `app_community_officer` (
  `community_id` int(11) DEFAULT NULL COMMENT 'app_community_info 表主键',
  `officer_id` int(11) DEFAULT NULL COMMENT 'app_officer_info 表主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='app_community_info 和 app_officer_info 关联表';


DROP TABLE IF EXISTS `app_officer_info`;
CREATE TABLE `app_officer_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `officer_name` varchar(50) DEFAULT NULL COMMENT '警员名称',
  `officer_no` varchar(50) DEFAULT NULL COMMENT '警号',
  `officer_phone` varchar(20) DEFAULT NULL COMMENT '警员联系方式',
  `officer_station` varchar(50) DEFAULT NULL COMMENT '站点',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标志位: 1 已删除; 0 正常',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态: 1 禁用; 0 启用',
  `role` varchar(10) NOT NULL DEFAULT 'officer' COMMENT '角色: officer, admin',
  `menu_ids` varchar(500) DEFAULT NULL COMMENT '权限菜单',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `U_OFFICER_NO` (`officer_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='警员信息表';

