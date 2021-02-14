package unit.br.com.livrospockframework.capitulo07

import br.com.livrospockframework.capitulo05.enums.FaixaImc
import br.com.livrospockframework.capitulo05.enums.Sexo
import br.com.livrospockframework.capitulo07.CalculadoraImc
import br.com.livrospockframework.capitulo07.model.PedidoImc
import br.com.livrospockframework.capitulo07.model.ResultadoImc
import spock.lang.Specification

class CalculadoraImcTest extends Specification{

    def 'Deve ser um homem acima do peso'() {
        given:
        def pedido = Mock(PedidoImc)

        pedido.getNome() >> "Zé da Banca"
        pedido.getSexo() >> Sexo.MASCULINO
        pedido.getPeso() >> 72
        pedido.getAltura() >> 1.50

        when:
        def resultado = new CalculadoraImc().verificarCondicaoImc(pedido)

        then:
        resultado.imc == 32
        resultado.condicao == FaixaImc.ACIMA.descricao
    }
}
