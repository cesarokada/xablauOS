package br.com.xablau;

public class Process {
	private long time;
	private long timeLeft;
	private double tamanho;
	private int priority;

	private ProcessStatus status;

	public Process() {

	}

	public Process(long time, double tamanho, int priority) {
		this.time = time;
		this.tamanho = tamanho;
		this.priority = priority;
		this.timeLeft = time;
		this.status = ProcessStatus.NEW;
	}

	public long run() throws InterruptedException {
		return run(this.getTime());
	}

	public long run(long time) throws InterruptedException {
		if (((int) Math.random()) * 10 == 7) {
			System.out.println("Deadlock!");
			return 0;
		}

		System.out.println("Iniciando execução");
		Thread.sleep(time);
		System.out.println("Processo finalizado.");

		decreaseTimeLeft(time);

		return time;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public long getTime() {
		return time;
	}

	public long getTimeLeft() {
		return timeLeft;
	}

	public double getTamanho() {
		return tamanho;
	}

	public int getPriority() {
		return priority;
	}

	public ProcessStatus getStatus() {
		return status;
	}

	private void decreaseTimeLeft(long time) {
		this.timeLeft = Math.max(this.timeLeft - time, 0);
		
		if (this.timeLeft == 0) {
			changeStatus(ProcessEvent.EXIT);
		}
	}

	public boolean isRunning() {
		return this.status == ProcessStatus.RUNNING;
	}

	public boolean isFinished() {
		return this.status == ProcessStatus.TERMINATED;
	}

	public void changeStatus(ProcessEvent event) {
		this.status = event.nextStatus(this.status);
	}

}
