package com.fluke.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
@Order(2)
public class AdtorpInterceptor extends HandlerInterceptorAdapter{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("request uri {}", request.getRequestURL());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		log.info("response status {}", response.getStatus());
		List<String> headersName = (List<String>) response.getHeaderNames();
		for (String h : headersName) {
			log.info("response header {} value {}", h, response.getHeader(h).toString());
		}
		super.postHandle(request, response, handler, modelAndView);
	}

}
