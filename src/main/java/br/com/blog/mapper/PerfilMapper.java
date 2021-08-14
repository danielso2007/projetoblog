package br.com.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.blog.dto.PerfilDTO;
import br.com.blog.entities.Perfil;

@Mapper
public interface PerfilMapper {

	PerfilMapper INSTANCE = Mappers.getMapper(PerfilMapper.class);
	
	public Perfil toPerfil(PerfilDTO dto);

	public void toPerfil(PerfilDTO dto, @MappingTarget Perfil entity);

	public PerfilDTO toPerfilDTO(Perfil entity);
}
