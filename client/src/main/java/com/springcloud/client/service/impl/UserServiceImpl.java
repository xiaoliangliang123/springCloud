package com.springcloud.client.service.impl;

import com.base.base.config.db.BaseDao;
import com.base.base.config.db.JBaseDao;
import com.base.base.util.GenerateUtil;
import com.base.base.util.StringUtil;
import com.springcloud.client.service.UserService;
import model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:WANGLIANG(XIAO)
 * @Date: 2019/9/16 11:45
 * @Description : 用户service实现类
 */
@Service
public class UserServiceImpl extends BaseDao implements UserService {



    public JsonResult login(String username, String password) throws NoSuchAlgorithmException {

        password = GenerateUtil.toMd5(password);
        String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
        List<Map> mapList = getjBaseDao().queryForList(sql);
        Map result = new HashMap(1);
        if(StringUtil.isEmpty(mapList)){
             return new JsonResult(true,"该用户不存在");
        }
        result.put("key","");
        return new JsonResult(result);
    }
}
