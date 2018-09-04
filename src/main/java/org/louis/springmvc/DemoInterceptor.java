package org.louis.springmvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)
    {
        long stTime = System.currentTimeMillis();
        request.setAttribute("st",stTime);
        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long st = (Long)request.getAttribute("st");
        request.removeAttribute("st");
        long et = System.currentTimeMillis();

        System.out.println("handler time is " + (et-st) + "ms");

        request.setAttribute("ht" ,(et-st));
    }
}
