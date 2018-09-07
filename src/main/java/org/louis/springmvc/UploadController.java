package org.louis.springmvc;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping (value="/upload")
    public @ResponseBody
    String upload(MultipartFile multipartFile){
        try{
            FileUtils.writeByteArrayToFile(new File(multipartFile.getOriginalFilename()),multipartFile.getBytes());
            return "fine";
        }catch (IOException ex)
        {
            ex.printStackTrace();
            return "wrong";
        }
    }
}
