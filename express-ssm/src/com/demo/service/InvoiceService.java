package com.demo.service;
import com.demo.entity.Invoice;

import java.util.List;
/**
* @Author
*/
public interface InvoiceService {
    boolean deleteByPrimaryKey(Integer id);
    boolean insert(Invoice invoice);
    boolean insertSelective(Invoice invoice);
    Invoice selectByPrimaryKey(Integer id);
    boolean updateByPrimaryKeySelective(Invoice invoice);
    boolean updateByPrimaryKey(Invoice invoice);
    List<Invoice> queryPage(Invoice invoice);
    List<Invoice> list(Invoice invoice);
}
