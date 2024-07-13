package com.demo.service.impl;
import com.demo.utils.BagItem;
import com.demo.utils.CarsBag;
import com.demo.entity.Cars;
import com.demo.entity.Invoice;
import com.demo.mapper.CarsMapper;
import com.demo.mapper.InvoiceMapper;
import com.demo.mapper.OrdersMapper;
import com.demo.entity.Orders;
import com.demo.service.InvoiceService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
/**
* @Author
*/
@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Resource
    private InvoiceMapper invoiceMapper;
    @Resource
    private CarsMapper carsMapper;
    @Resource
    private OrdersMapper ordersMapper;
    public boolean deleteByPrimaryKey(Integer id) {
        Invoice invoice = invoiceMapper.selectByPrimaryKey(id);
        if(invoice != null ){
            //更新车辆状态
            Cars cars = carsMapper.selectByPrimaryKey(invoice.getCar());
            if(null != cars){
                cars.setState(0);
                carsMapper.updateByPrimaryKeySelective(cars);
            }
            //更新订单状态
            Orders orders = new Orders();
            orders.setStartSite(invoice.getStartSite());
            orders.setEndSite(invoice.getEndSite());
            List<Orders> ordersList = ordersMapper.query(orders);
            if(ordersList != null && ordersList.size() > 0){
                for(Orders orders1 : ordersList){
                    orders1.setState(2);
                    ordersMapper.updateByPrimaryKeySelective(orders1);
                }
            }
        }
        return invoiceMapper.deleteByPrimaryKey(id) == 1;
    }
    public boolean insert(Invoice invoice) {
        return invoiceMapper.insert(invoice) == 1;
    }
    public boolean insertSelective(Invoice invoice) {
        Cars cars = carsMapper.selectByPrimaryKey(invoice.getCar());
        if(null != cars){
            cars.setState(1);
            carsMapper.updateByPrimaryKeySelective(cars);
        }
        //获取车辆最大容量
        BagItem[] sourceItems = null;
        //更新订单状态
        Orders orders = new Orders();
        orders.setStartSite(invoice.getStartSite());
        orders.setEndSite(invoice.getEndSite());
        orders.setState(0);
        List<Orders> ordersList = ordersMapper.query(orders);
        if(ordersList != null && ordersList.size() > 0){
            //选择订单
            int j = 0;
            for(int i = 0; i < ordersList.size(); i++){
                Orders orders1 = ordersList.get(i);
                if(orders1.getOrderTime().getHours() <= 16){//TODO 16
                    if(null == sourceItems){
                        sourceItems = new BagItem[ordersList.size()];
                    }
                    sourceItems[j] =new BagItem(orders1.getOrderNum(), orders1.getVolume(), orders1.getWeight());
                    j++;
                }
            }
            if(null != sourceItems){
                CarsBag carsBag = CarsBag.doBag(cars.getLoadCap().intValue(), sourceItems);//使用背包算法计算本次运送的订单
                carsBag.Items.toString();
                if(carsBag.Items != null && carsBag.Items.size() > 0){
                    for(BagItem bagItem : carsBag.Items){
                        Orders orders2 = new Orders();
                        orders2.setOrderNum(bagItem.getOrderId());
                        List<Orders> ordersList2 = ordersMapper.query(orders2);
                        if(null != ordersList2){
                            //更新订单状态
                            Orders od = ordersList2.get(0);
                            od.setState(3);
                            ordersMapper.updateByPrimaryKeySelective(od);
                        }
                    }
                }
            }
        }
        return invoiceMapper.insertSelective(invoice) == 1;
    }
    public Invoice selectByPrimaryKey(Integer id) {
        return invoiceMapper.selectByPrimaryKey(id);
    }
    public boolean updateByPrimaryKeySelective(Invoice invoice) {
        if(invoice.getState().equals(1)){
            invoice.setEndTime(new Date());
            //更新车辆状态
            Cars cars = carsMapper.selectByPrimaryKey(invoice.getCar());
            if(null != cars){
                cars.setState(0);
                carsMapper.updateByPrimaryKeySelective(cars);
            }
            //更新订单状态
            Orders orders = new Orders();
            orders.setStartSite(invoice.getStartSite());
            orders.setEndSite(invoice.getEndSite());
            orders.setState(2);
            List<Orders> ordersList = ordersMapper.query(orders);
            if(ordersList != null && ordersList.size() > 0){
                Date sd = invoice.getSendTime();
                sd.setHours(16);
                for(Orders orders1 : ordersList){
                    if(sd.after(orders1.getOrderTime())){//发货之后下的单，不处理
                        continue;
                    }
                    orders1.setState(3);
                    ordersMapper.updateByPrimaryKeySelective(orders1);
                }
            }
        }
        return invoiceMapper.updateByPrimaryKeySelective(invoice) == 1;
    }
    public boolean updateByPrimaryKey(Invoice invoice) {
        return invoiceMapper.updateByPrimaryKey(invoice) == 1;
    }
    public List<Invoice> queryPage(Invoice invoice) {
        return invoiceMapper.query(invoice);
    }
    public List<Invoice> list(Invoice invoice) {
        return invoiceMapper.query(invoice);
    }
}
