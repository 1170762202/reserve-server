DROP TABLE
    IF
        EXISTS t_user;
CREATE TABLE t_user
(
    id       VARCHAR(255) NOT NULL COMMENT '主键ID',
    NAME     VARCHAR(30)  NULL DEFAULT NULL COMMENT '姓名',
    account  VARCHAR(50)  NULL DEFAULT NULL COMMENT '帐号',
    PASSWORD VARCHAR(50)  NULL DEFAULT NULL COMMENT '密码',
    PRIMARY KEY (id)
);
DROP TABLE
    IF
        EXISTS t_user_info;
CREATE TABLE t_user_info
(
    id         VARCHAR(255) NOT NULL COMMENT '主键ID',
    user_id    VARCHAR(255) NULL DEFAULT NULL COMMENT '用户id',
    user_token VARCHAR(255) NULL DEFAULT NULL COMMENT '用户token',
    PRIMARY KEY (id)
);
DROP TABLE
    IF
        EXISTS t_order;
CREATE TABLE t_order
(
    id            VARCHAR(255) NOT NULL COMMENT '主键ID',
    reserve_phone VARCHAR(20)  NULL     DEFAULT NULL COMMENT '手机号',
    address       VARCHAR(100) NULL     DEFAULT NULL COMMENT '地址',
    join_number   VARCHAR(10)  NULL     DEFAULT NULL COMMENT '加入人数',
    reserve_type  VARCHAR(50)  NULL     DEFAULT NULL COMMENT '类型',
    start_date    TIMESTAMP    NULL COMMENT '开始日期',
    end_date      TIMESTAMP    NULL COMMENT '结束日期',
    budget        VARCHAR(50)  NULL     DEFAULT NULL COMMENT '预算',
    create_time   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
);
DROP TABLE
    IF
        EXISTS t_condition;
CREATE TABLE t_condition
(
    id   VARCHAR(255) NOT NULL COMMENT '主键ID',
    type INTEGER(10)  NOT NULL DEFAULT 0 COMMENT '类型',

    VALUE
         VARCHAR(50)  NULL     DEFAULT NULL COMMENT '值',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS t_address_info;
CREATE TABLE t_address_info
(
    id                          VARCHAR(255) NOT NULL COMMENT '主键ID',
    address_name                VARCHAR(50)  NOT NULL DEFAULT 0 COMMENT '名字',
    address_description         VARCHAR(100) NOT NULL DEFAULT 0 COMMENT '描述',
    address_image               VARCHAR(100) NOT NULL DEFAULT 0 COMMENT '图片logo',
    address_level               VARCHAR(50)  NULL     DEFAULT NULL COMMENT '等级',
    address_room_number         VARCHAR(50)  NULL     DEFAULT NULL COMMENT '房间数量',
    address_area_size           VARCHAR(50)  NULL     DEFAULT NULL COMMENT '场地面积',
    address_capacity            VARCHAR(50)  NULL     DEFAULT NULL COMMENT '场地容量(人数)',
    address_outside_park_number VARCHAR(50)  NULL     DEFAULT NULL COMMENT '室外场地容量(人数)',
    address_inside_park_number  VARCHAR(50)  NULL     DEFAULT NULL COMMENT '室内场地容量(人数)',
    create_time                 TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS t_address_room_info;
CREATE TABLE t_address_room_info
(
    id               VARCHAR(255)   NOT NULL COMMENT '主键ID',
    address_id       VARCHAR(255)   NOT NULL COMMENT '地址id',
    room_name        VARCHAR(50)    NOT NULL DEFAULT 0 COMMENT '名字',
    room_description VARCHAR(100)   NOT NULL DEFAULT 0 COMMENT '描述',
    room_image       VARCHAR(10000) NOT NULL DEFAULT 0 COMMENT '图片logo',
    room_area_size   VARCHAR(50)    NULL     DEFAULT NULL COMMENT '场地面积',
    room_capacity    VARCHAR(50)    NULL     DEFAULT NULL COMMENT '场地容量(人数)',
    create_time      TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS t_case;
CREATE TABLE t_case
(
    id          VARCHAR(255) NOT NULL COMMENT '主键ID',
    case_name   VARCHAR(255) NOT NULL COMMENT '案例名字',
    create_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS t_case_info;
CREATE TABLE t_case_info
(
    id                    VARCHAR(255)   NOT NULL COMMENT '主键ID',
    case_id               VARCHAR(255)   NOT NULL COMMENT '案例id',
    case_info_name        VARCHAR(255)   NOT NULL COMMENT '案例名字',
    case_info_description VARCHAR(100)   NOT NULL DEFAULT 0 COMMENT '描述',
    case_info_image       VARCHAR(10000) NOT NULL DEFAULT 0 COMMENT '案例图片',
    create_time           TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS t_sundry_info;
CREATE TABLE t_sundry_info
(
    id          VARCHAR(255) NOT NULL COMMENT '主键ID',
    mobile      VARCHAR(20)  NOT NULL COMMENT '手机号',
    mobile_code VARCHAR(255) NOT NULL COMMENT '验证码',
    create_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS t_admin_info;
CREATE TABLE t_admin_info
(
    id           VARCHAR(255) NOT NULL COMMENT '主键ID',
    admin_mobile VARCHAR(20)  NOT NULL COMMENT '管理员手机号',
    create_time  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS t_banner;
CREATE TABLE t_banner
(
    id           VARCHAR(255) NOT NULL COMMENT '主键ID',
    banner_type  VARCHAR(20)  NOT NULL COMMENT '0手机1PC',
    banner_image VARCHAR(100)   NOT NULL COMMENT '轮播图url',
    create_time  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (id)
);