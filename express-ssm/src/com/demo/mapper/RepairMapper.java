package com.demo.mapper;
import com.demo.entity.Repair;
import java.util.List;
/**
* @Author
*/
public interface RepairMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Repair repair);
    int insertSelective(Repair repair);
    Repair selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Repair repair);
    int updateByPrimaryKey(Repair repair);
    List<Repair> query(Repair repair);
}
