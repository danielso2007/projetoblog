package br.com.blog.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.commons.controller.impl.BaseController;
import br.com.blog.commons.response.Response;
import br.com.blog.controller.UsuarioController;
import br.com.blog.dto.UsuarioDTO;
import br.com.blog.entities.Usuario;
import br.com.blog.mapper.UsuarioMapper;
import br.com.blog.repositories.UsuarioRepository;
import br.com.blog.services.UsuarioService;

@RestController
public class UsuarioControllerImpl extends BaseController<Usuario, UsuarioDTO, Long, UsuarioRepository, UsuarioService>
		implements UsuarioController {

	@Autowired
	UsuarioMapper mapper;

	@Autowired
	protected UsuarioControllerImpl(UsuarioService service) {
		super(service);
	}

	@Override
	public UsuarioDTO toDto(Usuario entity) {
		return mapper.toDTO(entity);
	}

	@Override
	public List<UsuarioDTO> toDto(List<Usuario> list) {
		return list.stream().map(v -> mapper.toDTO(v)).collect(Collectors.toList());
	}

	@Override
	public Usuario toEntity(UsuarioDTO dto) {
		return mapper.toEntity(dto);
	}

	@Override
	public ResponseEntity<Object> registration(HttpServletRequest request, @Valid @RequestBody UsuarioDTO usuarioDTO,
			BindingResult result) {
		Response<String> response = new Response<>();
		try {
			getService().criarNovoUsuario(usuarioDTO);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			response.data("Erro no cadastro do usuário.");
			response.getErrors().add(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

}
