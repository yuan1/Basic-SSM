package cn.javayuan.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 基于Spring的简单拦截器
 * Created by 李明元 on 2016/11/11.
 */
public class SecurityInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {

        //获取url地址
        String reqUrl = request.getRequestURI().replace(request.getContextPath(), "");
        //当url地址为登录的url的时候跳过拦截器
        if (reqUrl.contains("/index.jsp")) {
            return true;
        } else {
            HttpSession session = request.getSession();
            Object obj = session.getAttribute("user");
            if (obj == null || "".equals(obj.toString())) {
                response.sendRedirect("/error.jsp");
            }
        }
        return true;
    }

}
