package com.demo.controller;
import com.demo.entity.Admin;
import com.demo.service.AdminService;
import com.lifedian.common.controller.BaseController;
import com.lifedian.common.type.ResponseType;
import com.lifedian.common.vo.ResponseVo;
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
@RequestMapping(value = "/admin", produces = {"application/json;charset=UTF-8"})
public class AdminController extends BaseController {
    @Resource
    protected HttpServletRequest request;
    @Resource
    private AdminService adminService;
    @RequestMapping(value = "/admin/query")
    public String queryPage(Admin admin, ModelMap modelMap) {
        List<Admin> result = adminService.queryPage(admin);
        modelMap.put("adminList", result);
        return "/admin/admin/admin_list";
    }
    @RequestMapping(value = "/list")
    public ResponseVo list(Admin admin) {
        List<Admin> result = adminService.list(admin);
        return new ResponseVo(ResponseType.SUCCESS, result);
    }
    @RequestMapping(value = "/admin/page/add")
    public String addPage() {
        return "/admin/admin/admin_add";
    }
    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo add(Admin admin) {
        if (admin.getId() == null) {
            return new ResponseVo(adminService.insertSelective(admin) ? ResponseType.ADD_SUCCESS : ResponseType.ADD_FAIL);
        }
        return new ResponseVo(ResponseType.ADD_FAIL);
    }
    @RequestMapping(value = "/admin/page/edit/{id}")
    public String editPage(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.put("admin", adminService.selectByPrimaryKey(id));
        return "/admin/admin/admin_edit";
    }
    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    @ResponseBody
        public ResponseVo edit(Admin admin) {
        return new ResponseVo(adminService.updateByPrimaryKeySelective(admin) ? ResponseType.EDIT_SUCCESS : ResponseType.EDIT_FAIL);
    }
    @RequestMapping(value = "/admin/del/{id}")
    @ResponseBody
    public ResponseVo del(@PathVariable Integer id) {
        return new ResponseVo(adminService.deleteByPrimaryKey(id) ? ResponseType.DEL_SUCCESS : ResponseType.DEL_FAIL);
    }
}
