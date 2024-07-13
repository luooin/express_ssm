package com.demo.controller;
import com.lifedian.common.type.ResponseType;
import com.lifedian.common.type.UserLevel;
import com.lifedian.common.utils.FastjsonUtil;
import com.lifedian.common.vo.ResponseVo;
import com.demo.entity.Admin;
import com.demo.service.AdminService;
import com.demo.entity.Drivers;
import com.demo.service.DriversService;
import com.demo.entity.Users;
import com.demo.users.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping(value = "", produces = {"application/json;charset=UTF-8"})
public class IndexController extends BaseController {
    @Resource
    protected AdminService adminService;
    @Resource
    protected DriversService driversService;
    @Resource
    protected UsersService usersService;
    @RequestMapping(value = "/index")
    public String index() {
        return "/index";
    }
    @RequestMapping(value = "/home")
    public String sysinfo() {
        return "/home";
    }
    @RequestMapping(value = "/adminLogin")
    @ResponseBody
    public String login(HttpSession session, String loginname, String password, Integer juese, ModelMap modelMap) {
        if(juese == 0){
            Admin admin = adminService.login(loginname, password);
            if(admin != null){
                setSession(admin.getId(), admin.getLoginname(), UserLevel.ADMIN);
                return FastjsonUtil.serialize(new ResponseVo(ResponseType.LOGON_SUCCESS));
            } else {
                return FastjsonUtil.serialize(new ResponseVo(ResponseType.LOGON_FAILURE));
            }
        }else if(juese == 1){
            Drivers drivers = driversService.login(loginname, password);
            if(drivers != null){
                setSession(drivers.getId(), drivers.getLoginname(), UserLevel.USER);
                return FastjsonUtil.serialize(new ResponseVo(ResponseType.LOGON_SUCCESS));
            } else {
                return FastjsonUtil.serialize(new ResponseVo(ResponseType.LOGON_FAILURE));
            }
        }else if(juese == 2){
            Users users = usersService.login(loginname, password);
            if(users != null){
                setSession(users.getId(), users.getLoginname(), UserLevel.STAFF);
                return FastjsonUtil.serialize(new ResponseVo(ResponseType.LOGON_SUCCESS));
            } else {
                return FastjsonUtil.serialize(new ResponseVo(ResponseType.LOGON_FAILURE));
            }
        }
        return FastjsonUtil.serialize(new ResponseVo(ResponseType.LOGON_FAILURE));
    }
    @RequestMapping(value = "/admin/login")
    public String loginPage() {
        return "/login";
    }
    @RequestMapping(value = "/loginout")
    public String adminLoginout(HttpSession session) {
        cleanSession();
        return "redirect:/index";
    }
    @RequestMapping(value = "/user/page/reg")
    public String addPage() {
        return "/reg";
    }
    @RequestMapping(value = "/user/reg")
    @ResponseBody
    public ResponseVo add(Users users) {
        if (users.getId() == null) {
            Users users1 = new Users();
            users1.setLoginname(users.getLoginname());
            if(usersService.queryPage(users1).size() > 0){
                return new ResponseVo(false, "fail", "用户名已存在");
            }
            return new ResponseVo(usersService.insertSelective(users) ? ResponseType.ADD_SUCCESS : ResponseType.ADD_FAIL);
        }
        return new ResponseVo(ResponseType.ADD_FAIL);
    }
}
