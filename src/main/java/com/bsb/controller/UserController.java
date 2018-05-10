package com.bsb.controller;


import com.bsb.common.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/test.do", method = RequestMethod.GET)
    public ServerResponse<String> testController() {
        return ServerResponse.createBySuccess();
    }
}
