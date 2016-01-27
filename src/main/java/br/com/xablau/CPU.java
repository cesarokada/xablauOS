package br.com.xablau;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CPU {
	protected List<Process> processes = new ArrayList<Process>();
	protected Memory memory;

	public CPU(Memory memory) {
		this.memory = memory;
	}

	public void addProcess(Process process) {
		process.changeStatus(ProcessEvent.ADMITED);
		processes.add(process);
	}

	public long executeProcesses() throws InterruptedException {
		long executionTime = 0;

		ListIterator<Process> i = processes.listIterator();

		while (i.hasNext()) {
			Process process = i.next();

			try {
				memory.addProcess(process);
				process.changeStatus(ProcessEvent.SCHEDULER_DISPATCH);
			} catch (OutOfMemoryError e) {
				// TODO fazer essa merda
			}

			executionTime += process.run();
			
			i.remove();
		}

		return executionTime;
	}
}
