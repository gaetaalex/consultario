package com.reabilitare.consultorio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reabilitare.consultorio.domain.Categoria;
import com.reabilitare.consultorio.domain.Produto;
import com.reabilitare.consultorio.repositories.CategoriaRepository;
import com.reabilitare.consultorio.repositories.ProdutoRepository;

@SpringBootApplication
public class ConsultorioApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsultorioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Fisio");
		Categoria cat2 = new Categoria(null,"Estetica");
		
		Produto p1 = new Produto(null, "Drenagem", 100.00);
		Produto p2 = new Produto(null, "Fisioterapia", 100.00);
		Produto p3 = new Produto(null, "Piling", 100.00);
		
		cat2.getProdutos().addAll(Arrays.asList(p1, p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat2));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
	}

}
