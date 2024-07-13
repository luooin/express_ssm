package com.demo.controller;
import com.demo.entity.Orders;
import com.demo.service.OrdersService;
import com.github.pagehelper.Page;
import com.lifedian.common.controller.BaseController;
import com.lifedian.common.type.ResponseType;
import com.lifedian.common.type.SessionType;
import com.lifedian.common.vo.ResponseVo;
import com.demo.entity.Sites;
import com.demo.service.SitesService;
import com.demo.entity.Users;
import com.demo.users.UsersService;
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
@RequestMapping(value = "/orders", produces = {"application/json;charset=UTF-8"})
public class OrdersController extends BaseController {
    @Resource
    protected HttpServletRequest request;
    @Resource
    private OrdersService ordersService;
    @Resource
    private UsersService usersService;
    @Resource
    private SitesService sitesService;
    @RequestMapping(value = "/admin/query")
    public String queryPage(Orders orders, ModelMap modelMap) {
        if((int)request.getSession().getAttribute(SessionType.USER_LEVEL.getName()) == 2){
            orders.setUserId((int)request.getSession().getAttribute(SessionType.USER_ID.getName()));
        }
        Page<Orders> result = ordersService.queryPage(orders);
        modelMap.put("ordersList", result.getResult());
        List<Users> result2 = usersService.queryPage(new Users());
        modelMap.put("usersList", result2);
        List<Sites> sitesList = sitesService.queryPage(new Sites());
        modelMap.put("sitesList", sitesList);
        super.request = request;
        modelMap.put("page", getPageInfo(result).getHtml());
        return "/admin/orders/orders_list";
    }
    @RequestMapping(value = "/list")
    public ResponseVo list(Orders orders) {
        if((int)request.getSession().getAttribute(SessionType.USER_LEVEL.getName()) == 2){
            orders.setUserId((int)request.getSession().getAttribute(SessionType.USER_ID.getName()));
        }
        List<Orders> result = ordersService.list(orders);
        return new ResponseVo(ResponseType.SUCCESS, result);
    }
    @RequestMapping(value = "/admin/page/add")
    public String addPage(ModelMap modelMap) {
        List<Users> result2 = usersService.queryPage(new Users());
        modelMap.put("usersList", result2);
        List<Sites> sitesList = sitesService.queryPage(new Sites());
        modelMap.put("sitesList", sitesList);
        return "/admin/orders/orders_add";
    }
    @RequestMapping(value = "/admin/page/pay/{id}")
    public String payPage(@PathVariable Integer id, ModelMap modelMap) {
        List<Users> result2 = usersService.queryPage(new Users());
        modelMap.put("usersList", result2);
        modelMap.put("orders", ordersService.selectByPrimaryKey(id));
        List<Sites> sitesList = sitesService.queryPage(new Sites());
        modelMap.put("sitesList", sitesList);
        return "/admin/orders/orders_pay";
    }
    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo add(Orders orders) {
        if (orders.getId() == null) {
            orders.setState(10);//代付款
            return new ResponseVo(ordersService.insertSelective(orders) ? ResponseType.ADD_SUCCESS : ResponseType.ADD_FAIL);
        }
        return new ResponseVo(ResponseType.ADD_FAIL);
    }
    @RequestMapping(value = "/admin/page/edit/{id}")
    public String editPage(@PathVariable Integer id, ModelMap modelMap) {
        List<Users> result2 = usersService.queryPage(new Users());
        modelMap.put("usersList", result2);
        modelMap.put("orders", ordersService.selectByPrimaryKey(id));
        List<Sites> sitesList = sitesService.queryPage(new Sites());
        modelMap.put("sitesList", sitesList);
        return "/admin/orders/orders_edit";
    }
    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    @ResponseBody
        public ResponseVo edit(Orders orders) {
        return new ResponseVo(ordersService.updateByPrimaryKeySelective(orders) ? ResponseType.EDIT_SUCCESS : ResponseType.EDIT_FAIL);
    }
    @RequestMapping(value = "/admin/del/{id}")
    @ResponseBody
    public ResponseVo del(@PathVariable Integer id) {
        return new ResponseVo(ordersService.deleteByPrimaryKey(id) ? ResponseType.DEL_SUCCESS : ResponseType.DEL_FAIL);
    }
}
