package org.louis.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest httpServletRequest)
    {
        return "url :" + httpServletRequest.getRequestURL() + "can access";
    }

    @RequestMapping("/pathvar/{str}")
    public @ResponseBody String demoPathVar(@PathVariable String str,HttpServletRequest httpServletRequest)
    {
        return "url :" + httpServletRequest.getRequestURL() + "can str : " + str;
    }

    @RequestMapping("/requestParam")
    public @ResponseBody String passRequestParam(Long id ,HttpServletRequest httpServletRequest)
    {
        return "url :" + httpServletRequest.getRequestURL() + "can id : " + id;
    }

    @RequestMapping(value="/obj",produces = "application/json;charset=UTF-8")
    public @ResponseBody String passObj(DemoObj obj ,HttpServletRequest httpServletRequest)
    {
        return "url :" + httpServletRequest.getRequestURL() + "can obj : " + obj;
    }

    @RequestMapping(value={"/name1","/name2"},produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest httpServletRequest)
    {
        return "url :" + httpServletRequest.getRequestURL() + "remove";
    }
}
