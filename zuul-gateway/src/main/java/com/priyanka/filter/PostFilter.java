package com.priyanka.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PostFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		return false;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		System.out.println("PostFilter Class Method : "+request.getMethod()+" URL :"+request.getRequestURL().toString());
		return null;
	}

	@Override
	public String filterType() {
		return "Postgenerated";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
