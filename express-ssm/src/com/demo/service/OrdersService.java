package com.demo.service;
import com.demo.entity.Orders;
import com.github.pagehelper.Page;
import java.util.List;
/**
* @Author
*/
public interface OrdersService {
    boolean deleteByPrimaryKey(Integer id);
    boolean insert(Orders orders);
    boolean insertSelective(Orders orders);
    Orders selectByPrimaryKey(Integer id);
    boolean updateByPrimaryKeySelective(Orders orders);
    boolean updateByPrimaryKey(Orders orders);
    Page<Orders> queryPage(Orders orders);
    List<Orders> list(Orders orders);
}
