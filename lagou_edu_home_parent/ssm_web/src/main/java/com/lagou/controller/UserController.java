package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVO userVO) {

        PageInfo pageInfo = userService.findAllUserByPage(userVO);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", pageInfo);
        return responseResult;
    }

    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {

        User login = userService.login(user);
        if (login != null) {

            String access_token = UUID.randomUUID().toString();

            Map<String, Object> map = new HashMap<>();
            map.put("access_token", access_token);
            map.put("user_id", login.getId());

            map.put("user", login);

            System.out.println(login.getId());

            HttpSession session = request.getSession();
            session.setAttribute("access_token", access_token);
            session.setAttribute("user_id", login.getId());

            return new ResponseResult(true, 1, "登录成功", map);
        } else {
            return new ResponseResult(true, 1, "用户名密码错误", null);
        }
    }

    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRoleById(Integer id) {

        List<Role> roleList = userService.findUserRelationRoleById(id);

        return new ResponseResult(true, 200, "分配角色成功", roleList);
    }

    @RequestMapping("/userContextRole")
    public ResponseResult userCotextRole(@RequestBody UserVO userVO) {

        userService.userContextRole(userVO);

        return new ResponseResult(true, 200, "分配角色成功", null);
    }

    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request) {

        String header_token = request.getHeader("Authorization");

        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");

        if (header_token.equals(access_token)) {
            Integer user_id = (Integer) session.getAttribute("user_id");
            ResponseResult responseResult = userService.getUserPermissions(user_id);
            return responseResult;
        } else {
            ResponseResult responseResult = new ResponseResult(false, 400, "获取失败", null);
            return responseResult;
        }
    }
}
