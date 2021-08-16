package br.com.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.blog.dto.PostDTO;
import br.com.blog.entities.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {

	PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
	
	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "usuario", ignore = true)
	@Mapping(target = "comentarios", ignore = true)
	@Mapping(target = "imagens", ignore = true)
	public Post toEntity(PostDTO dto);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "usuario", ignore = true)
	@Mapping(target = "comentarios", ignore = true)
	@Mapping(target = "imagens", ignore = true)
	public void toEntity(PostDTO dto, @MappingTarget Post entity);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	public PostDTO toDTO(Post entity);
}
