package com.reabilitare.consultorio;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reabilitare.consultorio.domain.Categoria;
import com.reabilitare.consultorio.domain.Cidade;
import com.reabilitare.consultorio.domain.Cliente;
import com.reabilitare.consultorio.domain.Endereco;
import com.reabilitare.consultorio.domain.Estado;
import com.reabilitare.consultorio.domain.Pagamento;
import com.reabilitare.consultorio.domain.PagamentoComBoleto;
import com.reabilitare.consultorio.domain.PagamentoComCartao;
import com.reabilitare.consultorio.domain.Pedido;
import com.reabilitare.consultorio.domain.Produto;
import com.reabilitare.consultorio.domain.enums.EstadoPagamento;
import com.reabilitare.consultorio.domain.enums.TipoCliente;
import com.reabilitare.consultorio.repositories.CategoriaRepository;
import com.reabilitare.consultorio.repositories.CidadeRepository;
import com.reabilitare.consultorio.repositories.ClienteRepository;
import com.reabilitare.consultorio.repositories.EnderecoRepository;
import com.reabilitare.consultorio.repositories.EstadoRepository;
import com.reabilitare.consultorio.repositories.PagamentoRepository;
import com.reabilitare.consultorio.repositories.PedidoRepository;
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
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
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
		
		Cliente cli1 = new Cliente(null, "Lucilaine de Oliveira", "lucilainefisioterapeuta@gmail.com", "25734585807", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("11951044888", "1122804501"));
		
		Endereco e1 = new Endereco(null, "rua MaxPlank", "368", "casa fundo", "Jd Coimbra", "03691100", cli1, c2 );
		Endereco e2 = new Endereco(null, "rua Tibircio", "14", "casa", "Jd Coimbra", "03691100", cli1, c1 );
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2021 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2021 11:32"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2021 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		}

}
