package com.example.boxwords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.vaadin.server.VaadinServlet;

/**
 * 
 * @author Alejandro Duarte
 * 
 */
public class Dictionary {

	public static boolean exists(String word) {

		boolean found = false;
		word = word.toLowerCase();

		try {
			// source:
			// http://sourceforge.net/projects/wordlist/files/Hunspell%20en_US/
			BufferedReader br = new BufferedReader(new FileReader(VaadinServlet
					.getCurrent().getServletContext().getRealPath("")
					+ "/en_US.dic"));
			String line;

			while ((line = br.readLine()) != null) { // for each line in the
														// file

				if (line.contains("/")) { // some words have meta data, if so...
					line = line.split("/")[0]; // ignore meta data
				}

				if (line.equals(word)) {
					found = true;
					break;
				}

			}

			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return found;
	}

	public static Collection<String> getWords(String line) {

		ArrayList<String> list = new ArrayList<String>();

		for (int begin = 0; begin <= line.length() - 2; begin++) {
			for (int end = line.length(); end >= begin + 2; end--) {

				String subStr = line.substring(begin, end);

				if (exists(subStr)) {
					list.add(subStr);
				}

			}
		}

		return list;
	}

}
