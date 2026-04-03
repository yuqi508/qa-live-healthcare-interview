package com.leansofx.qaserviceuser.dto.resp;

import com.baomidou.mybatisplus.annotation.TableName;
import com.leansofx.qaserviceuser.common.Entity;
import lombok.Data;

@Data
public class PatientResp {

    /** 用户名 */
    private String username;
    /** 姓名 */
    private String name;
    /** 头衔 */
    private String mobile;
    /** 科室 */
    private String birthday;
    /** 头像 */
    private String gender;
}
