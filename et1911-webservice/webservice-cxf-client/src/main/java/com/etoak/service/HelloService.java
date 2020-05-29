package com.etoak.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.18
 * 2020-05-29T16:39:11.570+08:00
 * Generated source version: 3.1.18
 * 
 */
@WebService(targetNamespace = "http://service.etoak.com/", name = "HelloService")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloService {

    @WebMethod
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://service.etoak.com/", className = "com.etoak.service.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://service.etoak.com/", className = "com.etoak.service.SayHelloResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
