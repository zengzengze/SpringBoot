package com.zfj.springBoot.service.impl;

import com.zfj.springBoot.mapper.UserMapper;
import com.zfj.springBoot.pojo.Users;
import com.zfj.springBoot.service.ifc.IUserService;
import com.zfj.springBoot.vo.ResCode;
import com.zfj.springBoot.vo.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseModel test() throws Exception {
        List<Users> users = userMapper.queryAllMsg();
        return ResponseModel.success(ResCode.SUCCESS,users);
    }
    @Override
    public ResponseModel insertMsg(Users users) throws Exception {
        int row = userMapper.insertMsg(users);

        if (row==0){
            System.out.println("请求错误！"+row);
            return ResponseModel.fail(ResCode.FAIL);
        }
        System.out.println(row);
        return ResponseModel.success(ResCode.SUCCESS);
    }

    @Override
    public ResponseModel updateMsg(Users users) throws Exception {

        System.out.println(users);
        int row= userMapper.updateMsg(users);
        if (row==0){
            return ResponseModel.fail(ResCode.FAIL);
        }
        return ResponseModel.success(ResCode.SUCCESS);
    }

    @Override
    public ResponseModel deleteUser(Integer[] ids) throws Exception {
        int row=userMapper.deleteMsg(ids);

        System.out.println(ids);
        if(row==ids.length){
            return ResponseModel.success(ResCode.SUCCESS);
        }else{
            throw  new Exception("操作失败");
        }
    }

}
