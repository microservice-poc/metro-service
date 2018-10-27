package com.metroservice.gatewayservice.filter;

import com.netflix.zuul.ZuulFilter;

public class PostFilter extends ZuulFilter {

	@Override
	public String filterType() {
		System.out.println("PostFilter:::::::::::::::::::filterType");
		return "post";
	}

	@Override
	public int filterOrder() {
		System.out.println("PostFilter:::::::::::::::::::filterOrder");
		return 0;
	}

	public boolean shouldFilter() {
		System.out.println("PostFilter:::::::::::::::::::shouldFilter");
		return true;
	}

	public Object run() {
		System.out.println("PostFilter:::::::::::::::::::run");

		return null;
	}

}