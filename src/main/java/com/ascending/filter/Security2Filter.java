//package com.ascending.filter;
//
//import com.ascending.model.User;
//import com.ascending.service.JWTService;
//import com.ascending.service.UserService;
//import io.jsonwebtoken.Claims;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName = "securityFilter",urlPatterns = {"/*"},dispatcherTypes = {DispatcherType.REQUEST})
//public class Security2Filter implements Filter {
//    @Autowired
//    private JWTService jwtService;
//    @Autowired
//    private UserService userService;
//    private static String IGNORED_PATHS ="/auth";
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest)request;
//        int statusCode = authorization(req);
//        if(statusCode == HttpServletResponse.SC_ACCEPTED) filterChain.doFilter(request,response);
//        else((HttpServletResponse)response).sendError(statusCode);
//    }
//    private int authorization(HttpServletRequest req){
//        int statusCode =  HttpServletResponse.SC_UNAUTHORIZED;
//        String uri = req.getRequestURI();
//        if(IGNORED_PATHS.contains(uri)) return HttpServletResponse.SC_ACCEPTED;
//
//        try{
//           String token = req.getHeader("Authorization").replaceAll("^(.*?) ","");
//           if (token ==null||token.isEmpty())return statusCode;
//
//           Claims claims = jwtService.decodeJwtToken(token);
//           if(claims.getId()!=null){
//               User u = userService.getUserById(Long.valueOf(claims.getId()));
//               if(u!=null) statusCode = HttpServletResponse.SC_ACCEPTED;
//           }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return statusCode;
//    }
//}
