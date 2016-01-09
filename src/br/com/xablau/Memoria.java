package br.com.xablau;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Memoria {

    private List<TrechoMemoria> memoria = new ArrayList<TrechoMemoria>();

    public Memoria(double tamanho) {
        this.memoria.add(new TrechoMemoria(tamanho));
    }
    
    public List<TrechoMemoria> getMemoria() {
		return memoria;
	}

    public void addProcesso(Processo processo) {
        TrechoMemoria trecho = getEspacoDisponivel(processo.getTamanho());
        if (trecho == null) {
            return;
        }
        
        double espacoRestante = trecho.getTamanho() - processo.getTamanho();
        trecho.atribuirProcesso(processo);
        if (espacoRestante != 0) {
        	TrechoMemoria trechoMemoriaDisponivel = new TrechoMemoria(espacoRestante);
        	this.memoria.add(this.memoria.indexOf(trecho) + 1, trechoMemoriaDisponivel);
        }
    }

    public void removeProcesso(Processo processo) {
		ListIterator<TrechoMemoria> i = memoria.listIterator();
		
		while(i.hasNext()) {
			TrechoMemoria trecho = i.next();
			
			if (processo.equals(trecho.getProcesso())) {
				double memoriaDisponivel = trecho.getTamanho();
				
				if (i.hasPrevious()) {
					TrechoMemoria anterior = i.previous();
					if (anterior.isDisponivel()) {
						memoriaDisponivel += anterior.getTamanho();
						i.remove();
					} else {
						i.next();
					}
				}
				if (i.hasNext()) {
					TrechoMemoria proximo = i.next();
					if (proximo.isDisponivel()) {
						memoriaDisponivel += proximo.getTamanho();
						i.remove();
					} else {
						i.previous();
					}
				}
				
				i.previous();
				i.next();
				
				i.set(new TrechoMemoria(memoriaDisponivel));
			}
		}
	}

	public TrechoMemoria getEspacoDisponivel(double tamanhoProcesso) {
        for (TrechoMemoria trecho : memoria) {
            if (trecho.isDisponivel() && trecho.getTamanho() >= tamanhoProcesso)
                return trecho;
        }

        return null;
    }

    public void print() {
        for (TrechoMemoria trecho : memoria) {
        	System.out.println("Trecho de tamanho " + trecho.getTamanho() + (trecho.isDisponivel() ? "" : " não") + " disponível");
        }
        System.out.println("");
    }

}