package br.com.xablau;

public enum ProcessStatus {
	NEW, READY, RUNNING, WAITING, TERMINATED;
	
	public ProcessStatus next(ProcessEvent event) {
		return event.nextStatus(this);
	}
}
