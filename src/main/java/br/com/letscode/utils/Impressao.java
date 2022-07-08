package br.com.letscode.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Impressao {
    public static String imprimeTelefone(String telefone) {
        if (telefone.length() == 11) {
            return "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 7) + " - " + telefone.substring(7, 11);
        }
        else {
            return "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 6) + " - " + telefone.substring(6, 10);
        }
    }

    public static String imprimeCpf(String cpf) {
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
    }

    public static String imprimeCnpj(String cnpj) {
        return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-"
                + cnpj.substring(12, 14);

    }

    public static String imprimeMoeda(BigDecimal valor) {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valor);
    }
}
