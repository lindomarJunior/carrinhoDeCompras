package br.com.improving.carrinho;

import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    /**
     * Construtor da classe Item.
     * 
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
    	this.produto = produto;
    	this.valorUnitario = valorUnitario;
    	this.quantidade = quantidade;
    }
    
    /**
     * Segundo construtor da classe Item utilizado para manipular 
     * itens existentes no carrinho.
     * 
     * @param produto
     */
    public Item(Produto produto) {
    	this.produto = produto;
    }

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
    	return this.produto;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
    	return this.valorUnitario;
    }

    /**
     * Recebe e atribui valor unitário
     * 
     * @param valorUnitario
     */
    public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	/**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public int getQuantidade() {
    	return this.quantidade;
    }
    
    /**
     * Efetua a soma da quantidade de produtos do item
     * 
     * @param quantidade
     * @throws IllegalArgumentException
     */
    public void somarQuantidade(int quantidade) throws IllegalArgumentException{
    	if(quantidade == 0) {
    		throw new IllegalArgumentException("quantidade não pode ser 0.");
    	}else {
    		this.quantidade += quantidade;
    	}    	
    }

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
    	return this.valorUnitario.multiply(BigDecimal.valueOf(this.quantidade));
    }    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [produto=" + produto.getCodigo() + ", valorUnitario=" + valorUnitario + ", quantidade="
				+ quantidade + "]";
	}
	
}
