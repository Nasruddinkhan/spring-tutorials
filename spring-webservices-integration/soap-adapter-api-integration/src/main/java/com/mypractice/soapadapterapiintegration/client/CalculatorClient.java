package com.mypractice.soapadapterapiintegration.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class CalculatorClient extends WebServiceGatewaySupport {
    public <S, source,  R > S getResult(S source, R request, String soapAction) {

        return (S) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request,
                        new SoapActionCallback(soapAction));
    }
}
