package com.demo.service;
import com.demo.entity.Sites;
import com.demo.utils.Statistics;
import java.util.List;
/**
* @Author
*/
public interface SitesService {
    boolean deleteByPrimaryKey(Integer id);
    boolean insert(Sites sites);
    boolean insertSelective(Sites sites);
    Sites selectByPrimaryKey(Integer id);
    boolean updateByPrimaryKeySelective(Sites sites);
    boolean updateByPrimaryKey(Sites sites);
    List<Sites> queryPage(Sites sites);
    List<Sites> list(Sites sites);
    Statistics statistics();
    Statistics achievement(Integer driverId, String startDate, String endDate);
}
