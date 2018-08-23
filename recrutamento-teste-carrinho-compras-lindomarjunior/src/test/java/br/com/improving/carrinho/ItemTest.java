package br.com.improving.carrinho;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class ItemTest {

	@Test
	public void testGetValorTotal() {		
		Produto produto1 = new Produto(1l, "Sabão");				
		Item item1 = new Item(produto1, new BigDecimal("15.31"), 2);		
		item1.getValorTotal();
		
		BigDecimal expected = new BigDecimal("30.62");
		BigDecimal actual = item1.getValorTotal().setScale(2, RoundingMode.HALF_EVEN);
		assertEquals(expected, actual);
	}

}
