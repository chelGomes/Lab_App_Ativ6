package br.ufjf.dcc196.chelgomes.filmes;

public class ListaFilmes {
    private String titulo;
    private String ano;
    private String estilo;
    private String diretor;
    private String assitistido;
    private int filmes;


    public ListaFilmes(String titulo, String ano, String estilo, String diretor, String assitistido) {
        this.titulo = titulo;
        this.ano = ano;
        this.estilo = estilo;
        this.diretor = diretor;
        this.assitistido = assitistido;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getAssitistido() {
        return assitistido;
    }

    public void setAssitistido(String assitistido) {
        this.assitistido = assitistido;
    }


    public void incrementa() {
        this.filmes++;
    }
}
