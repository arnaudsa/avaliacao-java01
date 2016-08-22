package br.com.avaliacao.checkout;

import static br.com.avaliacao.checkout.constants.Constants.VOGAL_NAO_ENCONTRADA;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;



public class SolutionAppTest {
		
	@Test
	public void testFirstChar() {
		char first = SolutionApp.firstChar(createStream("aAbBABacfe"));
		Assert.assertEquals('e', first);
	}

	@Test
	public void testFirstCharVogalNaoEncontrada() {
		try {
			SolutionApp.firstChar(createStream("arnaud"));			
			Assert.fail();
			
		} catch (IllegalArgumentException e) {
			Assert.assertEquals(VOGAL_NAO_ENCONTRADA, e.getMessage());
		}
	}

	public StreamImpl createStream(String palavra) {
		Scanner scanner = new Scanner(palavra);
		return new StreamImpl(scanner);		
	}

}
