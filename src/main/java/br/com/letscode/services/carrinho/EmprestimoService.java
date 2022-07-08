package br.com.letscode.services.carrinho;


import br.com.letscode.models.Carrinho;
import br.com.letscode.models.Cliente;
import br.com.letscode.repositories.ClienteRepository;
import br.com.letscode.repositories.CarrinhoRepository;
import br.com.letscode.repositories.ProdutoRepository;
import br.com.letscode.services.carrinho.validation.ValidaEmprestimo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class EmprestimoService {
    private CarrinhoRepository carrinhoRepository = null;
    private ClienteRepository clienteRepository = null;
    private ProdutoRepository produtoRepository = null;
    private static EmprestimoService emprestimoService = null;

    public EmprestimoService(CarrinhoRepository carrinhoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public static EmprestimoService getInstance(CarrinhoRepository carrinhoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository)
    {
        if (emprestimoService == null)
            emprestimoService = new EmprestimoService(carrinhoRepository, clienteRepository, produtoRepository);

        return emprestimoService;
    }

    public void realizarEmprestimo(String email, Long codigoLivro, Integer prazo, List<ValidaEmprestimo> validacoes) {
        Cliente cliente = clienteRepository.get(email);
        Livro livro = produtoRepository.get(codigoLivro);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setCliente(cliente);
        emprestimo.setLivro(livro);
        emprestimo.setInicio(LocalDateTime.now());
        emprestimo.setPrazo(prazo);

        for (ValidaEmprestimo validacao : validacoes) {
            validacao.validar(emprestimo);
        }

        carrinhoRepository.save(emprestimo);
    }


    public void calcularValorCarrinho(Long codigoCarrinho) {
        Carrinho carrinho = carrinhoRepository.get(codigoCarrinho);

        CalculaPrecoPorProdutoDecorator calculaPrecoPorProdutoDecorator = new CalculaPromocaoPorProduto(
                                                                    new CalculaPrecoPorProduto(carrinho));

       BigDecimal precoPorProduto = calculaPrecoPorProdutoDecorator.calcular();

        carrinhoRepository.save(emprestimo);

        List<Emprestimo> emprestimosAtrasados = carrinhoRepository.getAtrasadoByClienteId(emprestimo.getCliente().getId());

        if (emprestimosAtrasados.size() >= 3) {
            Cliente cliente = emprestimo.getCliente();

            cliente.setFimBloqueio(LocalDateTime.now().plusMonths(1L));
        }

    }

}
