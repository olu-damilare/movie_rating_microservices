package com.slimdaddy.springbootconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RefreshScope
@RestController
public class GreetingController {

    @Value("${my.greeting: hello}")
    private String greetingMessage;

    @Value("${list.values}")
    private List<String> listValues;

    @Value("#{${db.Values}}")
    private Map<String, String> dbValues;

    @Autowired
    private DbConfig dbConfig;

    @Autowired
    private Environment env;


    @GetMapping("/greeting")
    public String greeting(){
        return greetingMessage;
    }


    @GetMapping("/envdetails")
    public String envDetails(){
        return env.toString();
    }


}
