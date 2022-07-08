package br.com.letscode.services.dados;


public enum TipoProvider {
    IN_MEMORY ("InMemory"),
    FILE ("File");

    private final String prefix;

    TipoProvider(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}