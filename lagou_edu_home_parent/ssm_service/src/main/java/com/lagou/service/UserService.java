package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;

import java.util.List;

public interface UserService {

    PageInfo findAllUserByPage(UserVO userVO);

    User login(User user) throws Exception;

    List<Role> findUserRelationRoleById(Integer id);

    void userContextRole(UserVO userVO);

    ResponseResult getUserPermissions(Integer userId);
}
