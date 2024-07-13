package com.demo.service.impl;
import com.demo.entity.Drivers;
import com.demo.mapper.DriversMapper;
import com.demo.service.DriversService;
import com.demo.utils.Statistics;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
 * @Author
 */
@Service
public class DriversServiceImpl implements DriversService {
    @Resource
    private DriversMapper driversMapper;
    public boolean deleteByPrimaryKey(Integer id) {
        return driversMapper.deleteByPrimaryKey(id) == 1;
    }
    public boolean insert(Drivers drivers) {
        return driversMapper.insert(drivers) == 1;
    }
    public boolean insertSelective(Drivers drivers) {
        return driversMapper.insertSelective(drivers) == 1;
    }
    public Drivers selectByPrimaryKey(Integer id) {
        return driversMapper.selectByPrimaryKey(id);
    }
    public boolean updateByPrimaryKeySelective(Drivers drivers) {
        return driversMapper.updateByPrimaryKeySelective(drivers) == 1;
    }
    public boolean updateByPrimaryKey(Drivers drivers) {
        return driversMapper.updateByPrimaryKey(drivers) == 1;
    }
    public List<Drivers> queryPage(Drivers drivers) {
        return driversMapper.query(drivers);
    }
    public List<Drivers> list(Drivers drivers) {
        return driversMapper.query(drivers);
    }
    @Override
    public Drivers login(String loginname, String password) {
        return driversMapper.login(loginname, password);
    }
    @Override
    public Statistics statistics(Integer driverId, String startDate, String endDate) {
        List<Map<String, Double>> mapList = driversMapper.statistics(driverId, startDate, endDate);
        if (null == mapList || mapList.size() == 0) {
            return new Statistics();
        }
        Statistics statistics = new Statistics();
        if (null != mapList && mapList.size() > 0) {
            String[] x = new String[mapList.size()];
            String[] y = new String[mapList.size()];
            Double total = 0.0;
            for (int i = 0; i < mapList.size(); i++) {
                Map<String, Double> map = mapList.get(i);
                x[i] = map.get("xx") + "";
                y[i] = map.get("yy") + "";
                total = total + Double.valueOf(map.get("yy") + "");
            }
            statistics.setYy(y);
            statistics.setXx(x);
            statistics.setTotal(total + "");
        }
        return statistics;
    }
}
