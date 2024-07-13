package com.demo.service.impl;
import com.demo.entity.Cars;
import com.demo.entity.Repair;
import com.demo.mapper.CarsMapper;
import com.demo.mapper.RepairMapper;
import com.demo.service.RepairService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/**
* @Author
*/
@Service
public class RepairServiceImpl implements RepairService {
    @Resource
    private RepairMapper repairMapper;
    @Resource
    private CarsMapper carsMapper;
    public boolean deleteByPrimaryKey(Integer id) {
        return repairMapper.deleteByPrimaryKey(id) == 1;
    }
    public boolean insert(Repair repair) {
        return repairMapper.insert(repair) == 1;
    }
    public boolean insertSelective(Repair repair) {
        Cars cars = carsMapper.selectByPrimaryKey(repair.getCarId());
        if(cars != null){
            cars.setState(3);
            carsMapper.updateByPrimaryKeySelective(cars);
            repair.setCarNumber(cars.getCarNumber());
        }
        return repairMapper.insertSelective(repair) == 1;
    }
    public Repair selectByPrimaryKey(Integer id) {
        return repairMapper.selectByPrimaryKey(id);
    }
    public boolean updateByPrimaryKeySelective(Repair repair) {
        Cars cars = carsMapper.selectByPrimaryKey(repair.getCarId());
        if(cars != null){
            if(repair.getState().equals(2)){
                cars.setState(0);
                carsMapper.updateByPrimaryKeySelective(cars);
            } else  if(repair.getState().equals(1)){
                cars.setState(4);
                carsMapper.updateByPrimaryKeySelective(cars);
            }
            repair.setCarNumber(cars.getCarNumber());
        }
        return repairMapper.updateByPrimaryKeySelective(repair) == 1;
    }
    public boolean updateByPrimaryKey(Repair repair) {
        return repairMapper.updateByPrimaryKey(repair) == 1;
    }
    public List<Repair> queryPage(Repair repair) {
        return repairMapper.query(repair);
    }
    public List<Repair> list(Repair repair) {
        return repairMapper.query(repair);
    }
}
