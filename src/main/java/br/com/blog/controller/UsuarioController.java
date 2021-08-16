package br.com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.blog.commons.Constants;
import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.UsuarioDTO;
import br.com.blog.entities.Usuario;
import br.com.blog.repositories.UsuarioRepository;
import br.com.blog.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@ExposesResourceFor(Usuario.class)
@RequestMapping(Constants.USUARIO)
@Tag(name = "Usuário", description = "Os usuário da API")
public interface UsuarioController
		extends IBaseController<Usuario, UsuarioDTO, Long, UsuarioRepository, UsuarioService> {

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/novo", produces = { Constants.APPLICATION_JSON_UTF_8 })
	@Operation(summary = "Criar um novo usuário.", description = "Endereços para criar novos usuários.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
			@ApiResponse(responseCode = "400", description = "Erro na obtenção dos dadoss"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	ResponseEntity<Object> registration(HttpServletRequest request, @Valid @RequestBody UsuarioDTO usuarioDTO,
			BindingResult result);
}
