package unit.br.com.livrospockframework.capitulo03

import spock.lang.Specification

class MathTest extends Specification {
    def '2 ao quadrado deve ser 4'() {
        expect:
        Math.pow(2, 2) == 4
    }

    def 'sqrt deve calcular a raiz quadrada'() {
        expect:
        Math.sqrt(4) == 2
        Math.sqrt(25) == 5
        Math.sqrt(144) == 12
    }

/*  Teste que falha por exceção

    def '2 ao quadrado deve ser 4'(){
        expect:
        Math.pow((1/0), 2) == 4             // java.lang.ArithmeticException: Division by zero
    }

    def '2 ao quadrado deve ser 4'(){
        Double base = null
        expect:
        Math.pow(base.intValue(), 2) == 4   // java.lang.NullPointerException:
    }

    Teste que não passa em uma verificação

    def '2 ao quadrado deve ser 4'() {
        expect:
        Math.pow(2, 2) == 5
    }
*/
}