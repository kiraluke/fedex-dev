package com.ascending.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;


@WebFilter(filterName = "logFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class LogFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
    private final List<String> excludedWords = Arrays.asList("newPasswd", "confirmPasswd", "passwd", "password");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String logInfo = logInfo(req);
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info(logInfo.replace("responseTime",String.valueOf(System.currentTimeMillis()- startTime)));
    }

    private String logInfo(HttpServletRequest req) {
            String formData = null;
            String httpMethod = req.getMethod();

            Date startDateTime = new Date();
            String requestURL = req.getRequestURI();
            String userIP = req.getRemoteHost();
            String sessionID = req.getSession().getId();
            Enumeration<String> parameterNames = req.getParameterNames();
            List<String> parameters = new ArrayList();
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                if (isIgnoredWord(paramName, excludedWords)) continue;
                String paramValues = Arrays.asList(req.getParameterValues(paramName)).toString();
                parameters.add(paramName + "=" + paramValues);
            }
            if (!parameters.isEmpty()) {
                formData = parameters.toString().replaceAll("^.|.$", "");
            }
            return  new StringBuilder("| ")
                    .append(formatter.format(startDateTime)).append(" | ")
                    .append(userIP).append(" | ")
                    .append(httpMethod).append(" | ")
                    .append(requestURL).append(" | ")
                    .append(sessionID).append(" | ")
                    .append("responseTime ms").append(" | ")
                    .append(formData).toString();
    }
    private boolean isIgnoredWord(String word, List<String> excludedWords) {
        for (String excludedWord : excludedWords) {
            if (word.toLowerCase().contains(excludedWord)) return true;
        }
        return false;
    }


    @Override
    public void destroy() {

    }
}
