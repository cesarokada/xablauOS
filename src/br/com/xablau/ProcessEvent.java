package br.com.xablau;

public enum ProcessEvent {
	
	ADMITED(ProcessStatus.NEW, ProcessStatus.READY), 
	SCHEDULER_DISPATCH(ProcessStatus.READY, ProcessStatus.RUNNING), 
	INTERRUPT(ProcessStatus.RUNNING, ProcessStatus.READY), 
	IO_WAIT(ProcessStatus.RUNNING, ProcessStatus.WAITING), 
	IO_COMPLETE(ProcessStatus.WAITING, ProcessStatus.READY), 
	EXIT(ProcessStatus.RUNNING, ProcessStatus.TERMINATED);
	
	private ProcessStatus validStatus;
	private ProcessStatus nextStatus;

	ProcessEvent(ProcessStatus validStatus, ProcessStatus nextStatus) {
		this.validStatus = validStatus;
		this.nextStatus = nextStatus;
	}

	public ProcessStatus nextStatus(ProcessStatus currentStatus) {
		if (this.validStatus == currentStatus) {
			return this.nextStatus;
		} else {
			throw new RuntimeException("Invalid status");
		}
	}
}
