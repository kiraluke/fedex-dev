//package com.ascending.filter;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
//@WebFilter(filterName = "logFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
//public class Log2Filter implements Filter {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException { }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//     long startTime = System.currentTimeMillis();
//     logger.info("preprocessing");
//        filterChain.doFilter(request,response);
//        long endTime = System.currentTimeMillis();
//        logger.info("postProcessing");
//    }
//
//    @Override
//    public void destroy() { }
//}
