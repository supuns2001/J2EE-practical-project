package lk.jiat.app.web.servlet;

import jakarta.inject.Inject;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.jiat.app.core.exceptions.LoginFailedException;
import lk.jiat.app.core.util.Encryption;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Inject
    private SecurityContext securityContext;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        AuthenticationParameters parameters = AuthenticationParameters.withParams()
                .credential(new UsernamePasswordCredential(email, Encryption.encrypt(password)));



        AuthenticationStatus status = securityContext.authenticate(request, response, parameters);

        System.out.println("status os ;"+ status);

        if (status == AuthenticationStatus.SUCCESS) {
            System.out.println("Authentication successful");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            System.out.println("Authentication failed");
            throw new LoginFailedException("Invalid email or password");
        }


    }
}
