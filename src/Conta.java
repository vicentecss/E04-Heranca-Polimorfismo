public class Conta {

    private int numero;
    private Cliente dono;
    private double saldo;
    private double limite;
    private Operacao[] operacoes = new Operacao[1000];
    private int qntOperacoes = 0;         // Contador auxiliar para salvar a posição de cada transação no array Operacao
    public static double totalContas = 0; // Tive que declarar como double pra não dar problema na hora de calcular a média


    // Método construtor da classe Conta

        Conta(int numero, Cliente dono, double saldo, double limite) {
        setNumero(numero);
        setDono(dono);
        setSaldo(saldo);
        setLimite(limite);
        Conta.totalContas++;
    }

    // Getters e setters

    public Cliente getDono(){
        return this.dono;
    }

    public void setDono(Cliente dono){
        this.dono = dono;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public double getSaldo (){
        return this.saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public double getLimite(){
        return this.limite;
    }

    public void setLimite (double limite){
        if (limite < 0) {
            this.limite = 0;
        } else {
            this.limite = limite;
        }
    }


    // Método para sacar um valor de uma conta

    public void sacar (double valor) {
        if (this.saldo > 0 && valor <= saldo && valor > 0) {
            this.saldo = saldo - valor;
            System.out.println("Saque de " + valor + " realizado com sucesso!");

            if (this.qntOperacoes < 1000) {
            this.operacoes[qntOperacoes] = new OperacaoSaque(valor);
            this.qntOperacoes++;
            } else {
                System.out.println("Numero de operacoes excedido!");
            }


        } else {
            System.out.println("Erro ao tentar sacar o valor de " + valor);
        }
        System.out.println("Saldo atual da conta de " + getDono().getNome() + ": " + getSaldo()); 

    }

    // Método para depositar um valor em uma conta.

    public void depositar (double valor) {

        if (valor > 0) {
            this.saldo += valor;
            System.out.println(valor + " depositado com sucesso!");
            System.out.println("Saldo atual da conta de " + getDono().getNome() + ": " + getSaldo());

            if (this.qntOperacoes < 1000) {
            this.operacoes[qntOperacoes] = new OperacaoDeposito(valor);
            this.qntOperacoes++;
            } else {
                System.out.println("Numero de operacoes excedido!");
            }

        } else {
            System.out.println("Erro ao realizar o depósito!");
        }
    }


    // Método para transferir um valor de uma conta para outra.

    public void transferir (Conta destino, double valor) {

        if (valor < 0 && valor > this.saldo) {
            System.out.println("Não foi possível realizar a transferência.");
        }

        if (valor <= this.saldo) {
            this.saldo -= valor;
            destino.saldo += valor;
            System.out.println("Valor transferido da conta de " + getDono().getNome() + " para a conta de " + getDono().getNome() + ": " + valor);
            System.out.println("Saldo atual da conta de " + getDono().getNome() + ": " + getSaldo());
            System.out.println("Saldo atual da conta de " + getDono().getNome() +  ": " + destino.saldo);   
        } else {
            System.out.println("Não foi possível realizar a transação.");
        }

    }

    // Método que calcula quais e quantas operações foram realizadas na conta

    public void extrato(){
        int i;
        
        for (i = 0; i < this.qntOperacoes; i++) {
            Operacao x = this.operacoes[i];
            x.imprimeExtrato();
        }

    }
}