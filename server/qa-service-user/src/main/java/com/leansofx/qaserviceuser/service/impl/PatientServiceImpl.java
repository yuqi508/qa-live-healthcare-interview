package com.leansofx.qaserviceuser.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leansofx.qaserviceuser.dto.resp.DoctorResp;
import com.leansofx.qaserviceuser.dto.resp.PatientResp;
import com.leansofx.qaserviceuser.entity.PatientEntity;
import com.leansofx.qaserviceuser.mapper.PatientMapper;
import com.leansofx.qaserviceuser.service.PatientService;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientMapper patientMapper;

    public PatientServiceImpl(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    @Override
    public PatientResp getPatient(String username) {
        QueryWrapper<PatientEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        PatientEntity entity = patientMapper.selectOne(queryWrapper);
        return BeanUtil.copyProperties(entity, PatientResp.class);
    }
}
