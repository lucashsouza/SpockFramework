package unit.br.com.livrospockframework.capitulo03

import spock.lang.Specification

class CollectionsTest extends Specification{
    def 'listas devem ser iguais'() {
        expect:
        def lista1 = ['café', 'leite', 'acuçar']
        def lista2 = ['café', 'leite', 'adoçante']

        lista1 == lista2
    }

    def 'mapas devem ser iguais'(){
        expect:
        def mapa1 = [PA: 'Pará', SP: 'São Paulo', MG: 'Minas Gerais']
        def mapa2 = [DF: 'Distrito Federal', GO: 'Goiás', PR: 'Paraná']

        mapa1 == mapa2
    }

    def 'listas devem ter o mesmo tamanho'(){
        expect:
        def lista1 = ['uva', 'morango', 'amora']
        def lista2 = ['abacate', 'maça verde']

        lista1.size() == lista2.size()
    }
}
