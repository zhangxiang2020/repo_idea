package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

public interface UserMapper {

    List<User> findAllUserByPage(UserVO userVO);

    User login(User user);

    List<Role> findUserRelationRoleById(Integer id);

    void deleteUserContextRole(Integer userId);

    void userContextRole(User_Role_relation user_role_relation);

    List<Menu> findParentMenuByRoleId(List<Integer> ids);

    List<Menu> findSubMenuByPid(Integer pid);

    List<Resource> findResourceByRoleId(List<Integer> ids);
    
    List<Resource> findResourceByRoleId2(List<Integer> ids);

}
