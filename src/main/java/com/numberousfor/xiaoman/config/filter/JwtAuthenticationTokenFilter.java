package com.numberousfor.xiaoman.config.filter;

import com.numberousfor.xiaoman.utils.ip.AddressUtils;
import com.numberousfor.xiaoman.utils.ip.IpUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cuddly
 * @data 2020/9/24
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String ipAddr = IpUtils.getIpAddr(request);
        System.out.println(ipAddr);
        String address = AddressUtils.getRealAddressByIp(ipAddr);
        System.out.println(address);
        filterChain.doFilter(request, response);
    }

}
