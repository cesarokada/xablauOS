package br.com.xablau;

public class Processo {
    private long time;
    private double tamanho;

    public Processo(long time, double tamanho) {
        this.time = time;
        this.tamanho = tamanho;
    }

    public void run() throws InterruptedException {
        System.out.println("Iniciando execução");
        Thread.sleep(time);
        System.out.println("Processo finalizado.");
    }

    public double getTamanho() {
        return tamanho;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
