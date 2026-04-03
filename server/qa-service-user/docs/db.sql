
Drop table  if exists t_qa_doctor;
create table t_qa_doctor(
   id BIGINT PRIMARY KEY COMMENT '编号',
   username VARCHAR(50) NOT NULL COMMENT '用户名',
   password VARCHAR(100) NOT NULL COMMENT '密码',
   name varchar(100) NOT NULL COMMENT '姓名',
   title varchar(100) NOT NULL COMMENT '头衔',
   department varchar(50) NOT NULL COMMENT '科室',
   avatar VARCHAR(255) COMMENT '头像',
   experience VARCHAR(255) COMMENT '临床经验',
   specialties JSON COMMENT '专业',
   is_active TINYINT(1) NOT NULL COMMENT '状态:false->离线；true->在线',
   created_by VARCHAR(255) NOT NULL COMMENT '创建人',
   created_at DATETIME DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
   updated_by VARCHAR(255) NOT NULL COMMENT '修改人',
   updated_at DATETIME DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO t_qa_doctor (id, username, password, name, title, department, avatar, experience, specialties, is_active, created_by, created_at, updated_by, updated_at)
VALUES (1761989664077766658, 'dr-zhang-wei', 'e10adc3949ba59abbe56e057f20f883e', '张伟医生', '主任医师', '心内科', 'https://images.pexels.com/photos/5215024/pexels-photo-5215024.jpeg?auto=compress&cs=tinysrgb&w=400', '15年临床经验', '["高血压", "冠心病", "心律失常"]', 1, 'maolu', '2025-11-02 03:54:30', 'maolu', '2025-11-02 03:54:30');
INSERT INTO t_qa_doctor (id, username, password, name, title, department, avatar, experience, specialties, is_active, created_by, created_at, updated_by, updated_at)
VALUES (1761989664077766659, 'dr-li-na', 'e10adc3949ba59abbe56e057f20f883e', '李娜医生', '主任医师', '儿科', 'https://images.pexels.com/photos/5327585/pexels-photo-5327585.jpeg?auto=compress&cs=tinysrgb&w=400', '10年临床经验', '["儿童感冒", "儿童发育", "疫苗接种"]', 1, 'maolu', '2025-11-02 03:54:30', 'maolu', '2025-11-02 03:54:30');
INSERT INTO t_qa_doctor (id, username, password, name, title, department, avatar, experience, specialties, is_active, created_by, created_at, updated_by, updated_at)
VALUES (1761989664077766660, 'dr-wang-qiang', 'e10adc3949ba59abbe56e057f20f883e', '王强医生', '主治医师', '骨科', 'https://images.pexels.com/photos/5327585/pexels-photo-5327585.jpeg?auto=compress&cs=tinysrgb&w=400', '8年临床经验', '["骨折", "关节炎", "运动损伤"]', 1, 'maolu', '2025-11-02 03:54:30', 'maolu', '2025-11-02 03:54:30');
INSERT INTO t_qa_doctor (id, username, password, name, title, department, avatar, experience, specialties, is_active, created_by, created_at, updated_by, updated_at)
VALUES (1761989664077766661, 'dr-liu-min', 'e10adc3949ba59abbe56e057f20f883e', '刘敏医生', '主任医师', '妇产科', 'https://images.pexels.com/photos/5327585/pexels-photo-5327585.jpeg?auto=compress&cs=tinysrgb&w=400', '18年临床经验', '["孕期保健", "妇科炎症", "产后恢复"]', 1, 'maolu', '2025-11-02 03:54:30', 'maolu', '2025-11-02 03:54:30');
INSERT INTO t_qa_doctor (id, username, password, name, title, department, avatar, experience, specialties, is_active, created_by, created_at, updated_by, updated_at)
VALUES (1761989664077766662, 'dr-chen-jie', 'e10adc3949ba59abbe56e057f20f883e', '陈杰医生', '副主任医师', '消化内科', 'https://images.pexels.com/photos/5327585/pexels-photo-5327585.jpeg?auto=compress&cs=tinysrgb&w=400', '12年临床经验', '["胃炎", "肠道疾病", "肝病"]', 1, 'maolu', '2025-11-02 03:54:30', 'maolu', '2025-11-02 03:54:30');



Drop table  if exists t_qa_patient;
create table t_qa_patient(
    id BIGINT PRIMARY KEY COMMENT '编号',
    username VARCHAR(50) NOT NULL COMMENT '用户名',
    password VARCHAR(100) NOT NULL COMMENT '密码',
    name varchar(100) NOT NULL COMMENT '姓名',
    mobile CHAR(11) NOT NULL COMMENT '手机',
    birthday varchar(10) NOT NULL COMMENT '生日',
    gender VARCHAR(10) COMMENT '性别',
    created_by VARCHAR(255) NOT NULL COMMENT '创建人',
    created_at DATETIME DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
    updated_by VARCHAR(255) NOT NULL COMMENT '修改人',
    updated_at DATETIME DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO t_qa_patient (id, username, password, name, mobile, birthday, gender, created_by, created_at, updated_by, updated_at)
VALUES (1761989664077766670, 'zhaoming', 'e10adc3949ba59abbe56e057f20f883e', '赵明', '138****1234', '1985-03-15', '男', 'maolu', '2025-11-02 03:54:30', 'maolu', '2025-11-02 03:54:30');
