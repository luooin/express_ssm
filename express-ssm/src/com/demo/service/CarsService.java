package com.demo.service;
import com.demo.entity.Cars;

import java.util.List;
/**
* @Author
*/
public interface CarsService {
    boolean deleteByPrimaryKey(Integer id);
    boolean insert(Cars cars);
    boolean insertSelective(Cars cars);
    Cars selectByPrimaryKey(Integer id);
    boolean updateByPrimaryKeySelective(Cars cars);
    boolean updateByPrimaryKey(Cars cars);
    List<Cars> queryPage(Cars cars);
    List<Cars> list(Cars cars);
    List<Cars> queryBad();
    List<Cars> queryUnuse();
}
