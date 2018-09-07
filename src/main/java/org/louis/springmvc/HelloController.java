package org.louis.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Controller
public class HelloController {

    @RequestMapping("/index1111")
    public String hello()
    {
        return "index";
    }

    @RequestMapping(value = "/pushsse",produces = "text/event-stream")
    public  @ResponseBody String pushsse()
    {
        Random r = new Random();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "data :testing " + r.nextInt() +"\n\n";

    }
}
