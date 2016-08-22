package br.com.avaliacao.checkout;

import static br.com.avaliacao.checkout.constants.Constants.FINAL_DE_LINHA;

public class StreamImpl implements Stream {

	private final String input;
	private final int size;
	private int currentIndex;
	
	public StreamImpl(String input) {
		super();
		
		if (input == null) {
			input = "";
		}
		
		this.input = input;			
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
