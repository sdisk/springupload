package com.example.demo;

import com.hq.test.vo.UserVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huang on 2018/3/7.
 */
@RestController
public class HelloWorldController
{
    @RequestMapping("/getUser")
    public UserVo getUser(){
       UserVo vo = new UserVo();
       vo.setUsername("admin");
       vo.setPassword("123456");
       return vo;
    }
}
