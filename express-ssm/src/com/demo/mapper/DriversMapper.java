package com.demo.mapper;
import com.demo.entity.Drivers;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;
/**
* @Author
*/
public interface DriversMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Drivers drivers);
    int insertSelective(Drivers drivers);
    Drivers selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Drivers drivers);
    int updateByPrimaryKey(Drivers drivers);
    List<Drivers> query(Drivers drivers);
    Drivers login(@Param("loginname") String loginname, @Param("password") String password);
    List<Map<String, Double>> statistics(@Param("derversId") Integer derverId, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
