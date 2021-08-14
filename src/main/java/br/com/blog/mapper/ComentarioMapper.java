package br.com.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.blog.dto.ComentarioDTO;
import br.com.blog.entities.Comentario;

@Mapper
public interface ComentarioMapper {

	ComentarioMapper INSTANCE = Mappers.getMapper(ComentarioMapper.class);
	
	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "usuario", ignore = true)
	@Mapping(target = "post", ignore = true)
	public Comentario toComentario(ComentarioDTO dto);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "usuario", ignore = true)
	@Mapping(target = "post", ignore = true)
	public void toComentario(ComentarioDTO dto, @MappingTarget Comentario entity);

	public ComentarioDTO toComentarioDTO(Comentario entity);
}
