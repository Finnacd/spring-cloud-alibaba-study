package cn.tyrone.sca.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "您好：" + string;
    }

}
