package com.demo.controller;
import com.demo.entity.Invoice;
import com.demo.service.InvoiceService;
import com.lifedian.common.controller.BaseController;
import com.lifedian.common.type.ResponseType;
import com.lifedian.common.vo.ResponseVo;
import com.demo.entity.Cars;
import com.demo.service.CarsService;
import com.demo.entity.Drivers;
import com.demo.service.DriversService;
import com.demo.entity.Sites;
import com.demo.service.SitesService;
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
@RequestMapping(value = "/invoice", produces = {"application/json;charset=UTF-8"})
public class InvoiceController extends BaseController {
    @Resource
    protected HttpServletRequest request;
    @Resource
    private InvoiceService invoiceService;
    @Resource
    private CarsService carsService;
    @Resource
    private DriversService driversService;
    @Resource
    private SitesService sitesService;
    @RequestMapping(value = "/admin/query")
    public String queryPage(Invoice invoice, ModelMap modelMap) {
        List<Invoice> result = invoiceService.queryPage(invoice);
        modelMap.put("invoiceList", result);
        List<Cars> carsList = carsService.queryPage(new Cars());
        modelMap.put("carsList", carsList);
        List<Drivers> driversList = driversService.queryPage(new Drivers());
        modelMap.put("driversList", driversList);
        List<Sites> sitesList = sitesService.queryPage(new Sites());
        modelMap.put("sitesList", sitesList);
        return "/admin/invoice/invoice_list";
    }
    @RequestMapping(value = "/list")
    public ResponseVo list(Invoice invoice) {
        List<Invoice> result = invoiceService.list(invoice);
        return new ResponseVo(ResponseType.SUCCESS, result);
    }
    @RequestMapping(value = "/admin/page/add")
    public String addPage(ModelMap modelMap) {
        List<Cars> carsList = carsService.queryUnuse();
        modelMap.put("carsList", carsList);
        List<Drivers> driversList = driversService.queryPage(new Drivers());
        modelMap.put("driversList", driversList);
        List<Sites> sitesList = sitesService.queryPage(new Sites());
        modelMap.put("sitesList", sitesList);
        return "/admin/invoice/invoice_add";
    }
    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseVo add(Invoice invoice) {
        if (invoice.getId() == null) {
            return new ResponseVo(invoiceService.insertSelective(invoice) ? ResponseType.ADD_SUCCESS : ResponseType.ADD_FAIL);
        }
        return new ResponseVo(ResponseType.ADD_FAIL);
    }
    @RequestMapping(value = "/admin/page/edit/{id}")
    public String editPage(@PathVariable Integer id, ModelMap modelMap) {
        modelMap.put("invoice", invoiceService.selectByPrimaryKey(id));
        List<Cars> carsList = carsService.queryPage(new Cars());
        modelMap.put("carsList", carsList);
        List<Drivers> driversList = driversService.queryPage(new Drivers());
        modelMap.put("driversList", driversList);
        List<Sites> sitesList = sitesService.queryPage(new Sites());
        modelMap.put("sitesList", sitesList);
        return "/admin/invoice/invoice_edit";
    }
    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    @ResponseBody
        public ResponseVo edit(Invoice invoice) {
        return new ResponseVo(invoiceService.updateByPrimaryKeySelective(invoice) ? ResponseType.EDIT_SUCCESS : ResponseType.EDIT_FAIL);
    }
    @RequestMapping(value = "/admin/del/{id}")
    @ResponseBody
    public ResponseVo del(@PathVariable Integer id) {
        return new ResponseVo(invoiceService.deleteByPrimaryKey(id) ? ResponseType.DEL_SUCCESS : ResponseType.DEL_FAIL);
    }
}
