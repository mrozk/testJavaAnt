package com.aplant.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TestWebService {
	
	private String message = new String("Hello, ");

    public void Hello() {}
	
    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}
