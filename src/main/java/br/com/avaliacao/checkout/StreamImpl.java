package br.com.avaliacao.checkout;

import static br.com.avaliacao.checkout.constants.Constants.FINAL_DE_LINHA;

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
		char character = FINAL_DE_LINHA;
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
