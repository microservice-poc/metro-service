package com.metroservice.gatewayservice.filter;

import com.netflix.zuul.ZuulFilter;

public class RouteFilter extends ZuulFilter {

	@Override
	public String filterType() {
		System.out.println("RouteFilter:::::::::::::::::::filterType");
		return "route";
	}

	@Override
	public int filterOrder() {
		System.out.println("RouteFilter:::::::::::::::::::filterOrder");
		return 0;
	}

	public boolean shouldFilter() {
		System.out.println("RouteFilter:::::::::::::::::::shouldFilter");
		return true;
	}

	public Object run() {
		System.out.println("RouteFilter:::::::::::::::::::run");

		return null;
	}

}