package br.com.xablau;

/**
 * Created by cesar on 08/01/16.
 */
public class TrechoMemoria {
    private double tamanho;
    private Processo processo;

    public TrechoMemoria(Processo processo) {
        this.tamanho = processo.getTamanho();
        this.processo = processo;
    }

    public TrechoMemoria(double tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isDisponivel() {
        return processo == null;
    }

    public double getTamanho() {
        return tamanho;
    }

    public Processo getProcesso() {
        return processo;
    }
}
