package com.example.algamoneyapi.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.env.ConfigurableEnvironment;

public class RecursoCriadoEvent extends ApplicationEvent {


	private static final long serialVersionUID = 1L;
	
	private HttpServletResponse response;
	private Long codigo;
	
	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.response = response;
		this.codigo = codigo;
		
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCodigo() {
		return codigo;
	}
	
	

	
}
