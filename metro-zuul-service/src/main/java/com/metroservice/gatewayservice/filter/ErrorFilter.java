package com.metroservice.gatewayservice.filter;

import com.netflix.zuul.ZuulFilter;

public class ErrorFilter extends ZuulFilter {

	@Override
	public String filterType() {
		System.out.println("ErrorFilter:::::::::::::::::::filterType");
		return "error";
	}

	@Override
	public int filterOrder() {
		System.out.println("ErrorFilter:::::::::::::::::::filterOrder");
		return 0;
	}

	public boolean shouldFilter() {
		System.out.println("ErrorFilter:::::::::::::::::::shouldFilter");
		return true;
	}

	public Object run() {
		System.out.println("ErrorFilter:::::::::::::::::::run");

		return null;
	}

}