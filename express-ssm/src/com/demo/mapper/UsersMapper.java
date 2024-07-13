package com.demo.mapper;
import com.demo.entity.Users;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
* @Author
*/
public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Users users);
    int insertSelective(Users users);
    Users selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Users users);
    int updateByPrimaryKey(Users users);
    List<Users> query(Users users);
    Users login(@Param("loginname") String loginname, @Param("password") String password);
}
