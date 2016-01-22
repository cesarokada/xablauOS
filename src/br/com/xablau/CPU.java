package br.com.xablau;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CPU {
	protected List<Process> processes = new ArrayList<Process>();

	public CPU() {
	}
	
	public void addProcess(Process process) {
		processes.add(process);
	}

	public long executeProcesses() throws InterruptedException {
		long executionTime = 0;

		ListIterator<Process> i = processes.listIterator();

		while (i.hasNext()) {
			Process process = i.next();
			executionTime += process.run();

			i.remove();
		}

		return executionTime;
	}
}
