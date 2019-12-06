package Compiladores_Backend;

public class Variavel {
    private String id;
    private Tipos tipo;
    private int tamanho;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
