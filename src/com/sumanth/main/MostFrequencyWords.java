package com.sumanth.main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class Name: MostFrequencyWords.java
 * 
 * Java class that has functionality that takes takes two parameters: (1) a
 * String representing a text document and (2) an integer providing the number
 * of items to return. Function returns a list of Strings ordered by word
 * frequency, the most frequently occurring word first.
 * 
 * @author Sumanth Lakshminarayana, UTA ID: 1000830230
 */
public class MostFrequencyWords {

	/**
	 * Function takes takes two parameters: (1) a String representing a text
	 * document and (2) an integer providing the number of items to return and
	 * returns a array of n Strings ordered by word frequency, the most
	 * frequently occurring word first
	 */
	public String[] nMostFrequentWords(String text, int n) {

		int numberOfWords = n;
		// Validation on input parameters
		if (numberOfWords <= 0 || (null == text || text == ""))
			return new String[0];

		String[] inputWordArray = text.split("\\s+");
		ArrayList<List<String>> frequencyListByIndex = new ArrayList<List<String>>();
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		int maxWordCount = 0, currentWordCount, listIndex, outputWordCounter = 0;
		String[] output;

		// Creating word-word count hash map.
		for (String word : inputWordArray) {
			if (wordMap.containsKey(word)) {
				wordMap.put(word, wordMap.get(word) + 1);
				if (maxWordCount < wordMap.get(word)) {
					maxWordCount = wordMap.get(word);
				}
			} else {
				wordMap.put(word, 1);
				if (maxWordCount < wordMap.get(word)) {
					maxWordCount = wordMap.get(word);
				}
			}
		}
		// Checking if the number of unique words is less than number of words
		// to be returned
		if (wordMap.size() < numberOfWords) {
			// If the number of words to be returned is greater than the unique
			// words in the string then all the words are returned
			String[] allWordsArray = new String[wordMap.size()];

		}
		// Initializing Arraylist using maxWordCount to have space alloted only
		// up to maximum frequency available
		for (int i = 0; i <= maxWordCount; i++) {
			frequencyListByIndex.add(new ArrayList<String>());
		}
		// Storing each word in the Arraylist in the index which is determined
		// by their word count

		for (String word : wordMap.keySet()) {
			currentWordCount = wordMap.get(word);
			frequencyListByIndex.get(currentWordCount).add(word);
		}
		listIndex = frequencyListByIndex.size() - 1;
		if (wordMap.size() < numberOfWords) {
			// If the number of words to be returned is greater than the unique
			// words in the string then all the words are returned and are
			// ordered by word frequency, the most frequently occurring word
			// first
			output = new String[wordMap.size()];
			outputWordCounter = 0;
			while (listIndex >= 0) {
				List<String> wordList = frequencyListByIndex.get(listIndex);
				for (int j = 0; j < wordList.size(); j++) {
					output[outputWordCounter] = wordList.get(j);
					outputWordCounter++;
				}
				listIndex--;
			}
		} else {
			// store n most frequent words in the output array ordered by word
			// frequency, the most frequently occurring word first
			output = new String[numberOfWords];
			outputWordCounter = 0;
			while (listIndex >= 0 && outputWordCounter < numberOfWords) {
				List<String> wordList = frequencyListByIndex.get(listIndex);
				if (!wordList.isEmpty()) {
					for (int j = 0; j < wordList.size(); j++) {
						if (outputWordCounter < n) {
							output[outputWordCounter] = wordList.get(j);
							outputWordCounter++;
						} else
							break;

					}
				}
				listIndex--;
			}
		}
		return output;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MostFrequencyWords mFW = new MostFrequencyWords();
		String testInput = "GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily Sumanth Sumanth Sumanth Sumanth Sumanth Prathiba Prathiba  Prathiba Prathiba Pavan Lakshminarayana Lakshminarayana Lakshminarayana Sumanth Sumanth Sumanth Prathiba Prathiba Prathiba Sowmya Lokamatha Lokamatha Lokamatha Savitri Savitri  Savitri Lakshminarayana Lokamatha ";
		String[] output = mFW.nMostFrequentWords(testInput, 8);
		System.out
				.println("Output array of words ordered ordered by word frequency, the most frequently occurring word first.");
		for (int i = 0; i < output.length; i++) {
			System.out.println((i + 1) + " " + output[i]);
		}
	}
}
