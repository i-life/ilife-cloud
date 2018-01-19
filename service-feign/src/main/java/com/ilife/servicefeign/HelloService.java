package com.ilife.servicefeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi", fallback = HelloServiceHystrix.class)
public interface HelloService {
    @RequestMapping("/hi")
    String hi(@RequestParam("name") String name);
}
