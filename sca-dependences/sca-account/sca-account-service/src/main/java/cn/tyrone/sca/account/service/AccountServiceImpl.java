package cn.tyrone.sca.account.service;

import org.apache.dubbo.config.annotation.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    public Object register(String name) {
        return name;
    }
}
