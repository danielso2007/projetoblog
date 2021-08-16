package br.com.blog.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.blog.commons.lang.ValidationException;
import br.com.blog.commons.services.impl.BaseService;
import br.com.blog.dto.UsuarioDTO;
import br.com.blog.entities.Usuario;
import br.com.blog.enumerator.Roles;
import br.com.blog.repositories.PerfilRepository;
import br.com.blog.repositories.UsuarioRepository;
import br.com.blog.services.UsuarioService;

@Service
public class UsuarioServiceImpl extends BaseService<Usuario, Long, UsuarioRepository> implements UsuarioService {

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super(repository);
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		return getRepository().findByEmail(email);
	}

	@Override
	@Transactional
	public void criarNovoUsuario(UsuarioDTO usuarioDTO) {
		long emailCount = getRepository().countByEmail(usuarioDTO.getEmail());

		if (emailCount > 0) {
			throw new ValidationException("Já existe e-mail informado. Por favor, informe outro.");
		}

		Usuario usuario = new Usuario().email(usuarioDTO.getEmail()).nome(usuarioDTO.getNome())
				.senha(passwordEncoder.encode(usuarioDTO.getPassword()));

		usuario.addPerfil(perfilRepository.findByRole(Roles.USER));
		usuario.setEnabled(Boolean.TRUE);
		
		save(usuario);

		logger.info("Novo registro cadastrado com sucesso!");
	}
}
