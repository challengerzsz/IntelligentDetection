package com.bsb.controller;


import com.bsb.common.Const;
import com.bsb.common.ServerResponse;
import com.bsb.pojo.Data;
import com.bsb.pojo.User;
import com.bsb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public ServerResponse<User> login(String phone, String password, HttpSession session) {
        ServerResponse<User> response = userService.login(phone, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

}
