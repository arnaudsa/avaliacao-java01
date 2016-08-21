package br.com.avaliacao.checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionApp {
	
	private static boolean isPreviousConsoante;
	
	private static Map<Character, Integer> map = new HashMap<>();
	private static List<Character> listVogais = new ArrayList<>();
	
	public static char firstChar(Stream stream) {
				
		while (stream.hasNext()) {									
			
			char character = stream.getNext();
			if (isConsoante(character)) {
				isPreviousConsoante = true;				
			
			}else if (isVogal(character) && isPreviousConsoante) {				
				listVogais.add(character);				
			}
			
			saveCharacter(character);
		}
		
		return getVogal();
		
	}

	private static Character getVogal() {
		if (!listVogais.isEmpty()) {									
			for (Character key : listVogais) {
				Integer integer = map.get(key);
				if (integer == 1) {
					return key;
				}				
			}
		}
		throw new IllegalArgumentException("Vogal não encontrada.");			
	}
	
	private static void saveCharacter(Character character) {
		Integer qtd = map.get(character);
		if (qtd == null) {
			map.put(character, 1);					
			
		}else{
			map.put(character, ++qtd);
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
		
		char firstChar = firstChar(stream);
		System.out.println(firstChar);
	}

}
