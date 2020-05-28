package com.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter{

private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest rq = ctx.getRequest();
		
		log.info("Entrando a posgt");
		
		Long inicio = (Long) rq.getAttribute("inicio");
		rq.setAttribute("inicio", inicio);
		Long tiempoFinal = System.currentTimeMillis();
		Long total = tiempoFinal - inicio;
		
		log.info(String.format("Final %s seg", total/1000));
		
		log.info(String.format("Final %s ms", total));
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
}
