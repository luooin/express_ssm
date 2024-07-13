package com.demo.service.impl;
import com.demo.entity.Admin;
import com.demo.mapper.AdminMapper;
import com.demo.service.AdminService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/**
* @Author
*/
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    public boolean deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id) == 1;
    }
    public boolean insert(Admin admin) {
        return adminMapper.insert(admin) == 1;
    }
    public boolean insertSelective(Admin admin) {
        return adminMapper.insertSelective(admin) == 1;
    }
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }
    public boolean updateByPrimaryKeySelective(Admin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin) == 1;
    }
    public boolean updateByPrimaryKey(Admin admin) {
        return adminMapper.updateByPrimaryKey(admin) == 1;
    }
    public List<Admin> queryPage(Admin admin) {
        return adminMapper.query(admin);
    }
    public List<Admin> list(Admin admin) {
        return adminMapper.query(admin);
    }
    @Override
    public Admin login(String loginname, String password){
        return adminMapper.login(loginname, password);
    }
}
