package com.bytexcite.verisign.model.dao;

import co.aspirasoft.apis.rest.HttpTask;
import com.bytexcite.verisign.model.entity.Credentials;
import com.bytexcite.verisign.model.entity.Staff;
import com.bytexcite.verisign.util.WebServer;

import java.net.MalformedURLException;

/**
 * StaffDao is a data-access class for Staff entity which allows retrieval
 * of Staff objects from the web server.
 *
 * @author saifkhichi96
 * @version 1.0
 */
public class StaffDao {

    private final WebServer server = new WebServer();

    public StaffDao() throws MalformedURLException {
    }

    public HttpTask<Credentials, Staff> getFetchRequest(String username, String password) {
        return new HttpTask.Builder<Credentials, Staff>(Staff.class)
                .setRequestUrl("route.php?controller=LoginController&action=login")
                .setPayload(new Credentials(username, password))
                .create(server);
    }

}