package com.client.clientsample;

import com.client.*;

public class ClientSample {

	public static void main(String[] args) {
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        HelloEJBBeanService service1 = new HelloEJBBeanService();
	        System.out.println("Create Web Service...");
	        HelloWS port1 = service1.getHelloEJBBeanPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port1.sayHello());
	        System.out.println("Create Web Service...");
	        HelloWS port2 = service1.getHelloEJBBeanPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port2.sayHello());
	        System.out.println("***********************");
	        System.out.println("Call Over!");
	}
}
