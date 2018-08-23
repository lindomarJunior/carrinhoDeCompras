package br.com.improving.carrinho;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class CarrinhoComprasFactoryTest {

	@Test
	public void testCriarNovoCarrinho() {
		CarrinhoComprasFactory CarrinhoComprasFactory = new CarrinhoComprasFactory();
		String identificacaoCliente = "Joao";
		CarrinhoCompras carrinhoCompras = null;
		carrinhoCompras = CarrinhoComprasFactory.criar(identificacaoCliente);

		assertNotEquals(null, carrinhoCompras);
	}

	@Test
	public void testGetValorTicketMedio() {		
		CarrinhoComprasFactory CarrinhoComprasFactory = new CarrinhoComprasFactory();
		String identificacaoCliente = "Joao";
		CarrinhoCompras carrinhoCompras = CarrinhoComprasFactory.criar(identificacaoCliente);
		
		Produto produto1 = new Produto(1l, "Sabão");			
		carrinhoCompras.adicionarItem(produto1, new BigDecimal("15.31"), 2);		
		
		String identificacaoCliente2 = "Maria";
		CarrinhoCompras carrinhoCompras2 = CarrinhoComprasFactory.criar(identificacaoCliente2);
		
		Produto produto2 = new Produto(2l, "Arroz");			
		carrinhoCompras2.adicionarItem(produto2, new BigDecimal("10.21"), 2);	
				
		BigDecimal expected = new BigDecimal("25.5");
		BigDecimal actual = CarrinhoComprasFactory.getValorTicketMedio();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testInvalidar() {
		CarrinhoComprasFactory CarrinhoComprasFactory = new CarrinhoComprasFactory();
		String identificacaoCliente = "Joao";
		CarrinhoCompras carrinhoCompras = CarrinhoComprasFactory.criar(identificacaoCliente);
		
		Produto produto1 = new Produto(1l, "Sabão");			
		carrinhoCompras.adicionarItem(produto1, new BigDecimal("15.31"), 2);	
		
		assertTrue(CarrinhoComprasFactory.invalidar("Joao"));
	}
}
