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
		
		if (trecho == null)
			throw new OutOfMemoryError();

		double espacoRestante = trecho.getTamanho() - process.getTamanho();

		trecho.atribuirProcesso(process);
		if (espacoRestante != 0) {
			TrechoMemoria trechoMemoriaDisponivel = new TrechoMemoria(espacoRestante);
			this.memory.add(this.memory.indexOf(trecho) + 1, trechoMemoriaDisponivel);
		}
	}

	private TrechoMemoria processAlreadyInMemory(Process process) {
		for (TrechoMemoria trechoMemoria : memory) {
			if (process.equals(trechoMemoria.getProcesso()))
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

			if (trecho.getTamanho() >= processSize) {
				if (trechoToRemove == null && processIsNotRunning(trecho) || processIsOlderThanOther(trechoToRemove, trecho)) {
					trechoToRemove = trecho;
				}
			}
		}

		return trechoToRemove;
	}

	private boolean processIsNotRunning(TrechoMemoria trecho) {
		return trecho.getProcesso() != null && !trecho.getProcesso().isRunning();
	}

	private boolean processIsOlderThanOther(TrechoMemoria trecho1, TrechoMemoria trecho2) {
		return trecho2.getCreated().compareTo(trecho1.getCreated()) < 0;
	}

	public void print() {
		for (TrechoMemoria trecho : memory) {
			System.out.println("Trecho de tamanho " + trecho.getTamanho() + (trecho.isDisponivel() ? "" : " não") + " disponível");
		}

		System.out.println("");
	}

	public boolean containsProcess(Process process) {		
		return processAlreadyInMemory(process) != null;
	}

}