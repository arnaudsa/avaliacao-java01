package br.com.avaliacao.checkout;

import static br.com.avaliacao.checkout.constants.Constants.VOGAL_NAO_ENCONTRADA;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionApp {
	
	private static Map<Character, Integer> mapCountCharacter = new LinkedHashMap<>();
	private static List<Character> characters = new ArrayList<>();
	private static List<Character> vogais = new ArrayList<>();
	
	public static char firstChar(Stream stream) {
				
		while (stream.hasNext()) {									
			
			char charCurrent = stream.getNext();			
			
			if (characters.size() >= 1) {								
				char charPrevious = characters.get(characters.size()-1);
				boolean charPreviousIsConsoante = isConsoante(charPrevious);
				
				
				boolean currentIsVogal = isVogal(charCurrent);
				if (charPreviousIsConsoante && currentIsVogal) {
					vogais.add(charCurrent);									
				}
			}
			
			characters.add(charCurrent);			
			saveCharacter(charCurrent);
		}
		
		return getVogal();	
	}
	
	private static Character getVogal() {
		if (!vogais.isEmpty()) {									
			for (Character key : vogais) {
				Integer integer = mapCountCharacter.get(key);
				if (integer == 1) {
					return key;
				}				
			}
		}
		throw new IllegalArgumentException(VOGAL_NAO_ENCONTRADA);			
	}
	
	private static void saveCharacter(Character character) {		
		if (mapCountCharacter.containsKey(character)) {
			Integer qtd = mapCountCharacter.get(character);
			mapCountCharacter.put(character, ++qtd);			
		
		}else{
			mapCountCharacter.put(character, 1);								
		}		
	}
	
	private static boolean isVogal(char character) {
				
		Pattern pattern = Pattern.compile("[aeiouAEIOU]");		
		Matcher matcher = pattern.matcher("" + character);
		
		return matcher.matches();
	}
	
	private static boolean isConsoante(char character) {
		
		Pattern pattern = Pattern.compile("[^aeiouAEIOU0-9\\W]");		
		Matcher matcher = pattern.matcher("" + character);
		
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		
		System.out.println("**********************************************************************");
		System.out.println("Encontrar a primeira vogal, após uma consoante e que não se repita");
		System.out.println("**********************************************************************");		
		System.out.println();
		System.out.print("Digite uma palavra: ");
		Stream stream = new StreamImpl(new Scanner(System.in));
		
		try {
			char firstChar = firstChar(stream);
			System.out.print("Resposta: ");
			System.out.print(firstChar);
			
		} catch (IllegalArgumentException e) {
			System.out.print("Resposta: ");
			System.out.print(e.getMessage());
		}
	}

}
