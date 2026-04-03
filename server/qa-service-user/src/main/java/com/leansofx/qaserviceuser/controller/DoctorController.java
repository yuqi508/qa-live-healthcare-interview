package com.leansofx.qaserviceuser.controller;

import com.leansofx.qaserviceuser.common.response.ResponseResult;
import com.leansofx.qaserviceuser.dto.resp.DoctorResp;
import com.leansofx.qaserviceuser.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    /**
     * 获取医生列表
     * @return
     */
    @GetMapping()
    public ResponseResult<List<DoctorResp>> getDoctors() {

        List<DoctorResp>  doctors = doctorService.getAllDoctors();
        return ResponseResult.success(doctors);
    }

    @GetMapping("/{username}")
    public ResponseResult<DoctorResp> getDoctor(@PathVariable("username") String username) {
        DoctorResp doctorResp = doctorService.getDoctor(username);
        return ResponseResult.success(doctorResp);
    }
}
