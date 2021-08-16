package br.com.blog.security;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = 3913978313448699122L;

	private static final Log logger = LogFactory.getLog(JwtAuthenticationEntryPoint.class);
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
		logger.error("Acesso negado. Você deve estar autenticado no sistema para acessar a URL solicitada.");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Acesso negado. Você deve estar autenticado no sistema para acessar a URL solicitada.");
	}

}

