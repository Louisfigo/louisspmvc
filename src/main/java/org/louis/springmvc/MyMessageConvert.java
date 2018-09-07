package org.louis.springmvc;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MyMessageConvert extends AbstractHttpMessageConverter<DemoObj> {

    public MyMessageConvert()
    {
        super(new MediaType("application","x-louis", StandardCharsets.UTF_8));
    }


    @Override
    protected boolean supports(Class<?> aClass) {
        return DemoObj.class.isAssignableFrom(aClass);
    }

    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {

        String temp = StreamUtils.copyToString(httpInputMessage.getBody(),StandardCharsets.UTF_8);
        String tempArr [] = temp.split("-");

        DemoObj demoObj  = new DemoObj();

        demoObj.setName(tempArr[1]);
        demoObj.setId(Long.parseLong(tempArr[0]));

        return demoObj;
    }

    @Override
    protected void writeInternal(DemoObj demoObj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

        String out="hello :" +demoObj;

        httpOutputMessage.getBody().write(out.getBytes());
    }
}
