package com.dyd.pocdozer;

import com.dyd.pocdozer.services.ServiceClientCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PocDozerApplication {

	@Autowired
	private ServiceClientCaller clientCaller;

	public static void main(String[] args) {
		SpringApplication.run(PocDozerApplication.class, args);
	}

	@PostConstruct
	public void init() {
		System.out.println(clientCaller.getDataFromClient().toString());

		System.out.println(clientCaller.getData2FromClient().toString());
	}
}
