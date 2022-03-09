/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrapper;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * An extension for the HTTPServletRequest that overrides the getUserPrincipal()
 * and isUserInRole(). We supply these implementations here, where they are not
 * normally populated unless we are going through the facility provided by the
 * container.
 * <p>
 * If he user or roles are null on this wrapper, the parent request is consulted
 * to try to fetch what ever the container has set for us. This is intended to
 * be created and used by the UserRoleFilter.
 *
 * @author thein
 *
 */
public class UserRoleRequestWrapper extends HttpServletRequestWrapper {

    private final String user;
    private String role = null;
    private final HttpServletRequest realRequest;

    public UserRoleRequestWrapper(String user, String role, HttpServletRequest request) {
        super(request);
        this.user = user;
        this.role = role;
        this.realRequest = request;
    }

    @Override
    public boolean isUserInRole(String role) {
        if (role == null) {
            return this.realRequest.isUserInRole(role);
        }
        return role.equals(role);
    }

    @Override
    public Principal getUserPrincipal() {
        if (this.user == null) {
            return realRequest.getUserPrincipal();
        }

        // Make an anonymous implementation to just return our user
        return () -> user;
    }
}
