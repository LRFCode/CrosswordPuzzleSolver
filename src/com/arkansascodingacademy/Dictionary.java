package com.arkansascodingacademy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Dictionary
{
    private Map<Integer, Set<String>> wordMap = new HashMap<>();

    Dictionary(Path filePath)
    {
        try
        {
            List<String> words = Files.readAllLines(filePath);

            for (String word : words)
            {
                String cleanedWord = word.trim().toUpperCase();
                int wordLength = cleanedWord.length();

                if (wordLength > 0)
                {
                    Set<String> wordSet = wordMap.get(wordLength);

                    if (wordSet == null)
                    {
                        wordSet = new HashSet<>();
                        wordMap.put(wordLength, wordSet);
                    }

                    wordSet.add(cleanedWord);
                }
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    Set<String> getWordSet(int wordLength)
    {
        return wordMap.get(wordLength);
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for (Integer wordLength : wordMap.keySet())
        {
            Set<String> wordSet = wordMap.get(wordLength);

            sb.append(wordSet.size()).append(" words of length ").append(wordLength).append("\n");
        }

        return sb.toString();
    }

    public Map<Integer, Set<String>> getWordMap()
    {
        return wordMap;
    }

    public void setWordMap(Map<Integer, Set<String>> wordMap)
    {
        this.wordMap = wordMap;
    }
}
