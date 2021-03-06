package com.bytexcite.verisign.controller;

import co.aspirasoft.apis.rest.HttpMethod;
import co.aspirasoft.apis.rest.HttpTask;
import com.bytexcite.verisign.model.entity.*;
import com.bytexcite.verisign.util.WebServer;

import java.net.MalformedURLException;


/**
 * VerificationController allows sending a VerificationRequest to the web server and receiving
 * an VerificationResponse in response.
 *
 * @author saifkhichi96
 * @version 1.0
 * @see VerificationRequest
 * @see VerificationResponse
 */
public class RegistrationController {

    private final WebServer server = new WebServer();

    public RegistrationController() throws MalformedURLException {
    }

    public HttpTask<RegistrationRequest, RegistrationResponse> getRegistrationRequest(
            String customerID, SignatureImage[] refSigns) {
        RegistrationRequest request = new RegistrationRequest(customerID, refSigns[0], refSigns[1], refSigns[2], refSigns[3]);

        HttpTask.Builder<RegistrationRequest, RegistrationResponse> builder = new HttpTask.Builder<>(RegistrationResponse.class);
        builder.setMethod(HttpMethod.POST);
        builder.setPayload(request);
        builder.setRequestUrl("RegistrationController.php");
        return builder.create(server);
    }
}