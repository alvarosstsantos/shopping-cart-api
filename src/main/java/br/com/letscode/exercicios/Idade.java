package br.com.letscode.exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Idade {
    private static final LocalDate dataAtual = LocalDate.now();

    public void calcular(Map<String, String> datasDeNascimento) {
        Locale locale = new Locale("pt", "BR");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String firstDataDeNascimentoKey = (String) datasDeNascimento.keySet().toArray()[0];
        LocalDate parsedFirstDataDeNascimento = parseDataDeNascimento(datasDeNascimento.remove(firstDataDeNascimentoKey));

        // Existe tupla em java?
        Map<String, LocalDate> maisNovo = new HashMap<>();
        Map<String, LocalDate> maisVelho = new HashMap<>();
        maisNovo.put(firstDataDeNascimentoKey, parsedFirstDataDeNascimento);
        maisVelho.put(firstDataDeNascimentoKey, parsedFirstDataDeNascimento);

        for (Map.Entry<String, String> dataDeNascimento: datasDeNascimento.entrySet()) {
            LocalDate parsedDataDeNascimento = parseDataDeNascimento(dataDeNascimento.getValue());

            String diaDaSemana = parsedDataDeNascimento.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
            int idade = (int) ChronoUnit.YEARS.between(parsedDataDeNascimento, dataAtual);

            System.out.println(dataDeNascimento.getKey() + "-" + parsedDataDeNascimento.format(formatter) + "-" + diaDaSemana + "-" + idade + "anos");

            if (ChronoUnit.DAYS.between(maisNovo.))
        }
    }

    private LocalDate parseDataDeNascimento(String dataDeNascimento) {
        LocalDate parsedDataDeNascimento = LocalDate.parse("20" + dataDeNascimento);

        if (parsedDataDeNascimento.getYear() > dataAtual.getYear()) {
            parsedDataDeNascimento = LocalDate.parse("19" + dataDeNascimento);
        }

        return parsedDataDeNascimento;
    }

    public static void main(String[] args) {
        Idade i = new Idade();

        Map<String, String> is = new HashMap<>();
        is.put("Roberto", "21-07-08");
        is.put("Ricardo", "20-07-08");

        i.calcular(is);
    }
}

