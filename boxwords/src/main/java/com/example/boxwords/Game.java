package com.example.boxwords;

import java.util.Collection;
import java.util.Random;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
public class Game {

	private final int size;
	private String currentLetter = null;
	private int letterCount = 0;

	// http://en.wikipedia.org/wiki/Letter_frequency
	private String alphabet = "AAAAAAAAA" + "BB" + "CCC" + "DDDDD"
			+ "EEEEEEEEEEEEE" + "FFF" + "GGG" + "HHHHHHH" + "IIIIIII" + "J"
			+ "K" + "KKKKK" + "LLLLL" + "MMM" + "NNNNNNN" + "OOOOOOOO" + "PP"
			+ "Q" + "RRRRRR" + "SSSSSSS" + "TTTTTTTTTT" + "UUUUUUU" + "V"
			+ "WWW" + "X" + "YY" + "Z";

	private Random r = new Random();

	public Game(int size) {
		this.size = size;
		r.setSeed(System.currentTimeMillis());
	}

	public String nextLetter() {
		currentLetter = "" + alphabet.charAt(r.nextInt(alphabet.length()));
		letterCount++;

		return currentLetter;
	}

	public boolean over() {
		return letterCount >= size * size;
	}

	public Collection<String> getWords(String line) {
		return Dictionary.getWords(line);
	}

	public int getScore(Collection<String> words) {
		int score = 0;

		for (String word : words) {
			score += word.length();
		}

		return score;
	}

	public int getSize() {
		return size;
	}

	public String getCurrentLetter() {
		return currentLetter;
	}

}
