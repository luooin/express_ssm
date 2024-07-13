package com.demo.controller;
import com.demo.entity.Complaint;
import com.demo.service.ComplaintService;
import com.lifedian.common.controller.BaseController;
import com.lifedian.common.type.ResponseType;
import com.lifedian.common.type.SessionType;
import com.lifedian.common.vo.ResponseVo;
import com.demo.entity.Orders;
import com.demo.service.OrdersService;
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
@RequestMapping(value = "/complaint", produces = {"application/json;charset=UTF-8"})
public class ComplaintController extends BaseController {
    @Resource
    protected HttpServletRequest request;
    @Resource
    private ComplaintService complaintService;
    @Resource
    private OrdersService ordersService;
    @RequestMapping(value = "/admin/query")
    public String queryPage(Complaint complaint, ModelMap modelMap) {
        if((int)request.getSession().getAttribute(SessionType.USER_LEVEL.getName()) == 2){
            complaint.setUserId((int)request.getSession().getAttribute(SessionType.USER_ID.getName()));
        }
        List<Complaint> result = complaintService.queryPage(complaint);
        Orders orders = new Orders();
        orders.setUserId((int)request.getSession().getAttribute(SessionType.USER_ID.getName()));
        List<Orders> result2 = ordersService.queryPage(orders);
        modelMap.put("complaintList", result);
        modelMap.put("orderList", result2);
        return "/admin/complaint/complaint_list";
    }
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/list")
    public ResponseVo list(Complaint complaint) {
        if((int)request.getSession().getAttribute(SessionType.USER_LEVEL.getName()) == 2){
            complaint.setUserId((int)request.getSession().getAttribute(SessionType.USER_ID.getName()));
        }
        List<Complaint> result = complaintService.list(complaint);
        return new ResponseVo(ResponseType.SUCCESS, result);
    }
    @RequestMapping(value = "/admin/page/add")
    public String addPage(ModelMap modelMap) {
        Orders orders = new Orders();
        orders.setUserId((int)request.getSession().getAttribute(SessionType.USER_ID.getName()));
        List<Orders> result2 = ordersService.queryPage(orders);
        modelMap.put("orderList", result2);
        return "/admin/complaint/complaint_add";
    }
    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo add(Complaint complaint) {
        if (complaint.getId() == null) {
            complaint.setUserId((int)request.getSession().getAttribute(SessionType.USER_ID.getName()));
            return new ResponseVo(complaintService.insertSelective(complaint) ? ResponseType.ADD_SUCCESS : ResponseType.ADD_FAIL);
        }
        return new ResponseVo(ResponseType.ADD_FAIL);
    }
    @RequestMapping(value = "/admin/page/edit/{id}")
    public String editPage(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.put("complaint", complaintService.selectByPrimaryKey(id));
        Orders orders = new Orders();
        orders.setUserId((int)request.getSession().getAttribute(SessionType.USER_ID.getName()));
        List<Orders> result2 = ordersService.queryPage(orders);
        modelMap.put("orderList", result2);
        return "/admin/complaint/complaint_edit";
    }
    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    @ResponseBody
        public ResponseVo edit(Complaint complaint) {
        return new ResponseVo(complaintService.updateByPrimaryKeySelective(complaint) ? ResponseType.EDIT_SUCCESS : ResponseType.EDIT_FAIL);
    }
    @RequestMapping(value = "/admin/del/{id}")
    @ResponseBody
    public ResponseVo del(@PathVariable Integer id) {
        return new ResponseVo(complaintService.deleteByPrimaryKey(id) ? ResponseType.DEL_SUCCESS : ResponseType.DEL_FAIL);
    }
}
