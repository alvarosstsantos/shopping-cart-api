package br.com.letscode.services.dados;


import br.com.letscode.enums.OrigemDados;

public class DataProviderService {
    private static DataProvider data = null;

    public static DataProvider getData(OrigemDados origemDados) {
        if (data == null) {
            switch (origemDados) {
                case MEMORIA:
                    return new InMemoryDataProvider();
                case ARQUIVO:
                    return new FileDataProvider();
                default:
                    throw new RuntimeException("origem dos dados invalida.");
            }        }
        return data;
    }
}
