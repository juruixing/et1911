package com.etoak;

import com.etoak.service.HelloService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class CxfClient {
    public static void main(String[] args) {
        //JaxWsProxyFactoryBean
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        //设置wsdl地址
        factory.setAddress("http://localhost:8000/hello?wsdl");
        //服务接口
        factory.setServiceClass(HelloService.class);
        //创建远程服务器
        HelloService service = (HelloService) factory.create();
        System.out.println(service);
        System.out.println(service.sayHello("CXF"));
    }
}
