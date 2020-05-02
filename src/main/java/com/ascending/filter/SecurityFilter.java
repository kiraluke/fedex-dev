package com.ascending.filter;

import com.ascending.model.User;
import com.ascending.service.JWTService;
import com.ascending.service.UserService;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebFilter(filterName = "securityFilter",urlPatterns = {"/*"},dispatcherTypes = {DispatcherType.REQUEST})
public class SecurityFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;
    @Autowired
    private JWTService jwtService;
    private static String LOGIN_URI ="/auth/login";
    private static String SIGNUP_URI = "/auth/signup";
//    private static String[] AUTH_URI = {"/auth/login","/auth/signup"};
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        if(logger == null){
//
//        }
        HttpServletRequest req = (HttpServletRequest)request;
        int statusCode = authorization(req);
        if(statusCode == HttpServletResponse.SC_ACCEPTED) filterChain.doFilter(request,response);
        else ((HttpServletResponse)response).sendError(statusCode);
    }

    @Override
    public void destroy() {
    }
    private int authorization(HttpServletRequest req){
        int statusCode = HttpServletResponse.SC_UNAUTHORIZED;
        String uri = req.getRequestURI();
        String verb = req.getMethod();
        if(uri.equalsIgnoreCase(SIGNUP_URI)|| uri.equalsIgnoreCase(LOGIN_URI))return HttpServletResponse.SC_ACCEPTED;

        try{
        String token = req.getHeader("Authorization").replaceAll("^(.*?) ","");
        if(token ==null||token.isEmpty()) return statusCode;

        Map<String, Object> mapToken = new HashMap<>();
        mapToken.put("token", token);
        Claims claims = jwtService.decodeJwtToken(mapToken);

        if(claims.getId()!=null){
            User u = userService.getUserById(Long.valueOf(claims.getId()));
            if(u==null) return statusCode;
        }
            String allowedResources = "/";
            switch(verb) {
                case "GET"    : allowedResources = (String)claims.get("allowedReadResources");   break;
                case "POST"   : allowedResources = (String)claims.get("allowedCreateResources"); break;
                case "PUT"    : allowedResources = (String)claims.get("allowedUpdateResources"); break;
                case "DELETE" : allowedResources = (String)claims.get("allowedDeleteResources"); break;
            }
            for (String s : allowedResources.split(",")) {
                if (uri.trim().toLowerCase().startsWith(s.trim().toLowerCase())) {
                    statusCode = HttpServletResponse.SC_ACCEPTED;
                    break;
                }
            }
            logger.debug(String.format("Verb: %s, allowed resources: %s", verb, allowedResources));
        }
        catch (Exception e) {
            logger.error("can't verify the token",e);
        }
        return statusCode;
    }
}
