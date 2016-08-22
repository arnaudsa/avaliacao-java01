package br.com.avaliacao.checkout;

import static br.com.avaliacao.checkout.constants.Constants.VOGAL_NAO_ENCONTRADA;

import org.junit.Assert;
import org.junit.Test;

import br.com.avaliacao.checkout.app.SolutionApp;



public class SolutionAppTest {
		
	@Test
	public void testFirstChar01() {
		String palvra = "aAbBABacfe";
		char first = SolutionApp.firstChar(new StreamImpl(palvra));
		Assert.assertEquals('e', first);
	}

	@Test
	public void testFirstChar02() {
		String palavra = "Gato";
		char first = SolutionApp.firstChar(new StreamImpl(palavra));
		Assert.assertEquals('a', first);
	}

	@Test
	public void testFirstChar03() {
		String palavra = "Matheus";
		char first = SolutionApp.firstChar(new StreamImpl(palavra));
		Assert.assertEquals('a', first);
	}

	@Test
	public void testFirstCharVogalNaoEncontrada() {
		try {
			String palavra = "arnaud";
			SolutionApp.firstChar(new StreamImpl(palavra));			
			Assert.fail();
			
		} catch (IllegalArgumentException e) {
			Assert.assertEquals(VOGAL_NAO_ENCONTRADA, e.getMessage());
		}
	}
}
