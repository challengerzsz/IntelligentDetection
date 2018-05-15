package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.User;

public interface IUserService {
    ServerResponse<User> login(String phone, String password);

    ServerResponse<String> register(String authorizationCode, String realName, String phone, String password);
}
