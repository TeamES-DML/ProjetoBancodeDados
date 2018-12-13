package negocio.entidade;


public class Servico {

	private String tipoOperacao; /* Compra (comprar para a loja algum produto), Venda (Vendendo um produto),
	Reparo (exclusivo de peca, pois podemos reparar uma peca sem precisar vender uma nova*/
	private Produto produto;
	private DataSimples dataServico;
	private double precoServico;
	private boolean concluido;
	private String descricao;
	private static int contadorServico = 0;
	private int id = 0;
	/*
	Contrutor recebendo operacao, veiculo e produto. Como recebe veiculo, entao nao pode ser compra.
	Dentro do contrutor e feita uma checagem se o tipo de operacao e reparo, pois o unico tipo q possui reparo e peca,
	e entao precisara usar casting para atribuir o preco do reparo ao atributo PRECOSERVICO
	 */
	public Servico(String operacao, Produto produto, String descricao, DataSimples data){
		this.tipoOperacao = operacao;
		this.produto = produto;
		if (this.tipoOperacao.equals("Reparo") && this.produto instanceof Peca){
			this.precoServico = ((Peca) produto).getPrecoReparo();
		}
		else if(this.tipoOperacao.equals("Instalacao") && this.produto instanceof Peca){
			this.precoServico = ((Peca) produto).getPrecoMaoDeObra();
		}
		else{
			this.precoServico = produto.getPrecoVenda();
		}
		this.descricao = descricao;
		this.concluido = false;
		this.dataServico = data;
		this.id = contadorServico;
		contadorServico++;
	}
	/*
	Construtor so com produto, logo nao tem veiculo, entao sera uma compra.
	 */
	public Servico(Produto produto, DataSimples data){
		this.tipoOperacao = "Compra";
		this.produto = produto;
		this.precoServico = this.produto.getPrecoCompra();
		this.dataServico = data;
		this.concluido = true;
		this.id = contadorServico;
		contadorServico++;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	public DataSimples getDataServico() {
		return dataServico;
	}

	public double getPrecoServico() {
		return precoServico;
	}

	public Produto getProduto() {
		return produto;
	}

	public boolean getConcluido() {
		return concluido;
	}

	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean equals(Object obj){
		if(obj instanceof Servico){
			Servico s = ((Servico) obj);
			if (s.getTipoOperacao().equals(this.tipoOperacao) && s.getProduto().getTipo() == produto.getTipo() && s.getConcluido() == this.getConcluido()){
				return true;
			}
		}
		return false;
	}

	public int getId(){
		return this.id;
	}
}
