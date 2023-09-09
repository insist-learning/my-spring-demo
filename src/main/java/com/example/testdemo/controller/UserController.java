package com.example.testdemo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.testdemo.entity.User;
import com.example.testdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/list")

    public   @ResponseBody List<User> getList(String name) {
        System.out.println("name:"+name);
        List<User> userList = userMapper.selectList(new LambdaQueryWrapper<User>().last("limit 10"));
        System.out.println(userList);
        return userList;
    }

    record UserBody(String name, Integer age) {

    }

    @PostMapping("/getBody")
    public UserBody getBody(@RequestBody UserBody userBody) {
        System.out.println(userBody.name());
        System.out.println(userBody.age());
        return userBody;
    }


    @GetMapping("/testupdate")
    public void testupdate() {
        User user = new User();
        user.setId(1L);
        user.setName("test");
        user.setVersion(0);
        userMapper.updateById(user);
    }

    @GetMapping("/testupdat2e2")
    @Transactional
    public void testupdate2() throws Exception{
        User user = new User();
        user.setId(1L);
        user.setName("test2");
        userMapper.updateById(user);
        TimeUnit.SECONDS.sleep(20);

    }

    @GetMapping("/getPort/{id}/{name}")
    @Transactional
    public Map getPort(@PathVariable Map map,@Value("${server.port}")Integer port) throws Exception{
        System.out.println(port);
        return map;

    }

}
