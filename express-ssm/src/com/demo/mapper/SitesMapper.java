package com.demo.mapper;
import com.demo.entity.Sites;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;
/**
* @Author
*/
public interface SitesMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Sites sites);
    int insertSelective(Sites sites);
    Sites selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Sites sites);
    int updateByPrimaryKey(Sites sites);
    List<Sites> query(Sites sites);
    List<Map<String, Double>> statistics();
    List<Map<String, Double>> achievement(@Param("derversId") Integer derverId, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
