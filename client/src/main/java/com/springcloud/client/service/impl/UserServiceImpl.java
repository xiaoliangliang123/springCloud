package com.springcloud.client.service.impl;

import com.base.base.config.db.JBaseDao;
import com.springcloud.client.service.UserService;
import model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2019/9/16 11:45
 * @Description : 用户service实现类
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private JBaseDao jBaseDao;

    public JsonResult login(String username, String password) {
        return null;
    }
}
