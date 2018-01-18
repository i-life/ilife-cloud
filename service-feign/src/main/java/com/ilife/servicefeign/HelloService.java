package com.ilife.servicefeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-hi")
public interface HelloService {
    @RequestMapping("/hi")
    String hi(@RequestParam("name") String name);
}
