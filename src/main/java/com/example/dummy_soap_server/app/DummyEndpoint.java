package com.example.dummy_soap_server.app;

import kr.co.inspien._10173.MTLegacyBTEST008010173;
import kr.co.inspien._10173.MTLegacyBTEST008010173Response;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
@RequiredArgsConstructor
public class DummyEndpoint {
    private static final String NAMESPACE_URI = "http://www.inspien.co.kr/10173";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "MT_LegacyB_TEST0080_10173")
    @ResponsePayload
    public MTLegacyBTEST008010173Response test1(@RequestPayload MTLegacyBTEST008010173 request) {

        System.out.println(request.getCUSTOM().getKUNNR());
        System.out.println(request.getCUSTOM().getNAME1());
        System.out.println(request.getCUSTOM().getTELF1());
        System.out.println(request.getCUSTOM().getADRNR());

        MTLegacyBTEST008010173Response response = new MTLegacyBTEST008010173Response();

        MTLegacyBTEST008010173Response.CUSTOM custom = new MTLegacyBTEST008010173Response.CUSTOM();
        custom.setKUNNR(request.getCUSTOM().getKUNNR());
        custom.setNAME1(request.getCUSTOM().getNAME1());
        custom.setSTATUS("S");

        response.setCUSTOM(custom);

        return response;
    }
}
