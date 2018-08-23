package br.com.improving.carrinho;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {
	
	private List<Item> listaItem = new ArrayList<Item>();
	BigDecimal valorTotal;

    /**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) throws IllegalArgumentException {   
    	validarParametros(produto, valorUnitario);
    	Item item = new Item(produto, valorUnitario, quantidade);
    	if(listaItem.contains(item)) {
			Item itemExitente = listaItem.get(listaItem.indexOf(item));
			itemExitente.somarQuantidade(quantidade);
			if(itemExitente.getValorUnitario().compareTo(valorUnitario) != 0){
				itemExitente.setValorUnitario(valorUnitario);
			}
    	}else {
    		listaItem.add(item);
    	}    	
    }

    /**
     * Permite a remoção do item que representa este produto do carrinho de compras.
     *
     * @param produto
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(Produto produto) {
    	return listaItem.remove(new Item(produto));
    }

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na 
     * coleção, em que zero representa o primeiro item.
     *
     * @param posicaoItem
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(int posicaoItem) {
    	try {
    		Item item = listaItem.remove(posicaoItem);
        	if(item != null) {
        		return true;
        	}
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
    	
    	return false;
    }

    /**
     * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
    	setValorTotal(BigDecimal.valueOf(0));
		listaItem.forEach(item -> {
			setValorTotal(valorTotal.add(item.getValorTotal()));
		});

    	return valorTotal;
    }

    /**
     * @param valorTotal
     */
    public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
     * Retorna a lista de itens do carrinho de compras.
     *
     * @return itens
     */
    public Collection<Item> getItens() {
    	return listaItem;
    }
    
    /**
     * Valida os parametros recebidos para criação de um carrinho
     * @param produto
     * @param valorUnitario
     * @throws IllegalArgumentException
     */
    private void validarParametros(Produto produto, BigDecimal valorUnitario) throws IllegalArgumentException{
    	if(produto == null) {
    		throw new NullPointerException("Produto não pode ser nulo");
    	}
    	
    	if(valorUnitario == null) {
    		throw new NullPointerException("Valor Unitário não pode ser nulo");
    	}
    }
}