package com.leansofx.qaserviceuser.service;

import com.leansofx.qaserviceuser.dto.resp.DoctorResp;

import java.util.List;

public interface DoctorService {

    List<DoctorResp> getAllDoctors();
    DoctorResp getDoctor(String username);
}
