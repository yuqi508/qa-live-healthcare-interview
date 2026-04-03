package com.leansofx.qaserviceuser.error;

import com.leansofx.qaserviceuser.common.base.IErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode implements IErrorCode {

    USER_GROUP_NOT_EXIST("AM00101", "用户分组不存在"),
    USER_GROUP_EXIST("AM00102", "用户分组名称已存在"),
    ALERT_RULE_NOT_EXIST("AM00201", "告警规则不存在"),
    SHIELD_RULE_NOT_EXIST("AM00301", "屏蔽规则不存在"),
    MENU_READ_ERROR("AM10101", "菜单读取发生错误"),
    USER_OLD_PWD_ERROR("AM10102", "旧密码错误"),
    USER_LOGIN_ERROR("AM10103", "用户名或密码错误"),
    USER_EXIST("AM10104", "用户已存在"),
    USER_NOT_EXIST("AM10105", "用户不存在"),
    USER_NOT_DELETE("AM10106", "管理员用户不能删除"),

    /**
     * 客户端相关
     **/
    CLIENT_ID_EXIST("PBAUTH1001", "客户端已存在"),
    CLIENT_ID_ERROR("PBAUTH1002", "客户端名称不符合规范"),
    CLIENT_ID_IS_EMPTY("PBAUTH1003", "x-client-id请求头为空"),
    SIGNATURE_IS_EMPTY("PBAUTH1004", "Authorization请求头为空"),
    TIMESTAMP_CHECK_FAILED("PBAUTH1005", "timestamp(时间戳)校验未通过"),
    CLIENT_NOT_REGISTER("PBAUTH1006", "x-client-id(客户端id)未注册"),
    SIGNATURE_CERTIFICATION_FAILED("PBAUTH1007", "签名认证未通过"),
    IP_CERTIFICATION_FAILED("PBAUTH1008", "ip认证未通过"),

    CLIENT_AUTHENTICATION_FAILED("PBAUTH1009","客户端认证失败"),
    UNSUPPORTED_GRANT_TYPE("PBAUTH1010", "不支持的认证模式"),
    USERNAME_OR_PASSWORD_ERROR("PBAUTH1011","用户名或密码错误"),

    /**
     * 用户/用户组相关
     */
    STAFF_NOT_EXIST("PBAUTH2002", "员工不存在"),
    PARENT_NOT_EXIST("PBAUTH2003", "员工上级不存在"),
    OUT_USER_EXIST("PBAUTH2005", "该用户名称已存在"),
    OUT_USER_ERROR("PBAUTH2006", "该用户名称不合法"),
    OUT_ORG_EXIST("PBAUTH2007", "该组织名称已存在"),
    OUT_ORG_ERROR("PBAUTH2008", "该用户组织名称不合法"),
    OUT_USER_TEL_EXIST("PBAUTH2009", "该手机号已注册"),
    OUT_USER_MAIL_EXIST("PBAUTH2010", "该邮箱已注册"),
    USER_PWD_DIFF_ERROR("PBAUTH2010", "两次输入密码不一致"),

    /**
     * 应用相关
     */
    APP_EXIST("PBAUTH3001", "应用已存在"),
    APP_NOT_EXIST("PBAUTH3002", "应用不存在"),

    /**
     * 管理员相关
     */
    ADMIN_EXIST("PBAUTH3001", "管理员已存在"),
    ADMIN_NOT_EXIST("PBAUTH3002", "管理员不存在"),

    /**
     * 角色相关
     */
    ROLE_EXIST("PBAUTH3001", "角色已存在"),
    ROLE_NOT_EXIST("PBAUTH3002", "角色不存在"),
    ROLE_PERM_EXIST("PBAUTH3003", "角色权限已存在"),
    ROLE_PERM_ERROR("PBAUTH3004", "系统角色无法添加/删除权限"),
    ROLE_USER_ERROR("PBAUTH3005", "系统角色无法添加/删除用户"),

    /**
     * 功能操作相关
     */
    OPERATION_NOT_EXIST("IDM4001", "功能操作不存在"),
    OPERATION_EXIST("IDM4002", "功能操作已存在"),
    OPERATION_IMPORT_FILE_ERROR("IDM4003", "功能操作导入文件格式错误"),

    /**
     * 权限责任人相关
     */
    PERM_PRINCIPAL_EXIST("PBAUTH5001", "该权限已配置权限审批信息"),
    PERM_PRINCIPAL_NOT_EXIST("PBAUTH5002", "该权限未配置权限审批信息"),


    /**
     * 权限申请相关
     */
    WORKFLOW_ERROR("PBAUTH6001", "权限申请流程异常"),
    SEND_TODO_FAILED("PBAUTH6002", "权限申请发送待办失败"),
    RECORD_NOT_EXIST("PBAUTH6003", "权限申请记录不存在"),

    /**
     * 菜单相关
     */
    MENU_CODE_EXIT("PBAUTH7001", "菜单编码已被占用"),
    MENU_NAME_EXIT("30010001", "菜单名称已存在，请重新输入！"),
    MENU_NOT_EXIT("30010002", "菜单名称不存在已存在，无法删除！"),

    /**
     * 菜单相关
     */
    API_EXIT("PBAUTH7001", "API已存在"),
    API_NOT_EXIT("30010002", "API不存在已存在，无法删除！"),


    /**
     * 字典相关
     */
    OPTION_NOT_EXIST("AM00101", "字典不存在"),
    OPTION_EXIST("AM10104", "字典已存在"),
    OPTION_DATA_NOT_EXIST("AM00101", "字典不存在"),
    OPTION_DATA_EXIST("AM10104", "字典已存在"),
    /**
     * 其他
     */
    NO_CERTIFICATION("PBAUTH8001", "当前用户未登录"),
    PARAMETER_NULL_ERROR("PBAUTH8002", "不能为空");


    private final String code;//返回码
    private final String message;//返回消息
}
