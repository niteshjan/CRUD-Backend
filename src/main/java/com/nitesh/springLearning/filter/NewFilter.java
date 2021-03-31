package com.nitesh.springLearning.filter;

import javax.servlet.*;
import java.io.IOException;

public class NewFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("The new Filter is called");
        chain.doFilter(request, response);
    }
}
