package com.zfj.springBoot.service.ifc;

import com.zfj.springBoot.pojo.Users;
import com.zfj.springBoot.vo.ResponseModel;


public interface IUserService {

    public ResponseModel test() throws Exception;

    ResponseModel insertMsg(Users users) throws  Exception;

    ResponseModel updateMsg(Users users) throws  Exception;

    ResponseModel deleteUser(Integer[] ids) throws Exception;

}
