package com.mypractice.soapadapterapiintegration;

import com.mypractice.soapadapterapiintegration.client.CalculatorClient;
import com.mypractice.soapadapterapiintegration.webservercie.wsdl.Add;
import com.mypractice.soapadapterapiintegration.webservercie.wsdl.AddResponse;
import com.mypractice.soapadapterapiintegration.webservercie.wsdl.Subtract;
import com.mypractice.soapadapterapiintegration.webservercie.wsdl.SubtractResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapAdapterApiIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapAdapterApiIntegrationApplication.class, args);
	}
	@Bean
	CommandLineRunner lookup(CalculatorClient quoteClient) {
		return args -> {
			Add add = new Add();
			add.setIntA(10);
			add.setIntB(20);
			AddResponse response = quoteClient.getResult( new AddResponse() , add, "http://tempuri.org/Add");
			System.out.println(response.getAddResult());
			Subtract subtract = new Subtract();
			subtract.setIntA(20);
			subtract.setIntB(10);
			SubtractResponse response1 =   quoteClient.getResult( new SubtractResponse(), subtract,"http://tempuri.org/Subtract" );
			System.out.println(response1.getSubtractResult());
		};
	}
}
