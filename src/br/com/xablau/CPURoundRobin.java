package br.com.xablau;

import java.util.List;
import java.util.ListIterator;

public class CPURoundRobin extends CPU {
    public CPURoundRobin(List<Processo> processes) {
        super(processes);
    }

    @Override
    public void executeProcesses() throws InterruptedException {
        long media = calculateAverageTime();

        ListIterator<Processo> i = this.processes.listIterator();
        while (!this.processes.isEmpty()) {
            if (!i.hasNext()) {
                i = this.processes.listIterator();
            }

            Processo processo = i.next();
            processo.run(media);

            if (processo.isFinished())
                i.remove();
        }
    }

    private long calculateAverageTime() {
        long totalTime = 0;
        for (Processo process : this.processes) {
            totalTime += process.getTime();
        }

        return totalTime / this.processes.size();
    }
}
