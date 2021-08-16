package br.com.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.blog.dto.AlbumDTO;
import br.com.blog.entities.Album;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

	AlbumMapper INSTANCE = Mappers.getMapper(AlbumMapper.class);
	
	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "usuario", ignore = true)
	@Mapping(target = "fotos", ignore = true)
	public Album toEntity(AlbumDTO dto);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "usuario", ignore = true)
	@Mapping(target = "fotos", ignore = true)
	public void toEntity(AlbumDTO dto, @MappingTarget Album entity);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "dataAtualizacao", ignore = true)
	public AlbumDTO toDTO(Album entity);
}
