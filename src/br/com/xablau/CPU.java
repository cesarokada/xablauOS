package br.com.xablau;

import java.util.*;

public class CPU {
    private Processo processoEmExecucao;
    protected List<Processo> processes = new ArrayList<Processo>();

    public CPU(List<Processo> processes) {
        this.processes = processes;
    }

    public void executeProcesses() throws InterruptedException {
        ListIterator<Processo> i = processes.listIterator();
        while (i.hasNext()) {
            Processo processo = i.next();
            processo.run();

            i.remove();
        }
    }
}
