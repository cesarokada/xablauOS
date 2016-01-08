package br.com.xablau;

public class Processo {
    private int time;

    public Processo(int time) {
        this.time = time;
    }

    public void run() throws InterruptedException {
        System.out.println("Iniciando execução");
        Thread.sleep(time);
        System.out.println("Processo finalizado.");
    }
}
