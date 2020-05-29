package com.etoak.service;

import javax.jws.WebService;

//在接口和实现类上必须加上@WebService
@WebService
public interface HelloService {
    String sayHello(String name);
}
