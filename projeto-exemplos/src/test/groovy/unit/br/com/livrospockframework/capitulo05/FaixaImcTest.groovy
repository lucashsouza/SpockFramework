package unit.br.com.livrospockframework.capitulo05

import br.com.livrospockframework.capitulo05.enums.FaixaImc
import br.com.livrospockframework.capitulo05.enums.Sexo
import spock.lang.Specification
import spock.lang.Unroll

class FaixaImcTest extends Specification {

    def 'IMC deve estar na faixa correta'() {
        setup:
        def cenarios = [
                [imc: 18, sexo: Sexo.FEMININO, condicao: FaixaImc.ABAIXO],
                [imc: 21, sexo: Sexo.FEMININO, condicao: FaixaImc.NORMAL],
                [imc: 27, sexo: Sexo.FEMININO, condicao: FaixaImc.ACIMA],
                [imc: 20, sexo: Sexo.MASCULINO, condicao: FaixaImc.ABAIXO],
                [imc: 23, sexo: Sexo.MASCULINO, condicao: FaixaImc.NORMAL],
                [imc: 28, sexo: Sexo.MASCULINO, condicao: FaixaImc.ACIMA],
        ]

        expect:
        cenarios.each {
            assert FaixaImc.getFaixa(it.imc, it.sexo) == it.condicao
        }
    }

    def 'IMC deve estar na faixa correta com Data-Driven Testing'() {
        expect:
        FaixaImc.getFaixa(imc, sexo) == resultado

        where:
        imc   | sexo           | resultado
        18    | Sexo.FEMININO  | FaixaImc.ABAIXO
        21    | Sexo.FEMININO  | FaixaImc.NORMAL
        27    | Sexo.FEMININO  | FaixaImc.ACIMA
        20    | Sexo.MASCULINO | FaixaImc.ABAIXO
        23    | Sexo.MASCULINO | FaixaImc.NORMAL
        28    | Sexo.MASCULINO | FaixaImc.ACIMA
        18.99 | Sexo.FEMININO  | FaixaImc.ABAIXO
        19    | Sexo.FEMININO  | FaixaImc.NORMAL
        25.99 | Sexo.FEMININO  | FaixaImc.NORMAL
        26    | Sexo.FEMININO  | FaixaImc.ACIMA
        20.99 | Sexo.MASCULINO | FaixaImc.ABAIXO
        21    | Sexo.MASCULINO | FaixaImc.NORMAL
        26.99 | Sexo.MASCULINO | FaixaImc.NORMAL
        27    | Sexo.MASCULINO | FaixaImc.ACIMA
    }

    @Unroll
    def 'IMC #imc deve estar na faixa #resultado para o sexo #sexo'() {
        setup:
        expect:
        FaixaImc.getFaixa(imc, sexo) == resultado

        where:
        imc   | sexo           | resultado
        18    | Sexo.FEMININO  | FaixaImc.ABAIXO
        21    | Sexo.FEMININO  | FaixaImc.NORMAL
        27    | Sexo.FEMININO  | FaixaImc.ACIMA
        20    | Sexo.MASCULINO | FaixaImc.ABAIXO
        23    | Sexo.MASCULINO | FaixaImc.NORMAL
        28    | Sexo.MASCULINO | FaixaImc.ACIMA
        18.99 | Sexo.FEMININO  | FaixaImc.ABAIXO
        19    | Sexo.FEMININO  | FaixaImc.NORMAL
        25.99 | Sexo.FEMININO  | FaixaImc.NORMAL
        26    | Sexo.FEMININO  | FaixaImc.ACIMA
        20.99 | Sexo.MASCULINO | FaixaImc.ABAIXO
        21    | Sexo.MASCULINO | FaixaImc.NORMAL
        26.99 | Sexo.MASCULINO | FaixaImc.NORMAL
        27    | Sexo.MASCULINO | FaixaImc.ACIMA
    }

    def 'IMC deve estar na faixa correta com Given-When-Then (GWT)'() {
        when:
        def calculo = new Object() {
            def getFaixa(imc, sexo) {
                FaixaImc.getFaixa(imc, sexo)
            }
        }

        then:
        calculo.getFaixa(imc, sexo) == resultado

        where:
        imc   | sexo           | resultado
        18    | Sexo.FEMININO  | FaixaImc.ABAIXO
        21    | Sexo.FEMININO  | FaixaImc.NORMAL
        27    | Sexo.FEMININO  | FaixaImc.ACIMA
        20    | Sexo.MASCULINO | FaixaImc.ABAIXO
        23    | Sexo.MASCULINO | FaixaImc.NORMAL
        28    | Sexo.MASCULINO | FaixaImc.ACIMA
        18.99 | Sexo.FEMININO  | FaixaImc.ABAIXO
        19    | Sexo.FEMININO  | FaixaImc.NORMAL
        25.99 | Sexo.FEMININO  | FaixaImc.NORMAL
        26    | Sexo.FEMININO  | FaixaImc.ACIMA
        20.99 | Sexo.MASCULINO | FaixaImc.ABAIXO
        21    | Sexo.MASCULINO | FaixaImc.NORMAL
        26.99 | Sexo.MASCULINO | FaixaImc.NORMAL
        27    | Sexo.MASCULINO | FaixaImc.ACIMA
    }
}
