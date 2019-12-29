package cn.tyrone.sca.account.service;

@org.apache.dubbo.config.annotation.Service
public class AccountServiceImpl implements IAccountService {

    public Object register(String name) {
        return name;
    }

}
