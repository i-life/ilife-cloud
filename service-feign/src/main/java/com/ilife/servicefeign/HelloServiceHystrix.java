package com.ilife.servicefeign;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystrix implements HelloService {
    @Override
    public String hi(String name) {
        return "Sorry " + name;
    }
}
