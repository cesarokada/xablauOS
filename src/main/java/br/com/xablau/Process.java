package br.com.xablau;

public class Process {
	private long time;
	private long timeLeft;
	private double tamanho;
	private int priority;
	private String description;

	private ProcessStatus status;

	public Process() {

	}

	public Process(long time, double tamanho, int priority, String description) {
		this.time = time;
		this.tamanho = tamanho;
		this.priority = priority;
		this.timeLeft = time;
		this.description = description;
		this.status = ProcessStatus.NEW;
	}

	public long run() throws InterruptedException {
		return run(this.getTime());
	}

	public long run(long time) throws InterruptedException {
		//Simula randomicamente alguma situação de deadlock
		
		if ((int) (Math.random() * 100) == 4) {
			throw new InterruptedException("Deadlock!");
		}

		System.out.println("Processo " + description + " em execução");
		Thread.sleep(time);

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
			System.out.println("Processo " + description + " finalizado.");
		} else {
			System.out.println("Processo " + description + " interrompido após " + time + " ms.");
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
