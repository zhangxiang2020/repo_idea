package com.lagou.dao;

import com.lagou.domain.Menu;

import java.util.List;

public interface MenuMapper {

    List<Menu> findSubMenuListByPid(int pid);

    List<Menu> findAllMenu();

    Menu findMenuById(Integer id);
}
