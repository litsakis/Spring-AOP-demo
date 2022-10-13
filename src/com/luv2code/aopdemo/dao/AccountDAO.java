package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;
	
	public void addAccount() {
		
		 
			System.out.println(getClass() + ":DOING MY DB WORK: ADDING AN ACCOUNT");
			
			
		 
		
	}

	public String getName() {
		System.out.println(getClass() + ":DOING MY DB WORK: getName()");

		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ":DOING MY DB WORK: getName()");

		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ":DOING MY DB WORK: getServiceCode");

		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ":DOING MY DB WORK: setServiceCode");

		this.serviceCode = serviceCode;
	}
	
	
}
