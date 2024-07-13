package com.demo.service;
import com.demo.entity.Repair;

import java.util.List;
/**
* @Author
*/
public interface RepairService {
    boolean deleteByPrimaryKey(Integer id);
    boolean insert(Repair repair);
    boolean insertSelective(Repair repair);
    Repair selectByPrimaryKey(Integer id);
    boolean updateByPrimaryKeySelective(Repair repair);
    boolean updateByPrimaryKey(Repair repair);
    List<Repair> queryPage(Repair repair);
    List<Repair> list(Repair repair);
}
