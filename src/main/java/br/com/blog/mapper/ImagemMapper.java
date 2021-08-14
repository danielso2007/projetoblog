package br.com.blog.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.blog.dto.ImagemDTO;
import br.com.blog.entities.Imagem;

@Mapper
public interface ImagemMapper {

	ImagemMapper INSTANCE = Mappers.getMapper(ImagemMapper.class);
	
	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "post", ignore = true)
	public Imagem toImagem(ImagemDTO dto);

	@Mapping(target = "dataCriacao", ignore = true)
	@Mapping(target = "post", ignore = true)
	public void toImagem(ImagemDTO dto, @MappingTarget Imagem entity);

	public ImagemDTO toImagemDTO(Imagem entity);
}
