package br.com.xablau;

/**
 * Created by cesar on 08/01/16.
 */
public class TrechoMemoria {
    private double tamanho;
    private Process processo;

    public TrechoMemoria(Process processo) {
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

    public Process getProcesso() {
        return processo;
    }
    
    public void atribuirProcesso(Process processo) {
    	this.processo = processo;
    	this.tamanho = processo.getTamanho();
    }

	public void liberaMemoria() {
		this.processo = null;
	}
}
