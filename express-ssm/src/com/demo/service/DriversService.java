package com.demo.service;
import com.demo.entity.Drivers;
import com.demo.utils.Statistics;
import java.util.List;
/**
* @Author
*/
public interface DriversService {
    boolean deleteByPrimaryKey(Integer id);
    boolean insert(Drivers drivers);
    boolean insertSelective(Drivers drivers);
    Drivers selectByPrimaryKey(Integer id);
    boolean updateByPrimaryKeySelective(Drivers drivers);
    boolean updateByPrimaryKey(Drivers drivers);
    List<Drivers> queryPage(Drivers drivers);
    List<Drivers> list(Drivers drivers);
    Drivers login(String loginname, String password);
    Statistics statistics(Integer driverId, String startDate, String endDate);
}
