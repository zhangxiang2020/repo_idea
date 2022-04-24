package com.lagou.dao;

import com.lagou.domain.Menu;
import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {

    List<Role> findAllRole(Role role);

    List<Integer> findMenuByRoleId(Integer roleId);

    void deleteRoleContextMenu(Integer roleId);

    void roleContextMenu(Role_menu_relation role_menu_relation);

    void deleteRole(Integer roleId);
}
