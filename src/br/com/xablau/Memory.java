package br.com.xablau;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Memory {

	protected List<TrechoMemoria> memory = new ArrayList<TrechoMemoria>();

	public Memory(double size) {
		this.memory.add(new TrechoMemoria(size));
	}

	public List<TrechoMemoria> getMemoria() {
		return memory;
	}

	public void addProcess(Process process) {
		TrechoMemoria allocatedTrecho = processAlreadyInMemory(process);
		if (allocatedTrecho != null) {
			allocatedTrecho.use();
			return;
		}

		TrechoMemoria trecho = getAvailableMemory(process.getTamanho());

		double espacoRestante = trecho.getTamanho() - process.getTamanho();

		trecho.atribuirProcesso(process);
		if (espacoRestante != 0) {
			TrechoMemoria trechoMemoriaDisponivel = new TrechoMemoria(espacoRestante);
			this.memory.add(this.memory.indexOf(trecho) + 1, trechoMemoriaDisponivel);
		}
	}

	private TrechoMemoria processAlreadyInMemory(Process process) {
		for (TrechoMemoria trechoMemoria : memory) {
			if (trechoMemoria.getProcesso().equals(process))
				return trechoMemoria;
		}

		return null;
	}

	public void removeProcess(Process process) {
		ListIterator<TrechoMemoria> i = memory.listIterator();

		while (i.hasNext()) {
			TrechoMemoria trecho = i.next();

			if (process.equals(trecho.getProcesso())) {
				double availableMemory = trecho.getTamanho();

				if (i.hasPrevious()) {
					TrechoMemoria prev = i.previous();
					if (prev.isDisponivel()) {
						availableMemory += prev.getTamanho();
						i.remove();
					} else {
						i.next();
					}
				}
				if (i.hasNext()) {
					TrechoMemoria next = i.next();
					if (next.isDisponivel()) {
						availableMemory += next.getTamanho();
						i.remove();
					} else {
						i.previous();
					}
				}

				i.previous();
				i.next();

				i.set(new TrechoMemoria(availableMemory));
			}
		}
	}

	public TrechoMemoria getAvailableMemory(double processSize) {
		TrechoMemoria trechoToRemove = null;

		for (TrechoMemoria trecho : memory) {
			if (trecho.isDisponivel() && trecho.getTamanho() >= processSize)
				return trecho;

			if (trechoToRemove == null && !trecho.getProcesso().isRunning() 
					|| trecho.getCreated().compareTo(trechoToRemove.getCreated()) < 0) {
				trechoToRemove = trecho;
			}
		}

		return trechoToRemove;
	}

	public void print() {
		for (TrechoMemoria trecho : memory) {
			System.out.println("Trecho de tamanho " + trecho.getTamanho() + (trecho.isDisponivel() ? "" : " não") + " disponível");
		}

		System.out.println("");
	}

}