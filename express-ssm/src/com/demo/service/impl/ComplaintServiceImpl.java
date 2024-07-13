package com.demo.service.impl;
import com.demo.entity.Complaint;
import com.demo.mapper.ComplaintMapper;
import com.demo.service.ComplaintService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/**
* @Author
*/
@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Resource
    private ComplaintMapper complaintMapper;
    public boolean deleteByPrimaryKey(Integer id) {
        return complaintMapper.deleteByPrimaryKey(id) == 1;
    }
    public boolean insert(Complaint complaint) {
        return complaintMapper.insert(complaint) == 1;
    }
    public boolean insertSelective(Complaint complaint) {
        return complaintMapper.insertSelective(complaint) == 1;
    }
    public Complaint selectByPrimaryKey(Integer id) {
        return complaintMapper.selectByPrimaryKey(id);
    }
    public boolean updateByPrimaryKeySelective(Complaint complaint) {
        return complaintMapper.updateByPrimaryKeySelective(complaint) == 1;
    }
    public boolean updateByPrimaryKey(Complaint complaint) {
        return complaintMapper.updateByPrimaryKey(complaint) == 1;
    }
    public List<Complaint> queryPage(Complaint complaint) {
        return complaintMapper.query(complaint);
    }
    public List<Complaint> list(Complaint complaint) {
        return complaintMapper.query(complaint);
    }
}
