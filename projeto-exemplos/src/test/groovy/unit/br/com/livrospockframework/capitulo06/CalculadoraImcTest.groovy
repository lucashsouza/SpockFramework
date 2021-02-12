package unit.br.com.livrospockframework.capitulo06

import br.com.livrospockframework.capitulo06.CalculadoraImc
import spock.lang.Specification

class CalculadoraImcTest extends Specification{

    def 'lançar exceção com peso inválido v1'(){
        when:
        boolean houveExcecao

        try{
            new CalculadoraImc().calcularImc(0, 1.70)
            houveExcecao = false;
        } catch (IllegalArgumentException e) {
            houveExcecao = true;
        }

        then:
        houveExcecao;
    }

    def 'lançar exceção com peso inválido v2'(){
        when:
        new CalculadoraImc().calcularImc(0, 1.70)

        then:
        thrown(IllegalArgumentException)
    }

}
