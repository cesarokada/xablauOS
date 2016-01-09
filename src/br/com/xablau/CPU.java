package br.com.xablau;

import java.util.PriorityQueue;
import java.util.Queue;

public class CPU {
	private Processo processoEmExecucao;
	private Queue<Processo> filaDeProcessos = new PriorityQueue<Processo>();
}
