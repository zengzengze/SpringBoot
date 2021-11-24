package com.zfj.springBoot.controller;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zengfanjing
 * @Date: 2021/11/23/16:26
 * @Description:
 */
import com.zfj.springBoot.pojo.Users;
import com.zfj.springBoot.service.ifc.IUserService;
import com.zfj.springBoot.vo.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;


    @RequestMapping("/test")
    public ResponseModel test()throws Exception{
        ResponseModel model = userService.test();
        return model;
    }

    @RequestMapping("/insertUser")
    public int insertMsg(@RequestBody Users users)throws Exception {

        return userService.insertMsg(users).getCode();
    }

    @RequestMapping("/updateMsg")
    public ResponseModel updateMsg(@RequestBody Users users)throws Exception  {

        return userService.updateMsg(users);
    }

    @RequestMapping("/deleteUser")
    public ResponseModel deleteUser(@RequestBody Map<String,Integer[]> ids) throws Exception {
        return userService.deleteUser(ids.get("ids"));
    }

}
