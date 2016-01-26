package br.com.xablau;

import java.util.Date;

public class TrechoMemoria {
    private double tamanho;
    private Process processo;
    private Date created;
    private Date lastUse;

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
    
    public Date getCreated() {
		return created;
	}
    
    public Date getLastUse() {
		return lastUse;
	}
    
    public void use() {
    	this.lastUse = new Date();
    }
    
    public void atribuirProcesso(Process processo) {
    	this.processo = processo;
    	this.tamanho = processo.getTamanho();
    	this.created = new Date();
    	this.lastUse = new Date();
    }

	public void liberaMemoria() {
		this.processo = null;
		this.created = null;
	}
}
