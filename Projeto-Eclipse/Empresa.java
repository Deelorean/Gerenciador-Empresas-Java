package PROJETOA3;

public class Empresa {
    private int id; // Identificador único da empresa
    private String nome; // Nome da empresa
    private String cnpj; // CNPJ da empresa
    private int quantidadeFuncionarios; // Quantidade de funcionários da empresa
    private String nomeGerente; // Nome do gerente responsável pela empresa
    private String areaAtuacao; // Área de atuação da empresa

    public Empresa(String nome, String cnpj, int quantidadeFuncionarios, String nomeGerente, String areaAtuacao) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.nomeGerente = nomeGerente;
        this.areaAtuacao = areaAtuacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }
    
    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    @Override
    public String toString() {
        return "[ID: " + id + " NOME: " + nome + " CNPJ: " + cnpj + " FUNCIONÁRIOS: "
                + quantidadeFuncionarios + " ATUAÇÃO: " + areaAtuacao + " GERENTE: " + nomeGerente + "]";
    }
    
}