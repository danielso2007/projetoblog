package br.com.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.blog.dto.UsuarioDTO;
import br.com.blog.entities.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
	
	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "ultimoAcesso", ignore = true)
	@Mapping(target = "enabled", ignore = true)
	@Mapping(target = "posts", ignore = true)
	@Mapping(target = "albuns", ignore = true)
	@Mapping(target = "comentarios", ignore = true)
	@Mapping(target = "perfis", ignore = true)
	@Mapping(target = "authorities", ignore = true)
	@Mapping(target = "password", ignore = true)
	public Usuario toEntity(UsuarioDTO dto);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "ultimoAcesso", ignore = true)
	@Mapping(target = "enabled", ignore = true)
	@Mapping(target = "posts", ignore = true)
	@Mapping(target = "albuns", ignore = true)
	@Mapping(target = "comentarios", ignore = true)
	@Mapping(target = "perfis", ignore = true)
	@Mapping(target = "authorities", ignore = true)
	@Mapping(target = "password", ignore = true)
	public void toEntity(UsuarioDTO dto, @MappingTarget Usuario entity);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "ultimoAcesso", ignore = true)
	@Mapping(target = "password", ignore = true)
	public UsuarioDTO toDTO(Usuario entity);
}
