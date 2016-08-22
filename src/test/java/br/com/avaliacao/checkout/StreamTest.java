package br.com.avaliacao.checkout;

import static br.com.avaliacao.checkout.constants.Constants.FINAL_DE_LINHA;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class StreamTest {

	private Stream stream;
	private String palavra = "aAbBABacfe";
	
	@Before
	public void before() {
		Scanner scanner = new Scanner(palavra);
		stream = new StreamImpl(scanner);		
	}
	
	@Test
	public void testGetNext() {
		char next = stream.getNext();
		Assert.assertNotNull(next);
	}

	@Test
	public void testGetNextEnd() {
		
		for (int i = 0; i < palavra.length(); i++) {
			stream.getNext();			
		}		

		char next = stream.getNext();
		Assert.assertEquals(FINAL_DE_LINHA, next);
	}

	@Test
	public void testHasNext() {
		boolean hasNext = stream.hasNext();
		Assert.assertTrue(hasNext);
	}

	@Test
	public void testHasNextEnd() {
		for (int i = 0; i < palavra.length(); i++) {
			stream.getNext();			
		}		
		boolean hasNext = stream.hasNext();
		
		Assert.assertFalse(hasNext);
	}

}
