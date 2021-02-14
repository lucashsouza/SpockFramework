package br.com.livrospockframework.capitulo07;

import br.com.livrospockframework.capitulo05.enums.FaixaImc;
import br.com.livrospockframework.capitulo07.model.PedidoImc;
import br.com.livrospockframework.capitulo07.model.ResultadoImc;

public class CalculadoraImc {

    public double calcularImc(double peso, double altura){
        if (peso <= 0){
            throw new IllegalArgumentException("Peso inválido: " + peso);
        }

        if (altura <= 0){
            throw  new IllegalArgumentException("Altura inválida: " + altura);
        }

        return peso / (altura * altura);
    }

    public ResultadoImc verificarCondicaoImc(PedidoImc pedido){
        ResultadoImc resultado = new ResultadoImc();
        resultado.setNome(pedido.getNome());

        try{
            double imc = this.calcularImc(pedido.getPeso(), pedido.getAltura());
            resultado.setImc(imc);
            resultado.setCondicao(FaixaImc.getFaixa(imc, pedido.getSexo()).getDescricao());
        } catch (IllegalArgumentException e){
            resultado.setCondicao("Impossível calcular IMC: " + e.getMessage());
        }
        return resultado;
    }
}