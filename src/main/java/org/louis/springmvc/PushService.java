package org.louis.springmvc;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Optional;

@Service
public class PushService {

    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsncyUpdate() {
        deferredResult = new DeferredResult<>();
        return deferredResult;
    }

    @Scheduled(fixedDelay = 5000)
    public void refresh()
    {
        Optional.of(deferredResult).ifPresent(d->{
            d.setResult(Long.toString(System.currentTimeMillis()));
        });

    }
}
