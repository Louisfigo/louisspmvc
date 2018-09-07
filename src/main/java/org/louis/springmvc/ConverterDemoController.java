package org.louis.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterDemoController {

    @RequestMapping(value = "/ctr",produces = "application/x-louis")

    @ResponseBody DemoObj convert(@RequestBody DemoObj demoObj)
    {
        return  demoObj;
    }
}
