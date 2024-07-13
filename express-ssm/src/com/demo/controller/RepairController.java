package com.demo.controller;
import com.demo.entity.Repair;
import com.demo.service.RepairService;
import com.lifedian.common.controller.BaseController;
import com.lifedian.common.type.ResponseType;
import com.lifedian.common.vo.ResponseVo;
import com.demo.entity.Cars;
import com.demo.service.CarsService;
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
@RequestMapping(value = "/repair", produces = {"application/json;charset=UTF-8"})
public class RepairController extends BaseController {
    @Resource
    protected HttpServletRequest request;
    @Resource
    private CarsService carsService;
    @Resource
    private RepairService repairService;
    @RequestMapping(value = "/admin/query")
    public String queryPage(Repair repair, ModelMap modelMap) {
        List<Repair> result = repairService.queryPage(repair);
        modelMap.put("repairList", result);
        List<Cars> result2 = carsService.queryPage(new Cars());
        modelMap.put("carsList", result2);
        return "/admin/repair/repair_list";
    }
    @RequestMapping(value = "/list")
    public ResponseVo list(Repair repair) {
        List<Repair> result = repairService.list(repair);
        return new ResponseVo(ResponseType.SUCCESS, result);
    }
    @RequestMapping(value = "/admin/page/add")
    public String addPage(ModelMap modelMap) {
        List<Cars> result2 = carsService.queryBad();
        modelMap.put("carsList", result2);
        return "/admin/repair/repair_add";
    }
    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo add(Repair repair) {
        if (repair.getId() == null) {
            return new ResponseVo(repairService.insertSelective(repair) ? ResponseType.ADD_SUCCESS : ResponseType.ADD_FAIL);
        }
        return new ResponseVo(ResponseType.ADD_FAIL);
    }
    @RequestMapping(value = "/admin/page/edit/{id}")
    public String editPage(@PathVariable Integer id, ModelMap modelMap) {
        List<Cars> result2 = carsService.queryPage(new Cars());
        modelMap.put("carsList", result2);
        modelMap.put("repair", repairService.selectByPrimaryKey(id));
        return "/admin/repair/repair_edit";
    }
    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    @ResponseBody
        public ResponseVo edit(Repair repair) {
        return new ResponseVo(repairService.updateByPrimaryKeySelective(repair) ? ResponseType.EDIT_SUCCESS : ResponseType.EDIT_FAIL);
    }
    @RequestMapping(value = "/admin/del/{id}")
    @ResponseBody
    public ResponseVo del(@PathVariable Integer id) {
        return new ResponseVo(repairService.deleteByPrimaryKey(id) ? ResponseType.DEL_SUCCESS : ResponseType.DEL_FAIL);
    }
}
