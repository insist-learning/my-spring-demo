package com.example.testdemo.job;

import com.example.testdemo.entity.User;
import com.example.testdemo.mapper.UserMapper;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class SampleXxlJob {

    @Autowired
    private UserMapper userMapper;

    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("demoJobHandler")
    @Transactional
    public void demoJobHandler() throws Exception {
        int i = userMapper.updateState(1);
        throw new RuntimeException("测试异常");
    }
}
