package com.leansofx.qaserviceuser.service;

import com.leansofx.qaserviceuser.dto.req.LoginReq;

public interface AuthService {

    String loginForDoctor(LoginReq loginReq);

    String loginForPatient(LoginReq loginReq);
}
