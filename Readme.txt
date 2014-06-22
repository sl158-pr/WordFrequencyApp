Programming language: Java

MostFrequencyWords.java

Functionality:

Java class whose function is to take two parameters: (1) a String representing a text document and (2) an integer providing the number of items to return and returns a list of Strings ordered by word frequency, the most frequently occurring word first.

Assumptions

1) Words in the given input string are separated by space.
2) Input String will have at most at most 2^31 - 1 characters (Max length of a String in Java)
3) If the number of words to be returned is greater than the unique words in the string then all the words are returned

Solution Design/ Implementation idea

Words are split using space delimiter and stored in an array of String inputWordArray.

1) Use hash map wordMap to store key/value pair data where key is a word in the string and value is the frequency of the word in the String
2) maxWordCount to hold the largest frequency count among the frequencies of the words.
3) Array of String output of length n to store n Strings ordered by word frequency, the most frequently occurring word first
4) A arraylist of list of Strings used to store the words, index of each word is their frequency count.
5) Add n words in output by copying list of words from backward index i.e. starting from maximumWord frequency index of Arraylist.

Time Complexity: O(n) where n where n is the number of characters in the document
Sample Input Text: 
"GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily GoldenFamily Sumanth Sumanth Sumanth Sumanth Sumanth Prathiba Prathiba  Prathiba Prathiba Pavan Lakshminarayana Lakshminarayana Lakshminarayana Sumanth Sumanth Sumanth Prathiba Prathiba Prathiba Sowmya Lokamatha Lokamatha Lokamatha Savitri Savitri  Savitri Lakshminarayana Lokamatha ";
Number of words: 8

Sample output:
Output array of words ordered ordered by word frequency, the most frequently occurring word first.
1 GoldenFamily
2 Sumanth
3 Prathiba
4 Lokamatha
5 Lakshminarayana
6 Savitri
7 Pavan
8 Sowmya
 