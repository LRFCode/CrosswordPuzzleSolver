package com.arkansascodingacademy;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class CrosswordSolver implements Cloneable
{
    private List<Integer> indexesUsed = new ArrayList<>();

    private Map<Integer, int[]> hWordMapPattern = new HashMap<>();
    private Map<Integer, int[]> vWordMapPattern = new HashMap<>();

    private Dictionary dictionary = new Dictionary(new File("wordsOne.txt").toPath());

    private List<String> hWordCandidates = new ArrayList<>();
    private List<String> vWordCandidates = new ArrayList<>();

    private Map<Integer, Set<String>> hWordMap = new HashMap<>();
    private Map<Integer, Set<String>> vWordMap = new HashMap<>();

    CrosswordSolver(int hLength, int vLength)
    {
        Path filePath = new File("wordsEn.txt").toPath();
        Dictionary dictionary = new Dictionary(filePath);

        Set<String> hWordSet = dictionary.getWordSet(hLength);
        Set<String> vWordSet = dictionary.getWordSet(vLength);

        for (int i = 0; i < vLength; i++)
        {
            hWordMap.put(i, hWordSet);
        }

        for (int i = 0; i < hLength; i++)
        {
            vWordMap.put(i, vWordSet);
        }
    }

    CrosswordSolver()
    {
    }

    public void addHWordMapCandidates(int[] pattern)
    {
        Path filePath = new File("wordsOne.txt").toPath();
        Dictionary dictionary = new Dictionary(filePath);

        List<Set<String>> wordList = new ArrayList<>();

        for (int number : pattern)
        {
            if (number > 0)
            {
                wordList.add(dictionary.getWordSet(number));
            }
            else
            {
                Set<String> spaces = new HashSet<>();
                String space = "";

                int spaceCount = Math.abs(number);

                for (int i = 0; i < spaceCount; i++)
                {
                    space += " ";
                }

                spaces.add(space);
                wordList.add(spaces);
            }
        }

        Set<String> wordCombos = new HashSet<>();

        Set<String> wordCombosFinal = wordCombine(wordList, wordCombos, "", 0);

        hWordMap.put(hWordMap.size(), wordCombosFinal);
    }

    public void addVWordMapCandidates(int[] pattern)
    {
        Path filePath = new File("wordsOne.txt").toPath();
        Dictionary dictionary = new Dictionary(filePath);

        List<Set<String>> wordList = new ArrayList<>();

        for (int number : pattern)
        {
            if (number > 0)
            {
                wordList.add(dictionary.getWordSet(number));
            }
            else
            {
                Set<String> spaces = new HashSet<>();
                String space = "";

                int spaceCount = Math.abs(number);

                for (int i = 0; i < spaceCount; i++)
                {
                    space += " ";
                }

                spaces.add(space);
                wordList.add(spaces);
            }
        }

        Set<String> wordCombos = new HashSet<>();

        Set<String> wordCombosFinal = wordCombine(wordList, wordCombos, "", 0);

        vWordMap.put(vWordMap.size(), wordCombosFinal);
    }

    public void addHWordMapCandidates1(int[] pattern)
    {
        Set<String> wordsInUse = splitHWordCandidates();

        List<Set<String>> wordList = createWordList(pattern, wordsInUse);

        Set<String> wordCombos = new HashSet<>();

        Set<String> wordCombosFinal = wordCombine(wordList, wordCombos, "", 0);

        hWordMap.put(hWordMap.size(), wordCombosFinal);
    }

    public void addVWordMapCandidates1(int[] pattern)
    {
        Set<String> wordsInUse = splitHWordCandidates();

        List<Set<String>> wordList = createWordList(pattern, wordsInUse);

        Set<String> wordCombos = new HashSet<>();

        Set<String> wordCombosFinal = wordCombine(wordList, wordCombos, "", 0);

        vWordMap.put(vWordMap.size(), wordCombosFinal);
    }

    public List<Set<String>> createWordList(int[] pattern, Set<String> wordsInUse)
    {
        List<Set<String>> wordList = new ArrayList<>();

        for (int number : pattern)
        {
            if (number > 0)
            {
                Set<String> words = dictionary.getWordSet(number);

                for (String word : wordsInUse)
                {
                    words.remove(word);
                }

                wordList.add(words);
            }
            else
            {
                Set<String> spaces = new HashSet<>();
                StringBuilder sb = new StringBuilder();

                int spaceCount = Math.abs(number);

                for (int i = 0; i < spaceCount; i++)
                {
                    sb.append(" ");
                }

                String space = sb.toString();

                spaces.add(space);
                wordList.add(spaces);
            }
        }

        return wordList;
    }

    public Set<String> splitHWordCandidates()
    {
        Set<String> wordsInUse = new HashSet<>();

        for (String word : hWordCandidates)
        {
            String[] words = word.trim().split("\\s+");

            for (String word1 : words)
            {
                wordsInUse.add(word1);
            }
        }
        for (String word : vWordCandidates)
        {
            String[] words = word.trim().split("\\s+");

            for (String word1 : words)
            {
                wordsInUse.add(word1);
            }
        }

        return wordsInUse;
    }

    public void removeRedundantWords()
    {
        Set<String> wordsInUse = splitHWordCandidates();

        for (String wordInUse : wordsInUse)
        {
            for (int i = 1; i < hWordMap.size(); i++)
            {
                Set<String> wordSet = new HashSet<>();

                for (String word : hWordMap.get(i))
                {
                    if (!word.contains(wordInUse))
                    {
                        wordSet.add(word);
                    }
                }

                hWordMap.put(i, wordSet);
            }

            for (int i = 1; i < vWordMap.size(); i++)
            {
                Set<String> wordSet = new HashSet<>();

                for (String word : vWordMap.get(i))
                {
                    if (!word.contains(wordInUse))
                    {
                        wordSet.add(word);
                    }
                }

                vWordMap.put(i, wordSet);
            }
        }
    }

    public Set<String> wordCombine(List<Set<String>> wordList, Set<String> wordCombos, String wordSoFar, int index)
    {
        for (String word : wordList.get(index))
        {
            if (index == wordList.size() - 1)
            {
                wordCombos.add(wordSoFar + word);
            }
            else
            {
                wordCombine(wordList, wordCombos, wordSoFar + word, index + 1);
            }
        }

        return wordCombos;
    }

    Map<Integer, Set<String>> gethWordMap()
    {
        return hWordMap;
    }

    private void sethWordMap(Map<Integer, Set<String>> hWordMap)
    {
        this.hWordMap = hWordMap;
    }

    Map<Integer, Set<String>> getvWordMap()
    {
        return vWordMap;
    }

    private void setvWordMap(Map<Integer, Set<String>> vWordMap)
    {
        this.vWordMap = vWordMap;
    }

    public CrosswordSolver clone()
    {
        try
        {
            super.clone();
        } catch (Exception e)
        {
            //do nothing
        }
        CrosswordSolver crosswordSolver = new CrosswordSolver();
        crosswordSolver.sethWordMap(new HashMap<>(hWordMap));
        crosswordSolver.setvWordMap(new HashMap<>(vWordMap));
        crosswordSolver.sethWordCandidates(new ArrayList<>(hWordCandidates));
        crosswordSolver.setvWordCandidates(new ArrayList<>(vWordCandidates));
        crosswordSolver.setIndexesUsed(new ArrayList<>(indexesUsed));

        return crosswordSolver;
    }

    boolean possibleSolution()
    {
        for (int i = 0; i < hWordMap.size(); i++)
        {
            if (hWordMap.get(i).size() < 1)
            {
                return false;
            }
        }
        for (int i = 0; i < vWordMap.size(); i++)
        {
            if (vWordMap.get(i).size() < 1)
            {
                return false;
            }
        }

        return true;
    }

    boolean isSolution()
    {
        for (int i = 1; i < vWordMap.size(); i++)
        {
            if (vWordMap.get(i).size() != 1)
            {
                return false;
            }
        }

        return true;
    }

    void addhWordCandidate(String candidateHWord)
    {
        hWordCandidates.add(candidateHWord);
    }

    void addvWordCandidate(String candidateVWord)
    {
        vWordCandidates.add(candidateVWord);
    }

    List<String> gethWordCandidates()
    {
        return hWordCandidates;
    }

    List<String> getvWordCandidates()
    {
        return vWordCandidates;
    }

    private void sethWordCandidates(List<String> hWordCandidates)
    {
        this.hWordCandidates = hWordCandidates;
    }

    private void setvWordCandidates(List<String> vWordCandidates)
    {
        this.vWordCandidates = vWordCandidates;
    }

    public Map<Integer, int[]> gethWordMapPattern()
    {
        return hWordMapPattern;
    }

    public void sethWordMapPattern(Map<Integer, int[]> hWordMapPattern)
    {
        this.hWordMapPattern = hWordMapPattern;
    }

    public Map<Integer, int[]> getvWordMapPattern()
    {
        return vWordMapPattern;
    }

    public void setvWordMapPattern(Map<Integer, int[]> vWordMapPattern)
    {
        this.vWordMapPattern = vWordMapPattern;
    }

    public List<Integer> getIndexesUsed()
    {
        return indexesUsed;
    }

    public void setIndexesUsed(List<Integer> indexesUsed)
    {
        this.indexesUsed = indexesUsed;
    }

    public Dictionary getDictionary()
    {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary)
    {
        this.dictionary = dictionary;
    }
}


