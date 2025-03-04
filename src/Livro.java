public class Livro {
    private String nome;
    private String genero;
    private int anoLancamento;

    public Livro() {
    }
    public Livro(String nome, String genero, int anoLancamento) {
        this.nome = nome;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome
                + ", Genêro: " + genero
                + ", Ano de lançamento: " + anoLancamento
                ;
    }
}
