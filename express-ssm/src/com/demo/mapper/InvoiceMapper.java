package com.demo.mapper;
import com.demo.entity.Invoice;
import java.util.List;
/**
* @Author
*/
public interface InvoiceMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Invoice invoice);
    int insertSelective(Invoice invoice);
    Invoice selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Invoice invoice);
    int updateByPrimaryKey(Invoice invoice);
    List<Invoice> query(Invoice invoice);
}
