package org.louis.springmvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value="/getjson",produces = "application/json;charset=UTF-8")
    public @ResponseBody
    DemoObj getjson(DemoObj obj)
    {
        DemoObj demoObj =  new DemoObj();

        demoObj.setId(122L);
        demoObj.setName("jkl");

        return demoObj;
    }

    @RequestMapping(value="/getxml",produces = "application/xml;charset=UTF-8")
    public @ResponseBody
    DemoObj getxml(DemoObj obj)
    {
        DemoObj demoObj =  new DemoObj();

        demoObj.setId(111L);
        demoObj.setName("uio");

        return demoObj;
    }
}
