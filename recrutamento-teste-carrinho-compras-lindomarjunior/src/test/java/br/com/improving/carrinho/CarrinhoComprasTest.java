package br.com.improving.carrinho;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

public class CarrinhoComprasTest {

	@Test
	public void testAdicionarItem() {
		CarrinhoComprasFactory CarrinhoComprasFactory = new CarrinhoComprasFactory();
		String identificacaoCliente = "Joao";
		CarrinhoCompras carrinhoCompras = CarrinhoComprasFactory.criar(identificacaoCliente);
		
		Produto produto1 = new Produto(1l, "Sabão");						
		carrinhoCompras.adicionarItem(produto1, new BigDecimal("15.31"), 2);
		
		List<Item> listaItem = (List<Item>) carrinhoCompras.getItens();
		Item item = null;
		try {
			item = listaItem.get(0);
		} catch (Exception e) {
			fail(e.getMessage());
		}

		assertNotNull(item);
	}

	@Test
	public void testRemoverItem() {
		CarrinhoComprasFactory CarrinhoComprasFactory = new CarrinhoComprasFactory();
		String identificacaoCliente = "Joao";
		CarrinhoCompras carrinhoCompras = CarrinhoComprasFactory.criar(identificacaoCliente);
		
		Produto produto1 = new Produto(1l, "Sabão");	
		
		carrinhoCompras.adicionarItem(produto1, new BigDecimal("15.31"), 2);		
		carrinhoCompras.removerItem(produto1);

		assertTrue(carrinhoCompras.getItens().isEmpty());
	}

	@Test
	public void testRemoverItemInt() {					
		CarrinhoComprasFactory CarrinhoComprasFactory = new CarrinhoComprasFactory();
		String identificacaoCliente = "Joao";
		CarrinhoCompras carrinhoCompras = CarrinhoComprasFactory.criar(identificacaoCliente);
		
		Produto produto1 = new Produto(1l, "Sabão");	
		
		carrinhoCompras.adicionarItem(produto1, new BigDecimal("15.31"), 2);		
		carrinhoCompras.removerItem(0);

		assertTrue(carrinhoCompras.getItens().isEmpty());
	}

	@Test
	public void testGetValorTotal() {
		CarrinhoComprasFactory CarrinhoComprasFactory = new CarrinhoComprasFactory();
		String identificacaoCliente = "Joao";
		CarrinhoCompras carrinhoCompras = CarrinhoComprasFactory.criar(identificacaoCliente);
		
		Produto produto1 = new Produto(1l, "Sabão");	
		Produto produto2 = new Produto(2l, "Arroz");	
		
		carrinhoCompras.adicionarItem(produto1, new BigDecimal("15.31"), 1);	
		carrinhoCompras.adicionarItem(produto2, new BigDecimal("16.31"), 1);		
		
		BigDecimal expected = new BigDecimal("31.62");
		BigDecimal actual = carrinhoCompras.getValorTotal();
		
		assertEquals(expected, actual);
	}

}
