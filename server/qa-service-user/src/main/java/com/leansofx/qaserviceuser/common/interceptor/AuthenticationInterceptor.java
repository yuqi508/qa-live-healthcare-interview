package com.leansofx.qaserviceuser.common.interceptor;

import cn.hutool.core.util.StrUtil;
import com.leansofx.qaserviceuser.common.NoAuthenException;
import com.leansofx.qaserviceuser.common.base.ResultCode;
import com.leansofx.qaserviceuser.common.holder.JwtSecurityHolder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    private JwtDecoder jwtDecoder;

    public AuthenticationInterceptor(JwtDecoder jwtDecoder) {
        this.jwtDecoder = jwtDecoder;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("");
        // 从 http 请求头中取出 token
        String token = request.getHeader("Authorization");
        // 执行认证
        if (token == null) {
            throw new NoAuthenException(ResultCode.UNAUTHORIZED);
        }

        Jwt jwt = null;
        try {
            jwt = jwtDecoder.decode(token);
        } catch (JwtException ex) {
            throw new NoAuthenException(ResultCode.UNAUTHORIZED);
        }
        JwtSecurityHolder.setSecurity(
                StrUtil.toString(jwt.getClaims().get("userId")),
                StrUtil.toString(jwt.getClaims().get("username")));

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
