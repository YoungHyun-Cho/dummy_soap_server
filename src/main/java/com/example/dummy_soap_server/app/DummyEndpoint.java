package com.example.dummy_soap_server.app;

import io.spring.guides.gs_producing_web_service.CreateUserRequest;
import io.spring.guides.gs_producing_web_service.CreateUserResponse;
import io.spring.guides.gs_producing_web_service.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class DummyEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public CreateUserResponse createUser(@RequestPayload CreateUserRequest request) {
        CreateUserResponse response = new CreateUserResponse();

        UserResponse userResponse = new UserResponse();
        userResponse.setKUNNR(request.getUser().getKUNNR());
        userResponse.setNAME1(request.getUser().getNAME1());
        userResponse.setSTATUS("S");

        response.setUser(userResponse);

        return response;
    }
}
