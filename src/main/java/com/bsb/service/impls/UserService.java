package com.bsb.service.impls;

import com.bsb.common.Const;
import com.bsb.common.ServerResponse;
import com.bsb.dao.UserMapper;
import com.bsb.pojo.Data;
import com.bsb.pojo.User;
import com.bsb.service.IUserService;
import com.bsb.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String phone, String password) {
        int resultCount = userMapper.checkPhone(phone);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("用户不存在");
        }

        String MD5EncodingPassword = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.login(phone, MD5EncodingPassword);
        if (user == null) {
            return ServerResponse.createByErrorMsg("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登陆成功", user);
    }

    @Override
    public ServerResponse<String> register(String authorizationCode, String realName, String phone, String password) {

        int resultCode = userMapper.checkPhone(phone);
        if (resultCode != 0) {
            return ServerResponse.createByErrorMsg("用户已存在，注册失败");
        }

        int type = 0;
        if (authorizationCode.equals(Const.ENTERPRISE_AUTHORIZATION_CODE)) {
            type = 1;
        } else if (authorizationCode.equals(Const.GOVERNMENT_AUTHORIZATION_CODE)){
            type = 2;
        }

        if (type == 0) {
            return ServerResponse.createByErrorMsg("授权码认证失败");
        }

        int insertResult = userMapper.insertUser(realName, phone, password, type);

        if (insertResult == 0) {
            return ServerResponse.createByErrorMsg("注册失败");
        }

        return ServerResponse.createBySuccessMsg("注册成功");

    }

}
