package com.arkansascodingacademy;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class CrosswordSolver implements Cloneable
{
    private List<String> hWordCandidates = new ArrayList<>();
    private List<String> vWordCandidates = new ArrayList<>();
    private Map<Integer, Set<String>> hWordMap = new HashMap<>();
    private Map<Integer, Set<String>> vWordMap = new HashMap<>();
    private Map<Integer, List<Set<String>>> hRow = new HashMap<>();
    private Map<Integer, List<Set<String>>> vRow = new HashMap<>();

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
        crosswordSolver.sethRow(new HashMap<>(hRow));
        crosswordSolver.setvRow(new HashMap<>(vRow));

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

    void addHWordRow(int rowNumber, int...hLengths)
    {
        List<Set<String>> hRowWordSets = new ArrayList<>();

        Path filePath = new File("wordsEn.txt").toPath();
        Dictionary dictionary = new Dictionary(filePath);

        for(int hLength : hLengths)
        {
            Set<String> hWordSet = dictionary.getWordSet(hLength);
            hRowWordSets.add(hWordSet);
        }

        hRow.put(rowNumber, hRowWordSets);
    }

    public Map<Integer, List<Set<String>>> gethRow()
    {
        return hRow;
    }

    public void sethRow(Map<Integer, List<Set<String>>> hRow)
    {
        this.hRow = hRow;
    }

    void addvWordRow(int rowNumber, int...vLengths)
    {
        List<Set<String>> vRowWordSets = new ArrayList<>();

        for(int vLength : vLengths)
        {
            Path filePath = new File("wordsEn.txt").toPath();
            Dictionary dictionary = new Dictionary(filePath);

            Set<String> hWordSet = dictionary.getWordSet(vLength);
            vRowWordSets.add(hWordSet);
        }

        vRow.put(rowNumber, vRowWordSets);
    }

    public Map<Integer, List<Set<String>>> getvRow()
    {
        return vRow;
    }

    public void setvRow(Map<Integer, List<Set<String>>> vRow)
    {
        this.vRow = vRow;
    }
}
