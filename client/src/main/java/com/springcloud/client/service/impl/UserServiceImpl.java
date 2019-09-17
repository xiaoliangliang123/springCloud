package com.springcloud.client.service.impl;

import com.base.base.config.db.BaseDao;
import com.base.base.model.SignatureUser;
import com.base.base.util.DataUtil;
import com.base.base.util.GenerateUtil;
import com.base.base.util.StringUtil;
import com.springcloud.client.service.UserService;
import model.JsonResult;
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
        List<Map<String,String>> mapList = getjBaseDao().queryForList(sql);
        Map result = new HashMap(1);
        if(StringUtil.isEmpty(mapList)){
             return new JsonResult(true,"该用户不存在");
        }else {
            Map<String,String> map = mapList.get(0);
            String id = ((Object)map.get("id")).toString();
            String signature =DataUtil.createJWT(30000,new SignatureUser(id,username));
            result.put("signature",signature);
        }

        return new JsonResult(true,"登录成功",result);
    }
}
