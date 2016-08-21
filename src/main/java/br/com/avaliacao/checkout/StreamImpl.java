package br.com.avaliacao.checkout;

import java.util.Scanner;

public class StreamImpl implements Stream {

	private String input;
	private int size;
	private int currentIndex;
	
	public StreamImpl(Scanner scanner) {
		super();
		this.input = scanner.nextLine().trim();
		this.size  = input.length();
	}

	@Override
	public char getNext() {
		char character = '\0';
		if (hasNext()) {
			character = input.charAt(currentIndex++);					
		}
		return character;
	}

	@Override
	public boolean hasNext() {		
		return currentIndex < size;				
	}

}
