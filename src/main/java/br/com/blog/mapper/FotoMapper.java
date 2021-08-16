package br.com.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.blog.dto.FotoDTO;
import br.com.blog.entities.Foto;

@Mapper(componentModel = "spring")
public interface FotoMapper {

	FotoMapper INSTANCE = Mappers.getMapper(FotoMapper.class);
	
	@Mapping(target = "album", ignore = true)
	public Foto toEntity(FotoDTO dto);

	@Mapping(target = "album", ignore = true)
	public void toEntity(FotoDTO dto, @MappingTarget Foto entity);

	public FotoDTO toDTO(Foto entity);
}
