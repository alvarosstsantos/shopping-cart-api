package br.com.letscode.service.emprestimo;


import br.com.letscode.model.Cliente;
import br.com.letscode.model.Emprestimo;
import br.com.letscode.model.Livro;
import br.com.letscode.repository.ClienteRepository;
import br.com.letscode.repository.EmprestimoRepository;
import br.com.letscode.repository.LivroRepository;
import br.com.letscode.service.emprestimo.calculation.CalculaEmprestimoDecorator;
import br.com.letscode.service.emprestimo.calculation.CalculaMultaAtrasoEmprestimo;
import br.com.letscode.service.emprestimo.calculation.CalculaValorBaseEmprestimo;
import br.com.letscode.service.emprestimo.validation.ValidaEmprestimo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository = null;
    private ClienteRepository clienteRepository = null;
    private LivroRepository livroRepository = null;
    private static EmprestimoService emprestimoService = null;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, ClienteRepository clienteRepository, LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.clienteRepository = clienteRepository;
        this.livroRepository = livroRepository;
    }

    public static EmprestimoService getInstance(EmprestimoRepository emprestimoRepository, ClienteRepository clienteRepository, LivroRepository livroRepository)
    {
        if (emprestimoService == null)
            emprestimoService = new EmprestimoService(emprestimoRepository, clienteRepository, livroRepository);

        return emprestimoService;
    }

    public void realizarEmprestimo(String email, Long codigoLivro, Integer prazo, List<ValidaEmprestimo> validacoes) {
        Cliente cliente = clienteRepository.get(email);
        Livro livro = livroRepository.get(codigoLivro);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setCliente(cliente);
        emprestimo.setLivro(livro);
        emprestimo.setInicio(LocalDateTime.now());
        emprestimo.setPrazo(prazo);

        for (ValidaEmprestimo validacao : validacoes) {
            validacao.validar(emprestimo);
        }

        emprestimoRepository.save(emprestimo);
    }


    public void devolverLivros(Long codigoEmprestimo) {
        Emprestimo emprestimo = emprestimoRepository.get(codigoEmprestimo);

        CalculaEmprestimoDecorator calculaEmprestimoDecorator = new CalculaMultaAtrasoEmprestimo(
                                                                    new CalculaValorBaseEmprestimo(emprestimo));

        BigDecimal valor = calculaEmprestimoDecorator.calcular();
        emprestimo.setValor(valor);

        emprestimoRepository.save(emprestimo);

        List<Emprestimo> emprestimosAtrasados = emprestimoRepository.getAtrasadoByClienteId(emprestimo.getCliente().getId());

        if (emprestimosAtrasados.size() >= 3) {
            Cliente cliente = emprestimo.getCliente();

            cliente.setFimBloqueio(LocalDateTime.now().plusMonths(1L));
        }

    }

}
