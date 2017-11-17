package com.arkansascodingacademy;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        int hLength = 4;
        int vLength = 4;
        int successCount = 0;

        CrosswordSolver crosswordSolver = new CrosswordSolver(hLength, vLength);

        List<String> hWord1Candidates = new ArrayList<>(crosswordSolver.gethWordMap().get(0));

        for (String candidateHWord1 : crosswordSolver.gethWordMap().get(0))
        {

            for (int i = 0; i < crosswordSolver.getvWordMap().size(); i++)
            {
                crosswordSolver.getvWordMap().put(i, vWordPossibilities(hWord1Candidates, candidateHWord1, i));
            }

            if (crosswordSolver.possibleSolution())
            {
                for (String candidateVWord1 : crosswordSolver.getvWordMap().get(0))
                {
                    CrosswordSolver crosswordSolverCandidateVWord1 = crosswordSolver.clone();

                    for (int i = 1; i < crosswordSolverCandidateVWord1.gethWordMap().size(); i++)
                    {
                        crosswordSolverCandidateVWord1.gethWordMap().put(i, hWordPossibilities(hWord1Candidates, candidateVWord1, i));
                    }

                    if (crosswordSolverCandidateVWord1.possibleSolution())
                    {
                        for (String candidateHWord2 : crosswordSolverCandidateVWord1.gethWordMap().get(1))
                        {
                            CrosswordSolver crosswordSolverCandidateHWord2 = crosswordSolverCandidateVWord1.clone();

                            Map<Integer, Set<String>> vWordPossiblesRefined1 = wordPossibilitiesRefined(crosswordSolverCandidateHWord2, candidateHWord1, candidateHWord2);

                            for (int i = 1; i < crosswordSolverCandidateHWord2.gethWordMap().size(); i++)
                            {
                                crosswordSolverCandidateHWord2.getvWordMap().put(i, vWordPossiblesRefined1.get(i - 1));
                            }

                            if (crosswordSolverCandidateHWord2.possibleSolution())
                            {
                                for (String candidateHWord3 : crosswordSolverCandidateHWord2.gethWordMap().get(2))
                                {
                                    CrosswordSolver crosswordSolverCandidateHWord3 = crosswordSolverCandidateHWord2.clone();

                                    Map<Integer, Set<String>> vWordPossiblesRefined2 = wordPossibilitiesRefined(crosswordSolverCandidateHWord3, candidateHWord1, candidateHWord2, candidateHWord3);

                                    for (int i = 1; i < crosswordSolverCandidateHWord3.gethWordMap().size(); i++)
                                    {
                                        crosswordSolverCandidateHWord3.getvWordMap().put(i, vWordPossiblesRefined2.get(i - 1));
                                    }

                                    if (crosswordSolverCandidateHWord3.possibleSolution())
                                    {
                                        for (String candidateHWord4 : crosswordSolverCandidateHWord3.gethWordMap().get(3))
                                        {
                                            CrosswordSolver crosswordSolverCandidateHWord4 = crosswordSolverCandidateHWord3.clone();

                                            Map<Integer, Set<String>> vWordPossiblesRefined3 = wordPossibilitiesRefined(crosswordSolverCandidateHWord4, candidateHWord1, candidateHWord2, candidateHWord3, candidateHWord4);

                                            for (int i = 1; i < crosswordSolverCandidateHWord3.gethWordMap().size(); i++)
                                            {
                                                crosswordSolverCandidateHWord4.getvWordMap().put(i, vWordPossiblesRefined3.get(i - 1));
                                            }

                                            if (crosswordSolverCandidateHWord4.isSolution())
                                            {
                                                successCount++;
                                                System.out.println("***************");
                                                System.out.println("Success #" + successCount + "!");
                                                System.out.println("hWord 1: " + candidateHWord1);
                                                System.out.println("hWord 2: " + candidateHWord2);
                                                System.out.println("hWord 3: " + candidateHWord3);
                                                System.out.println("hWord 4: " + candidateHWord4);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
    }

    private static Set<String> vWordPossibilities(List<String> wordCandidates, String candidateHWord, int index)
    {
        Set<String> vWordPossibilities = new HashSet<>();

        for (String word : wordCandidates)
        {
            if (candidateHWord.substring(index, index + 1).equals(word.substring(0, 1)))
            {
                vWordPossibilities.add(word);
            }
        }

        return vWordPossibilities;
    }

    private static Set<String> hWordPossibilities(List<String> wordCandidates, String candidateVWord, int index)
    {
        Set<String> hWordPossibilities = new HashSet<>();

        for (String hWordCandidate : wordCandidates)
        {
            if (hWordCandidate.substring(0, 1).equals(candidateVWord.substring(index, index + 1)))
            {
                hWordPossibilities.add(hWordCandidate);
            }
        }

        return hWordPossibilities;
    }

    private static void refineWords(Map<Integer, Set<String>> map, List<Set<String>> vWordCandidates, String... candidateHWords)
    {
        for (int i = 0; i < vWordCandidates.size(); i++)
        {
            for (String candidateVWord : vWordCandidates.get(i))
            {
                String searchVWord = searchWord(i + 1, candidateHWords);

                if (candidateVWord.substring(0, candidateHWords.length).equals(searchVWord))
                {
                    map.get(i).add(candidateVWord);
                }
            }
        }
    }

    private static Map<Integer, Set<String>> wordPossibilitiesRefined(CrosswordSolver crosswordSolver, String... candidateHWords)
    {
        List<Set<String>> vWordCandidates = crosswordSolver.getVWordCandidates();

        Map<Integer, Set<String>> vWordCandidatesMap = new HashMap<>();

        for (int i = 0; i < vWordCandidates.size(); i++)
        {
            Set<String> vWordPossibles = new HashSet<>();
            vWordCandidatesMap.put(i, vWordPossibles);
        }

        refineWords(vWordCandidatesMap, vWordCandidates, candidateHWords);

        return vWordCandidatesMap;
    }

    private static String searchWord(int characterPosition, String... candidateWords)
    {
        StringBuilder searchWord = new StringBuilder();
        for (String candidateWord : candidateWords)
        {
            searchWord.append(candidateWord.substring(characterPosition, characterPosition + 1));
        }

        return searchWord.toString();
    }
}
