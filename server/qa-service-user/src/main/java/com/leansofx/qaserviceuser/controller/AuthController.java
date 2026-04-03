package com.leansofx.qaserviceuser.controller;

import com.leansofx.qaserviceuser.common.response.ResponseResult;
import com.leansofx.qaserviceuser.dto.req.LoginReq;
import com.leansofx.qaserviceuser.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/doctor/login")
    public ResponseResult<String> loginForDoctor(@RequestBody LoginReq loginReq) {

        String token = authService.loginForDoctor(loginReq);
        return ResponseResult.success(token);
    }

    @PostMapping("/patient/login")
    public ResponseResult<String> loginForPatient(@RequestBody LoginReq loginReq) {

        String token = authService.loginForPatient(loginReq);
        return ResponseResult.success(token);
    }

}
