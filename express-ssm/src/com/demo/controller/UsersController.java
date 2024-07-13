package com.demo.controller;
import com.demo.entity.Users;
import com.demo.users.UsersService;
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
@RequestMapping(value = "/users", produces = {"application/json;charset=UTF-8"})
public class UsersController extends BaseController {
    @Resource
    protected HttpServletRequest request;
    @Resource
    private UsersService usersService;
    @RequestMapping(value = "/admin/query")
    public String queryPage(Users users, ModelMap modelMap) {
        List<Users> result = usersService.queryPage(users);
        modelMap.put("usersList", result);
        return "/admin/users/users_list";
    }
    @RequestMapping(value = "/list")
    public ResponseVo list(Users users) {
        List<Users> result = usersService.list(users);
        return new ResponseVo(ResponseType.SUCCESS, result);
    }
    @RequestMapping(value = "/admin/page/add")
    public String addPage() {
        return "/admin/users/users_add";
    }
    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo add(Users users) {
        if (users.getId() == null) {
            return new ResponseVo(usersService.insertSelective(users) ? ResponseType.ADD_SUCCESS : ResponseType.ADD_FAIL);
        }
        return new ResponseVo(ResponseType.ADD_FAIL);
    }
    @RequestMapping(value = "/admin/page/edit/{id}")
    public String editPage(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.put("users", usersService.selectByPrimaryKey(id));
        return "/admin/users/users_edit";
    }
    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    @ResponseBody
        public ResponseVo edit(Users users) {
        return new ResponseVo(usersService.updateByPrimaryKeySelective(users) ? ResponseType.EDIT_SUCCESS : ResponseType.EDIT_FAIL);
    }
    @RequestMapping(value = "/admin/del/{id}")
    @ResponseBody
    public ResponseVo del(@PathVariable Integer id) {
        return new ResponseVo(usersService.deleteByPrimaryKey(id) ? ResponseType.DEL_SUCCESS : ResponseType.DEL_FAIL);
    }
}
