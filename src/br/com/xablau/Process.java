package br.com.xablau;

public class Process {
	private long time;
	private long timeLeft;
	private double tamanho;
	private int priority;

	public Process() {

	}

	public Process(long time, double tamanho, int priority) {
		this.time = time;
		this.tamanho = tamanho;
		this.priority = priority;
		this.timeLeft = time;
	}

	public long run() throws InterruptedException {
		System.out.println("Iniciando execução");
		Thread.sleep(this.getTime());
		System.out.println("Processo finalizado.");

		return this.getTime();
	}

	public long run(long time) throws InterruptedException {
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

	public void setTime(long time) {
		this.time = time;
	}

	public long getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(long timeLeft) {
		this.timeLeft = timeLeft;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	private void decreaseTimeLeft(long time) {
		this.timeLeft = Math.max(this.timeLeft - time, 0);
	}

	public boolean isFinished() {
		return this.timeLeft == 0;
	}
}
