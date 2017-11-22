package com.arkansascodingacademy;

import java.io.File;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CrosswordSolver implements Cloneable
{
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

    private CrosswordSolver()
    {
    }

    public Map<Integer, Set<String>> gethWordMap()
    {
        return hWordMap;
    }

    public void sethWordMap(Map<Integer, Set<String>> hWordMap)
    {
        this.hWordMap = hWordMap;
    }

    public Map<Integer, Set<String>> getvWordMap()
    {
        return vWordMap;
    }

    public void setvWordMap(Map<Integer, Set<String>> vWordMap)
    {
        this.vWordMap = vWordMap;
    }

    List<Set<String>> getVWordCandidates()
    {
        List list = new ArrayList();

        list.add(vWordMap.get(1));
        list.add(vWordMap.get(2));
        list.add(vWordMap.get(3));

        return list;
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

    public void addhWordCandidate(String candidateHWord)
    {
        hWordCandidates.add(candidateHWord);
    }

    public void addvWordCandidate(String candidateVWord)
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

    public void sethWordCandidates(List<String> hWordCandidates)
    {
        this.hWordCandidates = hWordCandidates;
    }

    public void setvWordCandidates(List<String> vWordCandidates)
    {
        this.vWordCandidates = vWordCandidates;
    }

    public void removeFromSet (int index, String word)
    {
        hWordMap.get(index).remove(word);
    }
}

