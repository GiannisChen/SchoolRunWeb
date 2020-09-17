package com.wywnb.schoolrun.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        String url = request.getRequestURI();
        String method = request.getMethod();
        if(user == null) {
            if(method.equals("GET") && (url.equals("/logup.html") || url.equals("/logup"))) {
                return true;
            }
            if(method.equals("POST") && url.equals("logup/submit")) {
                return true;
            }
            //未登录
            request.setAttribute("msg", "请先登录！");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }
        else {
            //已登录
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
