package com.lagou.service;

import com.lagou.domain.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> findSubMenuListByPid(int pid);

    List<Menu> findAllMenu();

    Menu findMenuById(Integer id);
}
