package com.demo.mapper;
import com.demo.entity.Cars;
import java.util.List;
/**
* @Author
*/
public interface CarsMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Cars cars);
    int insertSelective(Cars cars);
    Cars selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Cars cars);
    int updateByPrimaryKey(Cars cars);
    List<Cars> query(Cars cars);
    List<Cars> queryBad();
    List<Cars> queryUnuse();
}
