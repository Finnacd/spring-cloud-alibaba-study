package cn.tyrone.sca.account.consumer.controller;

import cn.tyrone.sca.account.service.IAccountService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class AccountConsumerController {


    @Autowired private RestTemplate restTemplate;

    @Reference private IAccountService accountService;

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return restTemplate.getForObject("http://sca-account-service/echo/" + str, String.class);
    }

    @GetMapping("/register")
    public Object register(String name){
        Object object = accountService.register(name);
        return object;
    }

}
