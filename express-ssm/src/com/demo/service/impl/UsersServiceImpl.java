package com.demo.service.impl;
import com.demo.entity.Users;
import com.demo.mapper.UsersMapper;
import com.demo.users.UsersService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/**
* @Author
*/
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersMapper usersMapper;
    public boolean deleteByPrimaryKey(Integer id) {
        return usersMapper.deleteByPrimaryKey(id) == 1;
    }
    public boolean insert(Users users) {
        return usersMapper.insert(users) == 1;
    }
    public boolean insertSelective(Users users) {
        return usersMapper.insertSelective(users) == 1;
    }
    public Users selectByPrimaryKey(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }
    public boolean updateByPrimaryKeySelective(Users users) {
        return usersMapper.updateByPrimaryKeySelective(users) == 1;
    }
    public boolean updateByPrimaryKey(Users users) {
        return usersMapper.updateByPrimaryKey(users) == 1;
    }
    public List<Users> queryPage(Users users) {
        return usersMapper.query(users);
    }
    public List<Users> list(Users users) {
        return usersMapper.query(users);
    }
    @Override
    public Users login(String loginname, String password){
        return usersMapper.login(loginname, password);
    }
}
