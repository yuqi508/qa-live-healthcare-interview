package com.leansofx.qaserviceuser.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.leansofx.qaserviceuser.common.Entity;
import lombok.Data;

@Data
@TableName(value = "t_qa_doctor", autoResultMap = true)
public class DoctorEntity extends Entity {

    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 姓名 */
    private String name;
    /** 头衔 */
    private String title;
    /** 科室 */
    private String department;
    /** 头像 */
    private String avatar;
    /** 临床经验 */
    private String experience;
    /** 专业 */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private String[] specialties;
    /** 状态:0->离线；1->在线 */
    private boolean isActive;
}
