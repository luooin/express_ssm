package com.demo.service.impl;
import com.demo.entity.Orders;
import com.demo.service.OrdersService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.demo.mapper.OrdersMapper;
import com.demo.mapper.UsersMapper;
import com.demo.entity.Users;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
/**
 * @Author
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private UsersMapper usersMapper;
    public boolean deleteByPrimaryKey(Integer id) {
        return ordersMapper.deleteByPrimaryKey(id) == 1;
    }
    public boolean insert(Orders orders) {
        orders.setOrderTime(new Date());
        orders.setOrderNum(System.currentTimeMillis() + "");
        Users users = usersMapper.selectByPrimaryKey(orders.getUserId());
        if (null != users) {
            orders.setUserName(users.getUsername());
        }
        return ordersMapper.insert(orders) == 1;
    }
    public boolean insertSelective(Orders orders) {
        orders.setOrderTime(new Date());
        orders.setOrderNum(System.currentTimeMillis() + "");
        Users users = usersMapper.selectByPrimaryKey(orders.getUserId());
        if (null != users) {
            orders.setUserName(users.getUsername());
        }
        return ordersMapper.insertSelective(orders) == 1;
    }
    public Orders selectByPrimaryKey(Integer id) {
        return ordersMapper.selectByPrimaryKey(id);
    }
    public boolean updateByPrimaryKeySelective(Orders orders) {
        Users users = usersMapper.selectByPrimaryKey(orders.getUserId());
        if (null != users) {
            orders.setUserName(users.getUsername());
        }
        return ordersMapper.updateByPrimaryKeySelective(orders) == 1;
    }
    public boolean updateByPrimaryKey(Orders orders) {
        Users users = usersMapper.selectByPrimaryKey(orders.getUserId());
        if (null != users) {
            orders.setUserName(users.getUsername());
        }
        return ordersMapper.updateByPrimaryKey(orders) == 1;
    }
    public Page<Orders> queryPage(Orders orders) {
        Page<Orders> pageList = PageHelper.startPage(orders.getPageNum(), orders.getPageSize());
        ordersMapper.query(orders);
        return pageList;
    }
    public List<Orders> list(Orders orders) {
        return ordersMapper.query(orders);
    }
}
