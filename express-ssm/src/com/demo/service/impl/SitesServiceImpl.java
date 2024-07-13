package com.demo.service.impl;
import com.demo.entity.Sites;
import com.demo.mapper.SitesMapper;
import com.demo.service.SitesService;
import com.demo.utils.Statistics;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
/**
* @Author
*/
@Service
public class SitesServiceImpl implements SitesService {
    @Resource
    private SitesMapper sitesMapper;
    public boolean deleteByPrimaryKey(Integer id) {
        return sitesMapper.deleteByPrimaryKey(id) == 1;
    }
    public boolean insert(Sites sites) {
        return sitesMapper.insert(sites) == 1;
    }
    public boolean insertSelective(Sites sites) {
        return sitesMapper.insertSelective(sites) == 1;
    }
    public Sites selectByPrimaryKey(Integer id) {
        return sitesMapper.selectByPrimaryKey(id);
    }
    public boolean updateByPrimaryKeySelective(Sites sites) {
        return sitesMapper.updateByPrimaryKeySelective(sites) == 1;
    }
    public boolean updateByPrimaryKey(Sites sites) {
        return sitesMapper.updateByPrimaryKey(sites) == 1;
    }
    public List<Sites> queryPage(Sites sites) {
        return sitesMapper.query(sites);
    }
    public List<Sites> list(Sites sites) {
        return sitesMapper.query(sites);
    }
    @Override
    public Statistics statistics() {
        List<Map<String, Double>> mapList = sitesMapper.statistics();
        if(null == mapList || mapList.size() == 0){
            return new Statistics();
        }
        Statistics statistics = new Statistics();
        if(null != mapList && mapList.size() > 0){
            String[] x = new String[mapList.size()];
            String[] y = new String[mapList.size()];
            Double total = 0.0;
            for(int i =0;i<mapList.size();i++){
                Map<String, Double> map = mapList.get(i);
                String site = map.get("site") + "";
                DecimalFormat df = new DecimalFormat("####.####");
                Sites sites = sitesMapper.selectByPrimaryKey(Integer.valueOf(site));
                x[i] = map.get("xx")+"";
                y[i] = df.format(Double.valueOf(map.get("yy")+"")/sites.getCapacity())+"";
                total = total + Double.valueOf(map.get("yy") + "");
            }
            statistics.setYy(y);
            statistics.setXx(x);
            statistics.setTotal(total + "");
        }
        return statistics;
    }
    @Override
    public Statistics achievement(Integer driverId, String startDate, String endDate) {
        List<Map<String, Double>> mapList = sitesMapper.achievement(driverId, startDate, endDate);
        if (null == mapList || mapList.size() == 0) {
            return new Statistics();
        }
        Statistics statistics = new Statistics();
        if (null != mapList && mapList.size() > 0) {
            String[] x = new String[mapList.size()];
            String[] y = new String[mapList.size()];
            Double total = 0.0;
            for (int i = 0; i < mapList.size(); i++) {
                Map<String, Double> map = mapList.get(i);
                x[i] = map.get("xx") + "";
                y[i] = map.get("yy") + "";
                total = total + Double.valueOf(map.get("yy") + "");
            }
            statistics.setYy(y);
            statistics.setXx(x);
            statistics.setTotal(total + "");
        }
        return statistics;
    }
}
