package com.springcloud.client.service;

import model.JsonResult;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2019/9/16 11:45
 * @Description :用户service
 */
public interface UserService {

    public JsonResult login(String username,String password);
}
