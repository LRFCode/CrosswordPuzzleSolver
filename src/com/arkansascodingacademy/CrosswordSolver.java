package com.arkansascodingacademy;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class CrosswordSolver implements Cloneable
{
    private Map<Integer, Set<String>> hWordMap = new HashMap<>();
    private Map<Integer, Set<String>> vWordMap = new HashMap<>();

    private List<String> hWordCandidates = new ArrayList<>();
    private List<String> vWordCandidates = new ArrayList<>();
    private Dictionary dictionary;

    CrosswordSolver(int hLength, int vLength)
    {
        Path filePath = new File("wordsEn.txt").toPath();
        dictionary = new Dictionary(filePath);

        Set<String> hWordSet = dictionary.getWordSet(hLength);
        Set<String> vWordSet = dictionary.getWordSet(vLength);

        for (int i = 0; i < vLength; i++)
        {
            Set<String> wordCombinations = wordCombinations(new int[]{4});

            hWordMap.put(i, wordCombinations);
        }

        for (int i = 0; i < hLength; i++)
        {
            vWordMap.put(i, vWordSet);
        }
    }

    CrosswordSolver()
    {
    }

    private Set<String> wordCombinations(int[] pattern)
    {
        Set<String> wordCombinations = new HashSet<>();

        List<Set<String>> words = new ArrayList<>();

        for (int i = 0; i < pattern.length; i++)
        {
            if (pattern[i] > 0)
            {
                words.add(dictionary.getWordSet(pattern[i]));
            }
            else
            {
                String spaces = "";
                for (int j = 0; j < Math.abs(pattern[i]); j++)
                {
                    spaces += " ";
                }
                Set spacesSet = new HashSet<>();
                spacesSet.add(spaces);
                words.add(spacesSet);
            }
        }

        createWordCombinations(words, 0, "", wordCombinations);

        return wordCombinations;
    }


    private void createWordCombinations(List<Set<String>> words, int index, String wordSoFar, Set<String> wordCombinations)
    {
        for (String word:words.get(index))
        {
            if (index == words.size() - 1)
            {
                wordCombinations.add(wordSoFar + word);
            }
            else
            {
                createWordCombinations(words, index + 1, wordSoFar + word, wordCombinations);
            }
        }
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
}
