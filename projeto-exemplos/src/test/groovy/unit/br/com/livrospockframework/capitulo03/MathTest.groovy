package unit.br.com.livrospockframework.capitulo03
import spock.lang.Specification

class MathTest extends Specification {
    def '2 ao quadrado deve ser 4'(){
        expect:
        Math.pow(2, 2) == 4
    }

    def 'sqrt deve calcular a raiz quadrada'(){
        expect:
        Math.sqrt(4) == 2
        Math.sqrt(25) == 5
        Math.sqrt(144) == 12
    }
}