package com.leansofx.qaserviceuser.dto.resp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

@Data
public class DoctorResp {
    /** 用户名 */
    private String username;
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
