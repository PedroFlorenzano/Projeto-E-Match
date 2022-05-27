package Objetos;

public class Produto {

    private Integer id_produto;
    private String nome;
    private Float preco_custo;
    private Float preco_venda;
    private String tamanho_camisa;
    private String descricao;

    public Integer getId_produto() {
        return id_produto;
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

    public Float getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(Float preco_custo) {
        this.preco_custo = preco_custo;
    }

    public Float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
