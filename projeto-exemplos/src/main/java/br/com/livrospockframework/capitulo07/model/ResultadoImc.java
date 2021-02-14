package br.com.livrospockframework.capitulo07.model;

public class ResultadoImc {
    private String nome;
    private double imc;
    private String condicao;

    public ResultadoImc(String nome, double imc){
        super();
        this.nome = nome;
        this.condicao = condicao;
    }

    public ResultadoImc(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }
}
