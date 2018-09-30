package com.wang.controller;

import com.alibaba.fastjson.JSONArray;
import com.wang.model.User;
import com.wang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desc
 * @Author wang926454
 * @Date 2018/5/30 17:46
 */
@Controller
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @ResponseBody
    @RequestMapping("/getUsers")
    public Map getUsers(int page, int limit){
        // 第page页开始，limit条数据
        int start = (page-1) * limit + 1;
        int size = page * limit;
        Map map = new HashMap(16);
        map.put("code", "0");
        map.put("count", userService.allCount());
        // all(start, size)查询的是从第start到size条数据
        map.put("data", userService.all(start, size));
        return map;
    }

    @ResponseBody
    @RequestMapping("/addOrUpdate")
    public void addUser(User user){
        if(user.getId() == null){
            user.setRegtime(new Date());
            userService.insertTemplate(user);
        }else{
            int count = userService.updateTemplateById(user);
        }
    }

    @ResponseBody
    @RequestMapping("/delete")
    public void delete(String jsons){
        List<User> users = JSONArray.parseArray(jsons, User.class);
        for (int i = 0; i < users.size(); i++) {
            userService.deleteById(users.get(i).getId());
        }
    }

    @ResponseBody
    @RequestMapping("/findById")
    public Map findById(String jsons){
        List<User> users = JSONArray.parseArray(jsons, User.class);
        User user = userService.single(users.get(0).getId());
        Map map = new HashMap(16);
        map.put("obj", user);
        return map;
    }
}
