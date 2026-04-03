package com.leansofx.qaserviceuser.common.holder;

import cn.hutool.core.convert.Convert;
import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.HashMap;
import java.util.Map;

public class JwtSecurityHolder {

    private static final ThreadLocal<Map<String, Object>>
            SECURITY_HOLDER = new TransmittableThreadLocal();

    public static void setSecurity(String userName, String userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        map.put("userId", userId);
        SECURITY_HOLDER.set(map);
    }

    public static Map<String, Object> setClaims(Map<String, Object> claims) {
        if (claims == null) {
            return setEmptyClaims();
        }
        SECURITY_HOLDER.set(claims);
        return claims;
    }

    private static Map<String, Object> setEmptyClaims() {
        Map<String, Object> claims = new HashMap<>();
        SECURITY_HOLDER.set(claims);
        return claims;
    }

    public static void removeSecurity() {
        SECURITY_HOLDER.remove();
    }

    public static Map<String, Object> getSecurity() {
        return SECURITY_HOLDER.get();
    }

    public static String getUserName() {
        return Convert.toStr(SECURITY_HOLDER.get().get("username"));
    }

    public static String getUserId() {
        return Convert.toStr(SECURITY_HOLDER.get().get("userId"));
    }

}
