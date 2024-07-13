package com.demo.controller;
import com.lifedian.common.type.SessionType;
import com.lifedian.common.type.UserLevel;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
/**
 * 基础操作Controller
 */
public class BaseController {
    @Resource
    protected HttpServletRequest request;
    /**
     * 设置session
     *
     * @param userId
     * @param userName
     * @param userLevel
     */
    protected void setSession(Integer userId, String userName, UserLevel userLevel) {
        request.getSession().setAttribute(SessionType.USER_LEVEL.getName(), userLevel.getLevelCode());
        request.getSession().setAttribute("userName", userName);
        request.getSession().setAttribute(SessionType.USER_NAME.getName(), userName);
        request.getSession().setAttribute(SessionType.USER_ID.getName(), userId);
    }
    protected void setSession(SessionType sessionType, String value) {
        request.getSession().setAttribute(sessionType.getName(), value);
    }
    /**
     * 清空session
     */
    protected void cleanSession() {
        request.getSession().removeAttribute(SessionType.USER_LEVEL.getName());
        request.getSession().removeAttribute("userName");
        request.getSession().removeAttribute(SessionType.USER_NAME.getName());
        request.getSession().removeAttribute(SessionType.USER_ID.getName());
        request.getSession().removeAttribute(SessionType.USER_PHONE.getName());
    }
    /**
     * 获取用户名
     *
     * @return
     */
    protected String getUserName() {
        return (String) request.getSession().getAttribute(SessionType.USER_NAME.getName());
    }
    /**
     * 获取用户id
     *
     * @return
     */
    protected Integer getUserId() {
        return (Integer) request.getSession().getAttribute(SessionType.USER_ID.getName());
    }
    protected Integer getUserLevel() {
        return (Integer) request.getSession().getAttribute(SessionType.USER_LEVEL.getName());
    }
    /**
     * 获取用户手机号
     *
     * @return
     */
    protected Integer getUserPhone() {
        return (Integer) request.getSession().getAttribute(SessionType.USER_PHONE.getName());
    }
    /**
     * 是否登录
     *
     * @return
     */
    protected boolean isLogin() {
        return request.getSession().getAttribute(SessionType.USER_ID.getName()) != null;
    }
    /**
     * 是否是管理员
     *
     * @return
     */
    protected Boolean isAdmin() {
        Object userlevel = request.getSession().getAttribute(SessionType.USER_LEVEL.getName());
        if (null == userlevel) {
            return false;
        }
        Integer userLevel = (Integer) userlevel;
        if (null == userLevel) {
            return false;
        }
        return userLevel.intValue() == UserLevel.ADMIN.getLevelCode();
    }
    /**
     * 是否是用户
     *
     * @return
     */
    protected Boolean isUser() {
        Object userlevel = request.getSession().getAttribute(SessionType.USER_LEVEL.getName());
        if (null == userlevel) {
            return false;
        }
        Integer userLevel = (Integer) userlevel;
        if (null == userLevel) {
            return false;
        }
        return userLevel.intValue() == UserLevel.USER.getLevelCode();
    }
    /**
     * 获取当前域名信息
     *
     * @return
     */
    protected String getDomainName() {
        StringBuffer url = request.getRequestURL();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();
    }
    /**
     * 获取项目的部署根目录
     *
     * @return
     */
    protected String getRootPath() {
        return request.getSession().getServletContext().getRealPath("/");
    }
}
