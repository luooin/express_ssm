package com.demo.mapper;
import com.demo.entity.Complaint;
import java.util.List;
/**
* @Author
*/
public interface ComplaintMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Complaint complaint);
    int insertSelective(Complaint complaint);
    Complaint selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Complaint complaint);
    int updateByPrimaryKey(Complaint complaint);
    List<Complaint> query(Complaint complaint);
}
