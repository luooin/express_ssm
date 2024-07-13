package com.demo.users;
import com.demo.entity.Users;

import java.util.List;
/**
* @Author
*/
public interface UsersService {
    boolean deleteByPrimaryKey(Integer id);
    boolean insert(Users users);
    boolean insertSelective(Users users);
    Users selectByPrimaryKey(Integer id);
    boolean updateByPrimaryKeySelective(Users users);
    boolean updateByPrimaryKey(Users users);
    List<Users> queryPage(Users users);
    List<Users> list(Users users);
    Users login(String loginname, String password);
}
