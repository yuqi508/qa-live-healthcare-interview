package com.leansofx.qaserviceuser.service;

import com.leansofx.qaserviceuser.dto.resp.PatientResp;

public interface PatientService {

    PatientResp getPatient(String username);
}
