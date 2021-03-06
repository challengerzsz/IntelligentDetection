package com.bsb.controller;


import com.bsb.common.Const;
import com.bsb.common.ServerResponse;
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
//        方便测试设置session永不过期
        session.setMaxInactiveInterval(0);

        ServerResponse<User> response = userService.login(phone, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    public ServerResponse<String> register(String authorizationCode, String realName, String phone, String password) {
        ServerResponse<String> response = userService.register(authorizationCode, realName, phone, password);
        if (!response.isSuccess()) {
            return ServerResponse.createByErrorMsg("注册失败");
        }

        return response;
    }

    @RequestMapping(value = "logout.do", method = RequestMethod.POST)
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @RequestMapping(value = "get_user_info.do", method = RequestMethod.POST)
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMsg("用户未登录，无法获取信息");
    }

}
