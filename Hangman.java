package javaUebungenAusDemNetz;

import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		String s;
		String userInput;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Geben Sie das zu erratende Wort ein: ");
			s = sc.next();
			s = s.toUpperCase();

			char[] wordAsChar = new char[s.length()];
			wordAsChar = makeCharArrayFromWord(s);

			gameTime(wordAsChar, sc, s);
			System.out.println("Moechten Sie eine weitere Runde spielen? j/n:");
			userInput = sc.next();
			userInput = userInput.toUpperCase();
		} while (userInput.equals("J"));
		sc.close();

	}

	public static char[] makeCharArrayFromWord(String s) {
		char[] wordAsChars = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			wordAsChars[i] = s.charAt(i);
		}
		return wordAsChars;
	}

	public static void gameTime(char[] wordAsChar, Scanner sc, String solution) {
		String s = "";
		String hangmanBuild = "";
		int hangmanCount = 0;
		String currentGuess;
		String[] hangManChar = new String[wordAsChar.length];

		for (int i = 0; i < hangManChar.length; i++) {
			hangManChar[i] = "_";
		}
		System.out.println(
				"Willkommen zu Hangman. Das zu erratene Wort beinhaltet " + wordAsChar.length + " Buchstaben.");
		while (Arrays.asList(hangManChar).contains("_")) {
			System.out.println("Bitte geben Sie Ihren Buchstaben ein: ");

			currentGuess = sc.next().toUpperCase().substring(0, 1);

			System.out.println("Ihre Eingabe war: " + currentGuess.charAt(0));

			for (int i = 0; i < wordAsChar.length; i++) {

				if (wordAsChar[i] == currentGuess.charAt(0)) {
					hangManChar[i] = currentGuess;

					System.out.println("+++Treffer!+++");
					System.out.println("Das ist Ihr aktueller Fortschritt: " + createWord(hangManChar, s));
				}

			}

			if (!Arrays.asList(hangManChar).contains(currentGuess)) {

				System.out.println("+++Leider kein Treffer!+++");
				System.out.println("Das ist Ihr aktueller Fortschritt: " + createWord(hangManChar, s));
				hangmanCount++;
				if (hangmanCount == 9) {
					break;
				}
				hangmanBuild = buildHangman(hangmanBuild, hangmanCount);
				System.out.println(hangmanBuild);
			}
		}

		if (hangmanCount < 9) {
			System.out.println("Herzlichen Glückwunsch, Sie haben gewonnen!");
			createWord(hangManChar, s);
			System.out.println("Das Lösungswort lautet: " + createWord(hangManChar, s));
		} else {
			System.out.println("Sie haben verloren. Sie hängen am Galgen!");
			hangmanBuild = buildHangman(hangmanBuild, hangmanCount);
			System.out.println(hangmanBuild);
			System.out.println("Das Lösungswort lautet: " + solution);
		}
	}

	public static String createWord(String[] hangManChar, String string) {
		for (String c : hangManChar) {
			string += c;
		}
		return string;
	}

	public static String buildHangman(String hangmanBuild, int hangman) {

		if (hangman == 1) {
			hangmanBuild += " ___";
		}
		if (hangman == 2) {
			hangmanBuild += "\n | |";
		}
		if (hangman == 3) {
			hangmanBuild += "\n | o";
		}
		if (hangman == 4) {
			hangmanBuild += "\n |\\|/";
		}
		if (hangman == 5) {
			hangmanBuild += "\n |/ \\";
		}
		if (hangman == 6) {
			hangmanBuild += "\n/";
		}
		if (hangman == 7) {
			hangmanBuild += " \\";
		}
		if (hangman == 8) {
			hangmanBuild += "__";
		}
		if (hangman == 9) {
			hangmanBuild += "JUST DIED";
		}

		return hangmanBuild;
	}
}
