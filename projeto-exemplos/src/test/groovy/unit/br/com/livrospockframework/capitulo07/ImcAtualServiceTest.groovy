package unit.br.com.livrospockframework.capitulo07

import br.com.livrospockframework.capitulo07.model.ResultadoImc

import javax.persistence.TypedQuery
import javax.persistence.EntityManager

import br.com.livrospockframework.capitulo07.entity.ImcAtual
import br.com.livrospockframework.capitulo07.services.ImcAtualService
import spock.lang.Specification

class ImcAtualServiceTest extends Specification {

    String nomeEncontrado = 'Zé Cadastrado'
    String nomeNaoEncontrado1 = 'João Não Cadastrado'
    String nomeNaoEncontrado2 = 'Maria Não Cadastrada'

    EntityManager entityManager
    ImcAtualService service

    def setup() {
        this.entityManager = Mock(EntityManager)

        def resultadoEncontrado = Mock(TypedQuery)
        def resultadoNaoEncontrado = Mock(TypedQuery)
        def instrucaoConsulta = Mock(TypedQuery)

        resultadoEncontrado.getSingleResult() >> new ImcAtual(nome: this.nomeEncontrado)

        instrucaoConsulta.setParameter(0, this.nomeEncontrado) >> resultadoEncontrado
        instrucaoConsulta.setParameter(0, this.nomeNaoEncontrado1) >> resultadoNaoEncontrado
        instrucaoConsulta.setParameter(0, this.nomeNaoEncontrado2) >> resultadoNaoEncontrado

        this.entityManager.createQuery(ImcAtualService.CONSULTA_IMC, ImcAtual.class) >> instrucaoConsulta

        this.service = new ImcAtualService(entityManager: this.entityManager)
    }

    def 'deve retornar null ou o ImcAtual por nome'() {
        expect:
        !this.service.imcExistente(this.nomeNaoEncontrado1)
        !this.service.imcExistente(this.nomeNaoEncontrado2)
        this.service.imcExistente(this.nomeEncontrado)?.getNome() == this.nomeEncontrado
    }

    def 'Deve inserir somente se ainda não existe'(){
        when:
        def resultadoE2 = [
                new ResultadoImc(nome: nomeEncontrado, imc: 25),
                new ResultadoImc(nome: nomeNaoEncontrado1, imc: 29),
                new ResultadoImc(nome: nomeNaoEncontrado2, imc: 35),
        ]

        def resultadoE1 = [
                new ResultadoImc(nome: nomeEncontrado, imc: 25),
                new ResultadoImc(nome: nomeNaoEncontrado1, imc: 29)
        ]

        def resultadoE0 = [
                new ResultadoImc(nome: nomeEncontrado, imc: 25)
        ]

        then:
        this.service.registrarImc(resultadoE2) == 2
        this.service.registrarImc(resultadoE1) == 1
        this.service.registrarImc(resultadoE0) == 0
    }

}