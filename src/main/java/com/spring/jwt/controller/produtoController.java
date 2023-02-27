package com.spring.jwt.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jwt.dto.produtosDto;
import com.spring.jwt.model.produto;
import com.spring.jwt.service.produtosService;

@RestController
@RequestMapping(value = "/produtos")
public class produtoController {

	@Autowired(required = false) 
	private produtosService service;
	private ModelMapper mapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public produtosDto cadastrarProduto(@RequestBody produtosDto ProdutosDto) {
		mapper = new ModelMapper();
		produto Produto = mapper.map(ProdutosDto, produto.class);
		produto ProdutoSalvo = service.save(Produto);
		return mapper.map(ProdutoSalvo, produtosDto.class);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<produto> buscaPorId(@PathVariable Long id) {
		return service.getById(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void apagarProduto(@PathVariable Long id) {
		service.deletarProdutos(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarProdutos(@PathVariable Long id, @RequestBody produtosDto ProdutosDto) {
		mapper = new ModelMapper();
		produto Produto = mapper.map(ProdutosDto, produto.class);
		Produto.setId(id);
		service.save(Produto);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<produto> exibirClientes() {
		return service.listarTodos();
	}

}
