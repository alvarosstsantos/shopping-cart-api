package br.com.letscode.main;


import br.com.letscode.enums.OrigemDados;
import br.com.letscode.services.dados.DataProviderService;

public class app {
    public static void main(String[] args) {
        DataProviderService.getData(OrigemDados.MEMORIA).getClienteRepository();
        DataProviderService.getData(OrigemDados.MEMORIA).getProdutoRepository();
        DataProviderService.getData(OrigemDados.MEMORIA).getCarrinhoRepository();

    }
}
