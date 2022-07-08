package br.com.letscode.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validador {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String TELEFONE_PATTERN = "^1\\d\\d(\\d\\d)?$|^0800 ?\\d{3} ?\\d{4}$|^"
            + "(\\(0?([1-9a-zA-Z][0-9a-zA-Z])?[1-9]\\d\\) ?|0?([1-9a-zA-Z]"
            + "[0-9a-zA-Z])?[1-9]\\d[ .-]?)?(9|9[ .-])?[2-9]\\d{3}[ .-]?\\d{4}$";

    private static final List<String> CPFSINVALIDOS = Collections.unmodifiableList(new ArrayList<String>() {
        {
            add("00000000000");
            add("11111111111");
            add("22222222222");
            add("33333333333");
            add("44444444444");
            add("55555555555");
            add("66666666666");
            add("77777777777");
            add("88888888888");
            add("99999999999");
        }
    });

    private static final List<String> CNPJSINVALIDOS = Collections.unmodifiableList(new ArrayList<String>() {
        {
            add("00000000000000");
            add("11111111111111");
            add("22222222222222");
            add("33333333333333");
            add("44444444444444");
            add("55555555555555");
            add("66666666666666");
            add("77777777777777");
            add("88888888888888");
            add("99999999999999");
        }
    });

    private static boolean validaPorRegex(String campo, String campoRegex) {

        final Pattern campoPattern = Pattern.compile(campoRegex, Pattern.CASE_INSENSITIVE);

        Matcher matcher = campoPattern.matcher(campo);
        return matcher.matches();
    }

    public static String tratarValor(String valor) {
        return valor.trim().replaceAll("[^0-9]", "");
    }

    public static String tratarNome(String nome) {
        return Stream.of(nome.trim().split(" "))
                .filter(n -> n.length() > 0)
                .map(n -> n.substring(0, 1).toUpperCase() + n.substring(1))
                .collect(Collectors.joining(" "));

    }

    private static boolean validaDigitoCpf(String cpf, int digitoAValidar) {
        int soma = calculaSomaDigitoCpf(cpf, digitoAValidar) % 11;
        char digito;
        if ((soma == 0) || (soma == 1)) {
            digito = '0';
        } else {
            digito = (char) ((11 - soma) + 48);
        }

        if (digito != cpf.charAt(digitoAValidar)) {
            return false;
        }

        return true;
    }

    private static int calculaSomaDigitoCpf(String cpf, int digitoAValidar) {
        int soma = 0;
        int peso = digitoAValidar + 1;

        for (int i = 0; i < digitoAValidar; i++) {
            soma += (int) (cpf.charAt(i) - 48) * peso;
            peso -= 1;
        }

        return soma;
    }

    private static boolean validaDigitoCnpj(String cnpj, int digitoAValidar) {
        int soma = calculaSomaDigitoCnpj(cnpj, digitoAValidar) % 11;
        char digito;
        if ((soma == 0) || (soma == 1)) {
            digito = '0';
        } else {
            digito = (char) ((11 - soma) + 48);
        }

        if (digito != cnpj.charAt(digitoAValidar)) {
            return false;
        }

        return true;
    }

    private static int calculaSomaDigitoCnpj(String cnpj, int digitoAValidar) {
        int soma = 0;
        int peso = 2;

        for (int i = digitoAValidar - 1; i >= 0; i--) {
            soma += (int) (cnpj.charAt(i) - 48) * peso;
            peso += 1;
            if (peso == 10) {
                peso = 2;
            }
        }

        return soma;
    }

    public static boolean validaCnpj(String cnpj) {
        String cnpjTratado = tratarValor(cnpj);

        for (String cnpjInvalido : CNPJSINVALIDOS) {
            if (cnpjInvalido.equals(cnpjTratado)) {
                return false;
            }
        }

        if (cnpjTratado.length() != 14) {
            return false;
        }

        if (validaDigitoCnpj(cnpjTratado, 12) && validaDigitoCnpj(cnpjTratado, 13)) {
            return true;
        }

        return false;
    }

    public static boolean validaCpf(String cpf) {
        String cpfTratado = tratarValor(cpf);

        for (String cpfInvalido : CPFSINVALIDOS) {
            if (cpfInvalido.equals(cpfTratado)) {
                return false;
            }
        }

        if (cpfTratado.length() != 11) {
            return false;
        }

        if (validaDigitoCpf(cpfTratado, 9) && validaDigitoCpf(cpfTratado, 10)) {
            return true;
        }

        return false;
    }

    public static boolean validaTelefone(String telefone)  {
        if (!validaPorRegex(telefone, TELEFONE_PATTERN)) {
            return false;
        }
        return true;
    }

    public static boolean validaEmail(String email)  {
        if (!validaPorRegex(email, EMAIL_PATTERN)) {
            return false;
        }
        return true;
    }

}
