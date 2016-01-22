package br.com.xablau;

import java.util.ListIterator;

public class CPURoundRobin extends CPU {
    public CPURoundRobin() {
    }

    @Override
    public long executeProcesses() throws InterruptedException {
    	long executionTime = 0;
        long media = calculateAverageTime();

        ListIterator<Process> i = this.processes.listIterator();
        while (!this.processes.isEmpty()) {
            if (!i.hasNext()) {
                i = this.processes.listIterator();
            }

            Process processo = i.next();
            executionTime += processo.run(media);

            if (processo.isFinished())
                i.remove();
        }
        
        return executionTime;
    }

    private long calculateAverageTime() {
        long totalTime = 0;
        for (Process process : this.processes) {
            totalTime += process.getTime();
        }

        return totalTime / this.processes.size();
    }
}
