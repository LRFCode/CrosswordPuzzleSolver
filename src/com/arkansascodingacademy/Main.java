package com.arkansascodingacademy;

import java.util.*;

public class Main
{
    private static int count = 0;

    public static void main(String[] args)
    {
        int hLength = 2;
        int vLength = 8;
        int successCount = 0;

        CrosswordSolver crosswordSolver = new CrosswordSolver(hLength, vLength);

        for (String candidateHWord1 : crosswordSolver.gethWordMap().get(0))
        {

            CrosswordSolver crosswordSolverCandidateHWord1 = crosswordSolver.clone();
            crosswordSolverCandidateHWord1.addhWordCandidate(candidateHWord1);
            refineVWords(crosswordSolverCandidateHWord1);

            if (crosswordSolverCandidateHWord1.possibleSolution())
            {
                for (String candidateVWord1 : crosswordSolverCandidateHWord1.getvWordMap().get(0))
                {
                    CrosswordSolver crosswordSolverCandidateVWord1 = crosswordSolverCandidateHWord1.clone();
                    crosswordSolverCandidateVWord1.addvWordCandidate(candidateVWord1);
                    refineHWords(crosswordSolverCandidateVWord1);

                    if (crosswordSolverCandidateVWord1.possibleSolution())
                    {
                        refineHWordsFurther(crosswordSolverCandidateVWord1, 1, vLength);
                    }
                }
            }
        }
    }

    private static void refineHWordsFurther(CrosswordSolver crosswordSolver, int index, int vLength)
    {
        for (String candidateHWord : crosswordSolver.gethWordMap().get(index))
        {
            CrosswordSolver crosswordSolverClone = crosswordSolver.clone();
            crosswordSolverClone.addhWordCandidate(candidateHWord);
            refineVWordsFurther(crosswordSolverClone);

            if (index + 1 == vLength)
            {
                if (crosswordSolverClone.possibleSolution())
                {
                    count++;
                    System.out.println("Success! #" + count);
                    for (String finalHWord : crosswordSolverClone.gethWordCandidates())
                    {
                        System.out.println(finalHWord);
                    }
                    System.out.println("***********************");

                }
            }
            else
            {
                if (crosswordSolverClone.possibleSolution())
                {
                    refineHWordsFurther(crosswordSolverClone, index + 1, vLength);
                }
            }
        }
    }

    private static void refineVWords(CrosswordSolver crosswordSolver)
    {
        String candidateHWord = crosswordSolver.gethWordCandidates().get(0);

        for (int i = 0; i < crosswordSolver.getvWordMap().size(); i++)
        {
            Set<String> vWordCandidates = new HashSet<>();

            for (String vWordCandidate : crosswordSolver.getvWordMap().get(i))
            {
                if (candidateHWord.substring(i, i + 1).equals(vWordCandidate.substring(0, 1)))
                {
                    vWordCandidates.add(vWordCandidate);
                }
            }

            crosswordSolver.getvWordMap().put(i, vWordCandidates);
        }
    }

    private static void refineHWords(CrosswordSolver crosswordSolver)
    {
        String candidateVWord = crosswordSolver.getvWordCandidates().get(0);

        for (int i = 1; i < crosswordSolver.gethWordMap().size(); i++)
        {
            Set<String> hWordCandidates = new HashSet<>();

            for (String hWordCandidate : crosswordSolver.gethWordMap().get(i))
            {
                if (candidateVWord.substring(i, i + 1).equals(hWordCandidate.substring(0, 1)))
                {
                    hWordCandidates.add(hWordCandidate);
                }
            }

            crosswordSolver.gethWordMap().put(i, hWordCandidates);
        }
    }

    private static void refineVWordsFurther(CrosswordSolver crosswordSolver)
    {
        List<String> candidateHWords = crosswordSolver.gethWordCandidates();

        for (int i = 1; i < crosswordSolver.getvWordMap().size(); i++)
        {
            Set<String> refinedVWords = new HashSet<>();

            String searchVWord = searchWord(i, candidateHWords);

            for (String candidateVWord : crosswordSolver.getvWordMap().get(i))
            {
                if (candidateVWord.substring(0, candidateHWords.size()).equals(searchVWord))
                {
                    refinedVWords.add(candidateVWord);
                }
            }

            crosswordSolver.getvWordMap().put(i, refinedVWords);
        }
    }

    private static String searchWord(int characterPosition, List<String> candidateWords)
    {
        StringBuilder searchWord = new StringBuilder();

        for (String candidateWord : candidateWords)
        {
            searchWord.append(candidateWord.substring(characterPosition, characterPosition + 1));
        }

        return searchWord.toString();
    }

}
