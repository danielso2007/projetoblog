package br.com.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.blog.dto.PerfilDTO;
import br.com.blog.entities.Perfil;

@Mapper(componentModel = "spring")
public interface PerfilMapper {

	PerfilMapper INSTANCE = Mappers.getMapper(PerfilMapper.class);
	
	public Perfil toEntity(PerfilDTO dto);

	public void toEntity(PerfilDTO dto, @MappingTarget Perfil entity);

	public PerfilDTO toDTO(Perfil entity);
}
