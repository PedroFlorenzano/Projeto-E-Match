package Objetos;

public class Produto {

    private Integer id_produto;
    private String nome;
    private Float valor_custo;
    private Float valor_venda;
    private String tamanho_camisa;
    private String descricao;
    private Integer quantidade;

    public Integer getId_produto() {
        return id_produto;
    }
    
    public void setId_produto(Integer id) {
        this.id_produto = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTamanho_camisa() {
        return tamanho_camisa;
    }

    public void setTamanho_camisa(String tamanho_camisa) {
        this.tamanho_camisa = tamanho_camisa;
    }

    public Float getValor_custo() {
        return valor_custo;
    }

    public void setValor_custo(Float preco_custo) {
        this.valor_custo = preco_custo;
    }

    public Float getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(Float preco_venda) {
        this.valor_venda = preco_venda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    
}
