package com.leansofx.qaserviceuser.controller;

import com.leansofx.qaserviceuser.common.response.ResponseResult;
import com.leansofx.qaserviceuser.dto.resp.PatientResp;
import com.leansofx.qaserviceuser.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{username}")
    public ResponseResult<PatientResp> getPatient(@PathVariable("username") String username) {
        PatientResp patientResp = patientService.getPatient(username);
        return ResponseResult.success(patientResp);
    }
}
