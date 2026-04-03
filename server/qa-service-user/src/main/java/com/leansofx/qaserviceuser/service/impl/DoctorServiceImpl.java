package com.leansofx.qaserviceuser.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leansofx.qaserviceuser.dto.resp.DoctorResp;
import com.leansofx.qaserviceuser.entity.DoctorEntity;
import com.leansofx.qaserviceuser.mapper.DoctorMapper;
import com.leansofx.qaserviceuser.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }

    /**
     * 获取医生列表
     * @return
     */
    @Override
    public List<DoctorResp> getAllDoctors() {

        QueryWrapper<DoctorEntity> queryWrapper = new QueryWrapper<>();
        List<DoctorEntity> result =  doctorMapper.selectList(queryWrapper);

        return BeanUtil.copyToList(result, DoctorResp.class);
    }

    @Override
    public DoctorResp getDoctor(String username) {
        QueryWrapper<DoctorEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        DoctorEntity entity = doctorMapper.selectOne(queryWrapper);
        return BeanUtil.copyProperties(entity, DoctorResp.class);
    }
}
