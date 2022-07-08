package br.com.letscode.main;

import br.com.letscode.enums.TipoLivro;
import br.com.letscode.model.Cliente;
import br.com.letscode.model.Livro;
import br.com.letscode.repository.*;
import br.com.letscode.service.emprestimo.EmprestimoService;
import br.com.letscode.service.emprestimo.validation.*;

import java.util.ArrayList;
import java.util.List;

public class app {
    // PRECISO CRIAR UM @Injects E @Injectable
    private static final EmprestimoRepository emprestimoRepository = EmprestimoInMemoryRepository.getInstance();
    private static final ClienteRepository clienteRepository = ClienteInMemoryRepository.getInstance();
    private static final LivroRepository livroRepository = LivroInMemoryRepository.getInstance();
    private static final EmprestimoService emprestimoService = EmprestimoService.getInstance(emprestimoRepository, clienteRepository, livroRepository);

    public static void main(String[] args) {

        // PRECISO CRIAR UM @AutoIncrements PARA CERTOS @Ids
        // SALVANDO UM CLIENTE JÁ QUE NÃO TEM CienteService
        ClienteRepository clienteRepository = ClienteInMemoryRepository.getInstance();
        Cliente cliente = new Cliente();
        cliente.setNome("Jorge");
        cliente.setEmail("teste@mail.com");
        cliente.setTelefone("111111111");
        clienteRepository.save(cliente);

        // SALVANDO UM LIVRO JÁ QUE NÃO TEM LivroService
        // Salvando 1 livro em memória
        LivroRepository livroRepository = LivroInMemoryRepository.getInstance();
        Livro livro = new Livro();
        livro.setAutor("Abelardo");
        livro.setDisponivel(true);
        livro.setTipo(TipoLivro.CULINARIA);
        livro.setTitulo("Larica Total");
        livroRepository.save(livro);

        List<ValidaEmprestimo> validacoesEmprestimo = new ArrayList<>();
        validacoesEmprestimo.add(new ValidaClienteNaoEstaBloqueado());
        validacoesEmprestimo.add(new ValidaNumeroMaximoEmprestimosPorCliente(emprestimoRepository));
        validacoesEmprestimo.add(new ValidaInformacoesClienteEstaoPresentes());
        validacoesEmprestimo.add(new ValidaPrazoMaximoDevolucaoEmprestimo());

        // PRECISA DEVOLVER A ENTIDADE PERSISTIDA
        // BUG DE MUTIPLOS BLOQUEIOS CONSECUTIVOS
        emprestimoService.realizarEmprestimo("teste@mail.com", 1L, 15, validacoesEmprestimo);
        emprestimoService.devolverLivros(1L);
    }
}
