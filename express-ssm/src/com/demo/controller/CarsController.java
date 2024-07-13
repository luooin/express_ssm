package com.demo.controller;
import com.demo.entity.Cars;
import com.demo.service.CarsService;
import com.lifedian.common.controller.BaseController;
import com.lifedian.common.type.ResponseType;
import com.lifedian.common.vo.ResponseVo;
import com.demo.entity.Drivers;
import com.demo.service.DriversService;
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
@RequestMapping(value = "/cars", produces = {"application/json;charset=UTF-8"})
public class CarsController extends BaseController {
    @Resource
    protected HttpServletRequest request;
    @Resource
    private CarsService carsService;
    @Resource
    private DriversService driversService;
    @RequestMapping(value = "/admin/query")
    public String queryPage(Cars cars, ModelMap modelMap) {
        List<Cars> result = carsService.queryPage(cars);
        modelMap.put("carsList", result);
        List<Drivers> driversList = driversService.queryPage(new Drivers());
        modelMap.put("driversList",driversList);
        return "/admin/cars/cars_list";
    }
    @RequestMapping(value = "/list")
    public ResponseVo list(Cars cars) {
        List<Cars> result = carsService.list(cars);
        return new ResponseVo(ResponseType.SUCCESS, result);
    }
    @RequestMapping(value = "/admin/page/add")
    public String addPage(ModelMap modelMap) {
        List<Drivers> driversList = driversService.queryPage(new Drivers());
        modelMap.put("driversList",driversList);
        return "/admin/cars/cars_add";
    }
    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo add(Cars cars) {
        if (cars.getId() == null) {
            return new ResponseVo(carsService.insertSelective(cars) ? ResponseType.ADD_SUCCESS : ResponseType.ADD_FAIL);
        }
        return new ResponseVo(ResponseType.ADD_FAIL);
    }
    @RequestMapping(value = "/admin/page/edit/{id}")
    public String editPage(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.put("cars", carsService.selectByPrimaryKey(id));
        List<Drivers> driversList = driversService.queryPage(new Drivers());
        modelMap.put("driversList",driversList);
        return "/admin/cars/cars_edit";
    }
    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    @ResponseBody
        public ResponseVo edit(Cars cars) {
        return new ResponseVo(carsService.updateByPrimaryKeySelective(cars) ? ResponseType.EDIT_SUCCESS : ResponseType.EDIT_FAIL);
    }
    @RequestMapping(value = "/admin/del/{id}")
    @ResponseBody
    public ResponseVo del(@PathVariable Integer id) {
        return new ResponseVo(carsService.deleteByPrimaryKey(id) ? ResponseType.DEL_SUCCESS : ResponseType.DEL_FAIL);
    }
}
