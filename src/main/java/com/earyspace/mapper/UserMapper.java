package com.earyspace.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.earyspace.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserInfo> {

}
