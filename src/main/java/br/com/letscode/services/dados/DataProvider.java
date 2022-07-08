package br.com.letscode.services.dados;


import br.com.letscode.repositories.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DataProvider {
    private static Map<String, Repository> repositories = new HashMap<String, Repository>();

    public static <T extends Repository> T getRepository(String repositoryName, TipoProvider tipoProvider) {
        T repository = (T) DataProvider.repositories.get(repositoryName);

        if (!Objects.isNull(repository)) {
            return repository;
        }

        try {
            Class clazz = Class.forName("br.com.letscode.repositories." + tipoProvider.getPrefix().toLowerCase() + "." + repositoryName + tipoProvider.getPrefix() + "Repository");
            repository = (T) clazz.newInstance();
            repositories.put(repositoryName, repository);

            return repository;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
