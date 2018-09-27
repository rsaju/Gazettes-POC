package com.springcloudtutorials.ZuulServer.ZuulFilters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class TestZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //return whether pre,route,post or error
        return null;
    }

    @Override
    public int filterOrder() {
        //return the order in which to execute filters
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //whether or not use the filter
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        //this should contatin the filter logic and can return null
        return null;
    }
}
