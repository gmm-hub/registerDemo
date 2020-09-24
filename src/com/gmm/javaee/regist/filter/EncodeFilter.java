package com.gmm.javaee.regist.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "f1", urlPatterns = {"/*"}, initParams = {@WebInitParam(name = "encode", value = "UTF-8")})
public class EncodeFilter implements Filter {
    private String encode;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //处理请求集编码
        req.setCharacterEncoding(encode);
        //处理响应集编码
        resp.setContentType("text/html;charset="+encode);
        //传递过滤链
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encode = config.getInitParameter("encode");

    }

}
