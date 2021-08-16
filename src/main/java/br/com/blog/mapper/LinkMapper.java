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
	public Link toLink(LinkDTO dto);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "post", ignore = true)
	public void toLink(LinkDTO dto, @MappingTarget Link entity);

	public LinkDTO toLinkDTO(Link entity);
}
