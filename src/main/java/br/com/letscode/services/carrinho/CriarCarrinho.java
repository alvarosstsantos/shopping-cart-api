package br.com.letscode.services.carrinho;


import br.com.letscode.models.Carrinho;
import br.com.letscode.models.Cliente;
import br.com.letscode.repositories.CarrinhoRepository;
import br.com.letscode.repositories.ClienteRepository;

public class CriarCarrinho {
    private final CarrinhoRepository carrinhoRepository;
    private final ClienteRepository clienteRepository;
    private static CriarCarrinho criarCarrinho = null;

    public CriarCarrinho(CarrinhoRepository carrinhoRepository, ClienteRepository clienteRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.clienteRepository = clienteRepository;
    }

    public static CriarCarrinho getInstance(CarrinhoRepository carrinhoRepository, ClienteRepository clienteRepository) {
        if (criarCarrinho == null)
            criarCarrinho = new CriarCarrinho(carrinhoRepository, clienteRepository);

        return criarCarrinho;
    }

    public Carrinho execute(Long codigoCliente) {
        Cliente cliente = clienteRepository.get(codigoCliente);

        Carrinho carrinho = new Carrinho();
        carrinho.setCliente(cliente);

        return carrinhoRepository.save(carrinho);
    }
}
