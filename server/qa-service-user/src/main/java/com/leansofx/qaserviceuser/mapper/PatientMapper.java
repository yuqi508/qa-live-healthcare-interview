package com.leansofx.qaserviceuser.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leansofx.qaserviceuser.entity.PatientEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 患者 Mapper接口
 *
 * @author maolu
 */
@Mapper
public interface PatientMapper extends BaseMapper<PatientEntity> {

}
