package com.bytexcite.verisign.controller;

import co.aspirasoft.apis.rest.HttpMethod;
import co.aspirasoft.apis.rest.HttpTask;
import com.bytexcite.verisign.model.entity.SignatureImage;
import com.bytexcite.verisign.model.entity.VerificationRequest;
import com.bytexcite.verisign.model.entity.VerificationResponse;
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
public class VerificationController {

    private WebServer server = new WebServer();

    public VerificationController() throws MalformedURLException {
    }

    public HttpTask<VerificationRequest, VerificationResponse> getVerificationRequest(
            String customerID, SignatureImage signatureImage) {
        return new HttpTask.Builder<VerificationRequest, VerificationResponse>(VerificationResponse.class)
                .setRequestUrl("VerificationController.php")
                .setMethod(HttpMethod.POST)
                .setPayload(new VerificationRequest(customerID, signatureImage))
                .create(server);
    }
}