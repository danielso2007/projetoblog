package br.com.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.blog.dto.LinkDTO;
import br.com.blog.entities.Link;

@Mapper(componentModel = "spring")
public interface LinkMapper {

	LinkMapper INSTANCE = Mappers.getMapper(LinkMapper.class);
	
	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "post", ignore = true)
	public Link toEntity(LinkDTO dto);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "post", ignore = true)
	public void toEntity(LinkDTO dto, @MappingTarget Link entity);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	public LinkDTO toDTO(Link entity);
}
