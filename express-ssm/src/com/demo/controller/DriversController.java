package com.demo.controller;
import com.demo.entity.Drivers;
import com.demo.service.DriversService;
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
@RequestMapping(value = "/drivers", produces = {"application/json;charset=UTF-8"})
public class DriversController extends BaseController {
    @Resource
    protected HttpServletRequest request;
    @Resource
    private DriversService driversService;
    @RequestMapping(value = "/admin/query")
    public String queryPage(Drivers drivers, ModelMap modelMap) {
        List<Drivers> result = driversService.queryPage(drivers);
        modelMap.put("driversList", result);
        return "/admin/drivers/drivers_list";
    }
    @RequestMapping(value = "/list")
    public ResponseVo list(Drivers drivers) {
        List<Drivers> result = driversService.list(drivers);
        return new ResponseVo(ResponseType.SUCCESS, result);
    }
    @RequestMapping(value = "/admin/page/add")
    public String addPage() {
        return "/admin/drivers/drivers_add";
    }
    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo add(Drivers drivers) {
        if (drivers.getId() == null) {
            return new ResponseVo(driversService.insertSelective(drivers) ? ResponseType.ADD_SUCCESS : ResponseType.ADD_FAIL);
        }
        return new ResponseVo(ResponseType.ADD_FAIL);
    }
    @RequestMapping(value = "/admin/page/edit/{id}")
    public String editPage(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.put("drivers", driversService.selectByPrimaryKey(id));
        return "/admin/drivers/drivers_edit";
    }
    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo edit(Drivers drivers) {
        return new ResponseVo(driversService.updateByPrimaryKeySelective(drivers) ? ResponseType.EDIT_SUCCESS : ResponseType.EDIT_FAIL);
    }
    @RequestMapping(value = "/admin/del/{id}")
    @ResponseBody
    public ResponseVo del(@PathVariable Integer id) {
        return new ResponseVo(driversService.deleteByPrimaryKey(id) ? ResponseType.DEL_SUCCESS : ResponseType.DEL_FAIL);
    }
    @RequestMapping(value = "/admin/page/statistics")
    public String statistics(ModelMap modelMap) {
        List<Drivers> result = driversService.queryPage(new Drivers());
        modelMap.put("driversList", result);
        return "admin/statistics/drivers_statistics";
    }
    @ResponseBody
    @RequestMapping(value = "/admin/statistics")
    public String statistics(Integer driverId, String startDate, String endDate, ModelMap modelMap) {
        Statistics statistics = driversService.statistics(driverId, startDate, endDate);
        modelMap.put("result", statistics);
        return FastjsonUtil.serialize(modelMap);
    }
}
