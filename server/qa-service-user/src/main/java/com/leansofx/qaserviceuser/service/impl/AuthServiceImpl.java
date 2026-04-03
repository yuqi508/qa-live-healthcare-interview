package com.leansofx.qaserviceuser.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leansofx.qaserviceuser.dto.req.LoginReq;
import com.leansofx.qaserviceuser.entity.DoctorEntity;
import com.leansofx.qaserviceuser.entity.PatientEntity;
import com.leansofx.qaserviceuser.error.ErrorCode;
import com.leansofx.qaserviceuser.common.BusinessException;
import com.leansofx.qaserviceuser.mapper.DoctorMapper;
import com.leansofx.qaserviceuser.mapper.PatientMapper;
import com.leansofx.qaserviceuser.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

    private DoctorMapper doctorMapper;
    private PatientMapper patientMapper;
    private JwtEncoder jwtEncoder;

    public AuthServiceImpl(DoctorMapper doctorMapper,
                           PatientMapper patientMapper,
                           JwtEncoder jwtEncoder) {
        this.doctorMapper = doctorMapper;
        this.patientMapper = patientMapper;
        this.jwtEncoder = jwtEncoder;
    }

    @Override
    public String loginForDoctor(LoginReq loginReq) {

        QueryWrapper<DoctorEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", loginReq.getUsername());
        DoctorEntity admin = doctorMapper.selectOne(queryWrapper);
        if (admin == null) {
            throw new BusinessException(ErrorCode.USER_LOGIN_ERROR);
        }

        String md5Pwd = SecureUtil.md5(loginReq.getPassword());

        if (!admin.getPassword().equals(md5Pwd)) {
            throw new BusinessException(ErrorCode.USER_LOGIN_ERROR);
        }
        Instant now = Instant.now();
        //JWT过期时间为36000秒，也就是600分钟，10小时
        long expiry = 36000L;
        //将用户权限信息使用空格分割拼为字符串，放到JWT的payload的scope字段中，注意不要改变scope这个属性，这是Spring Security OAuth2 JWT默认处理方式，在JWT解码时需要读取该字段，转为用户的权限信息！
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(admin.getUsername())
                .claim("userId", admin.getId())
                .claim("username", admin.getUsername())
                .build();
        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    @Override
    public String loginForPatient(LoginReq loginReq) {

        QueryWrapper<PatientEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", loginReq.getUsername());
        PatientEntity admin = patientMapper.selectOne(queryWrapper);
        if (admin == null) {
            throw new BusinessException(ErrorCode.USER_LOGIN_ERROR);
        }

        String md5Pwd = SecureUtil.md5(loginReq.getPassword());

        if (!admin.getPassword().equals(md5Pwd)) {
            throw new BusinessException(ErrorCode.USER_LOGIN_ERROR);
        }
        Instant now = Instant.now();
        //JWT过期时间为36000秒，也就是600分钟，10小时
        long expiry = 36000L;
        //将用户权限信息使用空格分割拼为字符串，放到JWT的payload的scope字段中，注意不要改变scope这个属性，这是Spring Security OAuth2 JWT默认处理方式，在JWT解码时需要读取该字段，转为用户的权限信息！
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(admin.getUsername())
                .claim("userId", admin.getId())
                .claim("username", admin.getUsername())
                .build();
        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
