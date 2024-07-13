package com.demo.mapper;
import com.demo.entity.Admin;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
* @Author
*/
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Admin admin);
    int insertSelective(Admin admin);
    Admin selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Admin admin);
    int updateByPrimaryKey(Admin admin);
    List<Admin> query(Admin admin);
    Admin login(@Param("loginname") String loginname, @Param("password") String password);
}
