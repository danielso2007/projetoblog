package br.com.blog.security.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.commons.Constants;
import br.com.blog.commons.response.Response;
import br.com.blog.entities.Usuario;
import br.com.blog.security.jwt.JwtAuthenticationRequest;
import br.com.blog.security.model.CurrentUser;
import br.com.blog.security.util.JwtTokenUtil;
import br.com.blog.services.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(Constants.AUTH)
@CrossOrigin(origins = "*")
@Tag(name = "Authentication", description = "A autenticação da API")
public class AuthenticationController {

	private final Log logger = LogFactory.getLog(AuthenticationController.class);

	private static final String TOKEN_HEADER = "Authorization";

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) {
		logger.debug("CreateAuthenticationToken...");
		Authentication authentication = null;
		authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getEmail(), authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);
		final Optional<Usuario> user = usuarioService.findByEmail(authenticationRequest.getEmail());
		if (user.isPresent()) {
			return ResponseEntity.ok(new CurrentUser(token, user.get()));
		}
		Response<String> response = new Response<>();
		response.getErrors().add("Login ou senha inválido");
		return ResponseEntity.badRequest().body("Login ou senha inválido");
	}

	@PostMapping(value = "/refresh")
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
		String token = request.getHeader(TOKEN_HEADER);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		final Optional<Usuario> user = usuarioService.findByEmail(username);
		if (jwtTokenUtil.canTokenBeRefreshed(token) && user.isPresent()) {
			String refreshedToken = jwtTokenUtil.refreshToken(token);
			return ResponseEntity.ok(new CurrentUser(refreshedToken, user.get()));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	


}
