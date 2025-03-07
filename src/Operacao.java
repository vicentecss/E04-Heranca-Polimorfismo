import java.util.Date;

public class Operacao {
    private Date data;
    private char tipo;
    private double valor;
    public static double totalOperacoes = 0; // Tive que declarar como double pra não dar problema na hora de calcular a média


    public Operacao(char tipo, double valor) {
        setTipo(tipo);
        setValor(valor);
        setData();
        Operacao.totalOperacoes++;
    }

    // Getters e Setters

    public Date getData() {
        return this.data;
    }

    public void setData(){
        this.data = new Date();
    }

    public char getTipo() {
        return this.tipo;
    }

    public void setTipo(char tipo){
        this.tipo = tipo;
    }

    public double getValor(){
        return this.valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    // Método que imprime os dados do extrato no devido lugar

    void imprimeExtrato() {
        System.out.println(this.getData() + "\t" + this.getTipo() + "\t" + this.getValor()); ;
    }
}