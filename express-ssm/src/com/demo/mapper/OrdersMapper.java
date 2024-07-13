package com.demo.mapper;
import com.demo.entity.Orders;
import java.util.List;
/**
* @Author
*/
public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Orders orders);
    int insertSelective(Orders orders);
    Orders selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Orders orders);
    int updateByPrimaryKey(Orders orders);
    List<Orders> query(Orders orders);
}
