package com.reabilitare.consultorio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reabilitare.consultorio.domain.Categoria;
import com.reabilitare.consultorio.domain.Cidade;
import com.reabilitare.consultorio.domain.Estado;
import com.reabilitare.consultorio.domain.Produto;
import com.reabilitare.consultorio.repositories.CategoriaRepository;
import com.reabilitare.consultorio.repositories.CidadeRepository;
import com.reabilitare.consultorio.repositories.EstadoRepository;
import com.reabilitare.consultorio.repositories.ProdutoRepository;

@SpringBootApplication
public class ConsultorioApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
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
		
		Estado est1 = new Estado(null, "Sao Paulo");
		Estado est2 = new Estado(null, "Minas Gerais");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));		

		Cidade c1 = new Cidade(null, "Sao Paulo", est1);
		Cidade c2 = new Cidade(null, "Sao Bernado", est1);
		Cidade c3 = new Cidade(null, "Uberlandia", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
	}

}
