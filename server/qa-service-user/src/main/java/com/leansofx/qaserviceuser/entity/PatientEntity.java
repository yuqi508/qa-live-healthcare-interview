package com.leansofx.qaserviceuser.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leansofx.qaserviceuser.common.Entity;
import lombok.Data;

@Data
@TableName(value = "t_qa_patient", autoResultMap = true)
public class PatientEntity extends Entity {

    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 姓名 */
    private String name;
    /** 头衔 */
    private String mobile;
    /** 科室 */
    private String birthday;
    /** 头像 */
    private String gender;
}
