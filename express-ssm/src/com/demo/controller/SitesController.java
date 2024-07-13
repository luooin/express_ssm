package com.demo.controller;
import com.demo.entity.Sites;
import com.demo.service.SitesService;
import com.lifedian.common.controller.BaseController;
import com.lifedian.common.type.ResponseType;
import com.lifedian.common.utils.FastjsonUtil;
import com.lifedian.common.vo.ResponseVo;
import com.demo.utils.Statistics;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
* @Author
*/
@Controller
@RequestMapping(value = "/sites", produces = {"application/json;charset=UTF-8"})
public class SitesController extends BaseController {
    @Resource
    protected HttpServletRequest request;
    @Resource
    private SitesService sitesService;
    @RequestMapping(value = "/admin/query")
    public String queryPage(Sites sites, ModelMap modelMap) {
        List<Sites> result = sitesService.queryPage(sites);
        modelMap.put("sitesList", result);
        return "/admin/sites/sites_list";
    }
    @RequestMapping(value = "/list")
    public ResponseVo list(Sites sites) {
        List<Sites> result = sitesService.list(sites);
        return new ResponseVo(ResponseType.SUCCESS, result);
    }
    @RequestMapping(value = "/admin/page/add")
    public String addPage() {
        return "/admin/sites/sites_add";
    }
    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo add(Sites sites) {
        if (sites.getId() == null) {
            return new ResponseVo(sitesService.insertSelective(sites) ? ResponseType.ADD_SUCCESS : ResponseType.ADD_FAIL);
        }
        return new ResponseVo(ResponseType.ADD_FAIL);
    }
    @RequestMapping(value = "/admin/page/edit/{id}")
    public String editPage(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.put("sites", sitesService.selectByPrimaryKey(id));
        return "/admin/sites/sites_edit";
    }
    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    @ResponseBody
        public ResponseVo edit(Sites sites) {
        return new ResponseVo(sitesService.updateByPrimaryKeySelective(sites) ? ResponseType.EDIT_SUCCESS : ResponseType.EDIT_FAIL);
    }
    @RequestMapping(value = "/admin/del/{id}")
    @ResponseBody
    public ResponseVo del(@PathVariable Integer id) {
        return new ResponseVo(sitesService.deleteByPrimaryKey(id) ? ResponseType.DEL_SUCCESS : ResponseType.DEL_FAIL);
    }
    @RequestMapping(value = "/admin/page/statistics")
    public String statistics() {
        return "admin/statistics/statistics";
    }
    @ResponseBody
    @RequestMapping(value = "/admin/statistics")
    public String statistics(ModelMap modelMap) {
        Statistics statistics = sitesService.statistics();
        modelMap.put("result", statistics);
        return FastjsonUtil.serialize(modelMap);
    }
    @RequestMapping(value = "/admin/page/achievement")
    public String achievement2(ModelMap modelMap) {
        return "admin/statistics/achievement";
    }
    @ResponseBody
    @RequestMapping(value = "/admin/achievement")
    public String achievement3(Integer driverId, String startDate, String endDate, ModelMap modelMap) {
        Statistics statistics = sitesService.achievement(driverId, startDate, endDate);
        modelMap.put("result", statistics);
        return FastjsonUtil.serialize(modelMap);
    }
}
