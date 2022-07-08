### Intenções
* Models apenas com as informações mínimas necessárias, getterse e setters
* Services contendo as regras de negócio, um service por arquivo
* Não instanciar mais de uma vez cada Repository ou Service


### Observações
* A forma como os services para calcular o preço do carrinho foi implementada produz side effects,
a propriedades taxa, total, frete e desconto poderiam ser removidas da model de Carrinho, e o pattern
Decorator poderia ser implementada para o cálculo, porém isso não permitiria retornar de forma
 individualizada taxa, total, frete e desconto, ainda que não seja necessário persistir essas infirmações.
* ~~Não faço idéia de como refatorar o DataProviderServide e suas dependências, talvez utilizadndo o pattern Bridge
ou um Factory parada cada uma das interfaces de Repository.~~ A gambiarra está menos pior, algo como anotar os construtores
e buscar a lista de classes anotadas, para não ter que passar o nome do pacote completo em DataProvider;
* O projeto possui código reaproveitado dos dois projetos anteriores que não chegaram a ser utilizados.
* O sonho de criar uma annotation para incrementar automaticamente o valor dos Ids permanece, preciso reassistir
 a aula do Bruno novamente.
* Os serviços CalculaFreteCarrinho, CalculaTaxaCarrinho e CalculaDescontoCarrinho estão todos baseados no TipoProduto
 de cada um dos itens do carrinho. A taxa e o frete precisam ser baseados no codigoProduto. Para isso
 os services precisariam receber um Map<Long, BigDecimal> com o codigoProduto e valor da taxa/frete unitários. Não faz
 sentido essas informações estarem dentro da model Produto ou no enum TipoProduto.
* ~~Não é possível criar um método static abstract na interface Repository~~. Não foi preciso um comportamento desse tipo.