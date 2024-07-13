package com.demo.service;
import com.demo.entity.Admin;

import java.util.List;
/**
* @Author
*/
public interface AdminService {
    boolean deleteByPrimaryKey(Integer id);
    boolean insert(Admin admin);
    boolean insertSelective(Admin admin);
    Admin selectByPrimaryKey(Integer id);
    boolean updateByPrimaryKeySelective(Admin admin);
    boolean updateByPrimaryKey(Admin admin);
    List<Admin> queryPage(Admin admin);
    List<Admin> list(Admin admin);
    Admin login(String loginname, String password);
}
