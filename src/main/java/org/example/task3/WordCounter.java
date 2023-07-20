package org.example.task3;

import org.example.utils.FileUtils;

import java.util.*;

public class WordCounter {
    public void processFile(String fileName) {
        String[] text = FileUtils.loadDataFromFile(fileName);
        Map<String, Integer> wordsMap = new HashMap<>();
        getWordsFromStrings(text, wordsMap);

        List<WordCountHolder> wordCountHolderList = createListOfWordCountHolders(wordsMap);
        wordCountHolderList.sort(Comparator.reverseOrder());
        printWords(wordCountHolderList);
    }

    private void getWordsFromStrings(String[] text, Map<String, Integer> wordsMap) {
        for (String line : text) {
            String[] words = line.split(" ");
            for (String word : words) {
                word = word.trim();
                Integer integer = wordsMap.get(word);

                if (integer != null) {
                    integer++;
                } else {
                    integer = 1;
                }

                wordsMap.put(word, integer);
            }
        }
    }

    private List<WordCountHolder> createListOfWordCountHolders(Map<String, Integer> wordsMap) {
        List<WordCountHolder> wordCountHolders = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            WordCountHolder holder = new WordCountHolder(entry.getKey(), entry.getValue());
            wordCountHolders.add(holder);
        }

        return wordCountHolders;
    }

    private void printWords(List<WordCountHolder> words) {
        for (WordCountHolder word : words) {
            System.out.println(word);
        }
    }


    public static void main(String[] args) {
        WordCounter counter = new WordCounter();
        counter.processFile("./files/words.txt");
    }
}
