package com.demo.service.impl;
import com.demo.entity.Cars;
import com.demo.mapper.CarsMapper;
import com.demo.service.CarsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/**
* @Author
*/
@Service
public class CarsServiceImpl implements CarsService {
    @Resource
    private CarsMapper carsMapper;
    public boolean deleteByPrimaryKey(Integer id) {
        return carsMapper.deleteByPrimaryKey(id) == 1;
    }
    public boolean insert(Cars cars) {
        return carsMapper.insert(cars) == 1;
    }
    public boolean insertSelective(Cars cars) {
        return carsMapper.insertSelective(cars) == 1;
    }
    public Cars selectByPrimaryKey(Integer id) {
        return carsMapper.selectByPrimaryKey(id);
    }
    public boolean updateByPrimaryKeySelective(Cars cars) {
        return carsMapper.updateByPrimaryKeySelective(cars) == 1;
    }
    public boolean updateByPrimaryKey(Cars cars) {
        return carsMapper.updateByPrimaryKey(cars) == 1;
    }
    public List<Cars> queryPage(Cars cars) {
        return carsMapper.query(cars);
    }
    public List<Cars> list(Cars cars) {
        return carsMapper.query(cars);
    }
    public List<Cars> queryBad() {
        return carsMapper.queryBad();
    }
    public List<Cars> queryUnuse() {
        return carsMapper.queryUnuse();
    }
}
