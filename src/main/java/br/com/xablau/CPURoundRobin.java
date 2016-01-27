package br.com.xablau;

import java.util.ListIterator;

public class CPURoundRobin extends CPU {

    public CPURoundRobin(Memory memory) {
		super(memory);
	}

	@Override
    public long executeProcesses() throws InterruptedException {
    	long executionTime = 0;
        long averageTime = calculateAverageTime();

        ListIterator<Process> i = this.processes.listIterator();
        while (!this.processes.isEmpty()) {
            if (!i.hasNext()) {
                i = this.processes.listIterator();
            }

            Process process = i.next();
            
            if (!this.memory.containsProcess(process)) {
            	try {
            		this.memory.addProcess(process);
            	} catch (OutOfMemoryError e) {
            		// TODO
            	}
            }
            
            process.changeStatus(ProcessEvent.SCHEDULER_DISPATCH);
            
            executionTime += process.run(averageTime);

            if (process.isFinished()) {
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
