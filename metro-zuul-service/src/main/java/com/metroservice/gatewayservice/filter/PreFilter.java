package com.metroservice.gatewayservice.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {

	@Override
	public String filterType() {
		System.out.println("PreFilter:::::::::::::::::::filterType");
		return "pre";
	}

	@Override
	public int filterOrder() {
		System.out.println("PreFilter:::::::::::::::::::filterOrder");
		return 0;
	}

	public boolean shouldFilter() {
		System.out.println("PreFilter:::::::::::::::::::shouldFilter");
		return true;
	}

	public Object run() {
		System.out.println("PreFilter:::::::::::::::::::run");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		System.out.println(
				"Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());

		return null;
	}

}