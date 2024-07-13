package com.demo.service;
import com.demo.entity.Complaint;

import java.util.List;
/**
* @Author
*/
public interface ComplaintService {
    boolean deleteByPrimaryKey(Integer id);
    boolean insert(Complaint complaint);
    boolean insertSelective(Complaint complaint);
    Complaint selectByPrimaryKey(Integer id);
    boolean updateByPrimaryKeySelective(Complaint complaint);
    boolean updateByPrimaryKey(Complaint complaint);
    List<Complaint> queryPage(Complaint complaint);
    List<Complaint> list(Complaint complaint);
}
