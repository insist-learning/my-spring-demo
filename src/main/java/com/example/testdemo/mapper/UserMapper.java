package com.example.testdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.testdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    int updateState(@Param("userId") Integer userId);
    int updateName(@Param("userId") Integer userId);
}
