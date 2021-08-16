package br.com.blog.commons.controller;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.blog.commons.Constants;
import br.com.blog.commons.repositories.IBaseRepository;
import br.com.blog.commons.services.IBaseService;
import br.com.blog.dto.BaseEntityDTO;
import br.com.blog.entities.BaseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface IBaseController<E extends BaseEntity, D extends BaseEntityDTO, K extends Serializable, R extends IBaseRepository<E, K>, C extends IBaseService<E, K, R>> {

	C getService();
	
	D toDto(E entity);
	List<D> toDto(List<E> list);
	E toEntity(D dto);
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = { Constants.APPLICATION_JSON_UTF_8 })
	@Operation(summary = "Retorna a lista de registros.", description = "Listar todos os dados.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Registros listados com sucesso"),
			@ApiResponse(responseCode = "400", description = "Erro na obtenção dos dados ou filtro"),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	ResponseEntity<List<D>> findAll();

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces = { Constants.APPLICATION_JSON_UTF_8 })
	@Operation(summary = "Adiciona um novo registro.", description = "Será gravado no banco de dados um novo registro.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Registro criado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Não foi possível cadastrar o registro."),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	ResponseEntity<D> create(
			@Parameter(description = "Registro a ser adicionado. Não pode ser nulo ou vazio.", required = true) @Valid @RequestBody D object);

	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = "/{id}", produces = { Constants.APPLICATION_JSON_UTF_8 })
	@Operation(summary = "Atualizar um registro", description = "Atualiza um registro existente.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado."),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	ResponseEntity<D> update(
			@Parameter(description = "O registro a ser atualizado.", required = true) @Valid @RequestBody D object,
			@Parameter(description = "Id do registro a ser atualizado. Não pode ser vazio.", required = true) K id);

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/{id}", produces = { Constants.APPLICATION_JSON_UTF_8 })
	@Operation(summary = "Obter um registro pelo id.", description = "Retorna um registro.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Registro carregado com sucesso."),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado."),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	ResponseEntity<D> find(
			@Parameter(description = "O id do registro a ser obtido. Não pode ser vazio.", required = true) K id);

	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping(value = "/{id}", produces = { Constants.APPLICATION_JSON_UTF_8 })
	@Operation(summary = "Deleta um registro.", description = "Remove o registro da base de dados.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Registro deletado com sucesso"),
			@ApiResponse(responseCode = "404", description = "Registro não encontrado."),
			@ApiResponse(responseCode = "500", description = "Erro interno do servidor") })
	ResponseEntity<Object> delete(
			@Parameter(description = "Id do registro a ser deletado. Não pode ser vazio.", required = true) K id);

}
