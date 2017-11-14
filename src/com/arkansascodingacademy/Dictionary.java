package com.arkansascodingacademy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Dictionary
{
    private Map<Integer, Set<String>> wordMap = new HashMap<>();

    public Dictionary(Path filePath)
    {
        try
        {
            List<String> words = Files.readAllLines(filePath);
            System.out.println(words.size() + " words in file");

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

    public Set<String> getWordSet(int wordLength)
    {
        return wordMap.get(wordLength);
    }

    public boolean wordExists(String word)
    {
        return getWordSet(word.length()).contains(word.toUpperCase());
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        for (Integer wordLength : wordMap.keySet())
        {
            Set<String> wordSet = wordMap.get(wordLength);

            sb.append(wordSet.size() + " words of length " + wordLength + "\n");
        }

        return sb.toString();
    }


}
