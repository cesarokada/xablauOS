package br.com.xablau;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

    private double tamanho;

    private List<TrechoMemoria> memoria = new ArrayList<TrechoMemoria>();

    public List<Processo> processos = new ArrayList<Processo>();

    public Memoria(double tamanho) {
        this.tamanho = tamanho;
        this.memoria.add(new TrechoMemoria(tamanho));
    }

    public void addProcesso(Processo processo) {
        TrechoMemoria trecho = getEspacoDisponivel(processo.getTamanho());
        if (trecho == null) {
            return;
        }

        trecho.getTamanho() - processo.getTamanho();

        this.processos.add(processo);
    }

    public void removeProcesso(Processo processo) {
        memoriaDisponivel += processo.getTamanho();
        this.processos.remove(processo);
    }

    public TrechoMemoria getEspacoDisponivel(double tamanhoProcesso) {
        for (TrechoMemoria trecho : memoria) {
            if (trecho.isDisponivel() && trecho.getTamanho() >= tamanhoProcesso)
                return trecho;
        }

        return null;
    }

}