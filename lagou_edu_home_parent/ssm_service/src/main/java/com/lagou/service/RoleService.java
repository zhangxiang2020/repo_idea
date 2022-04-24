package com.lagou.service;

import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVO;

import java.util.List;

public interface RoleService {

    List<Role> findAllRole(Role role);

    List<Integer> findMenuByRoleId(Integer roleId);

    void RoleMenuContext(RoleMenuVO roleMenuVO);

    void deleteRole(Integer roleId);
}
