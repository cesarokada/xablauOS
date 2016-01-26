package br.com.xablau;

import java.util.ListIterator;

public class CPURoundRobin extends CPU {

    public CPURoundRobin(Memory memory) {
		super(memory);
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

            Process process = i.next();
            
            if (!this.processes.contains(process)) {
            	try {
            		this.memory.addProcess(process);
            		process.changeStatus(ProcessEvent.SCHEDULER_DISPATCH);
            	} catch (OutOfMemoryError e) {
            		// TODO
            	}
            }
            
            executionTime += process.run(media);

            if (process.isFinished()) {
            	process.changeStatus(ProcessEvent.EXIT);
                i.remove();
            } else {
            	process.changeStatus(ProcessEvent.INTERRUPT);
            }
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
