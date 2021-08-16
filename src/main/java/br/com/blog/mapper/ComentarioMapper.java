package br.com.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.blog.dto.ComentarioDTO;
import br.com.blog.entities.Comentario;

@Mapper(componentModel = "spring")
public interface ComentarioMapper {

	ComentarioMapper INSTANCE = Mappers.getMapper(ComentarioMapper.class);
	
	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "usuario", ignore = true)
	@Mapping(target = "post", ignore = true)
	public Comentario toEntity(ComentarioDTO dto);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "usuario", ignore = true)
	@Mapping(target = "post", ignore = true)
	public void toEntity(ComentarioDTO dto, @MappingTarget Comentario entity);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	public ComentarioDTO toDTO(Comentario entity);
}
