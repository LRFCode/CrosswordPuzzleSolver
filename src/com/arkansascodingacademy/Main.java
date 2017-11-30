package com.arkansascodingacademy;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        /*
        CrosswordSolver crosswordSolver = new CrosswordSolver();

        crosswordSolver.addHWordMapCandidates(new int[]{4, -1, 4, -1, 5});
        crosswordSolver.addHWordMapCandidates(new int[]{4, -1, 4, -1, 5});
        crosswordSolver.addHWordMapCandidates(new int[]{9, -1, 5});
        crosswordSolver.addHWordMapCandidates(new int[]{6, -1, 4, -1, 3});
        crosswordSolver.addHWordMapCandidates(new int[]{-3, 4, -2, 4, -2});
        crosswordSolver.addHWordMapCandidates(new int[]{3, -1, 11});
        crosswordSolver.addHWordMapCandidates(new int[]{5, -1, 4, -1, 4});
        crosswordSolver.addHWordMapCandidates(new int[]{4, -1, 5, -1, 4});
        crosswordSolver.addHWordMapCandidates(new int[]{4, -1, 4, -1, 5});
        crosswordSolver.addHWordMapCandidates(new int[]{11, -1, 3});
        crosswordSolver.addHWordMapCandidates(new int[]{-2, 4, -2, 4, 3});
        crosswordSolver.addHWordMapCandidates(new int[]{3, -1, 4, -1, 6});
        crosswordSolver.addHWordMapCandidates(new int[]{5, -1, 9});
        crosswordSolver.addHWordMapCandidates(new int[]{5, -1, 4, -1, 4});
        crosswordSolver.addHWordMapCandidates(new int[]{5, -1, 4, -1, 4});

        crosswordSolver.addVWordMapCandidates(new int[]{4, -1, 5, -1, 4});
        crosswordSolver.addVWordMapCandidates(new int[]{4, -1, 5, -1, 4});
        crosswordSolver.addVWordMapCandidates(new int[]{4, -1, 10});
        crosswordSolver.addVWordMapCandidates(new int[]{5, -1, 5, -1, 3});
        crosswordSolver.addVWordMapCandidates(new int[]{-2, 5, -2, 6});
        crosswordSolver.addVWordMapCandidates(new int[]{6, -1, 5, -3});
        crosswordSolver.addVWordMapCandidates(new int[]{3, -1, 6, -1, 4});
        crosswordSolver.addVWordMapCandidates(new int[]{4, -1, 5, -1, 4});
        crosswordSolver.addVWordMapCandidates(new int[]{4, -1, 6, -1, 3});
        crosswordSolver.addVWordMapCandidates(new int[]{-3, 5, -1, 6});
        crosswordSolver.addVWordMapCandidates(new int[]{6, -2, 5, -2});
        crosswordSolver.addVWordMapCandidates(new int[]{3, -1, 5, -1, 5});
        crosswordSolver.addVWordMapCandidates(new int[]{10, -1, 4});
        crosswordSolver.addVWordMapCandidates(new int[]{4, -1, 5, -1, 4});
        crosswordSolver.addVWordMapCandidates(new int[]{4, -1, 5, -1, 4});
        */

        CrosswordSolver crosswordSolver = new CrosswordSolver();

        crosswordSolver.addHWordMapCandidates1(new int[]{4, -1, 4, -1, 5});

        //for(String candidateHWord1 : crosswordSolver.gethWordMap().get(0))
        {
            String candidateHWord1 = "JEER GASP ALBUM";

            CrosswordSolver crosswordSolverCandidateHWord1 = crosswordSolver.clone();
            crosswordSolverCandidateHWord1.addhWordCandidate(candidateHWord1);

            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{4, -1, 5, -1, 4});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{4, -1, 5, -1, 4});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{4, -1, 10});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{5, -1, 5, -1, 3});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{-2, 5, -2, 6});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{6, -1, 5, -3});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{3, -1, 6, -1, 4});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{4, -1, 5, -1, 4});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{4, -1, 6, -1, 3});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{-3, 5, -1, 6});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{6, -2, 5, -2});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{3, -1, 5, -1, 5});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{10, -1, 4});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{4, -1, 5, -1, 4});
            crosswordSolverCandidateHWord1.addVWordMapCandidates1(new int[]{4, -1, 5, -1, 4});
            refineVWords1(crosswordSolverCandidateHWord1);

            //for(String candidateVWord1 : crosswordSolverCandidateHWord1.getvWordMap().get(0))
            {
                String candidateVWord1 = "JAWS AFLAC FAST";

                CrosswordSolver crosswordSolverCandidateVWord1 = crosswordSolverCandidateHWord1.clone();
                crosswordSolverCandidateVWord1.addvWordCandidate(candidateVWord1);

                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{4, -1, 4, -1, 5});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{9, -1, 5});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{6, -1, 4, -1, 3});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{-3, 4, -2, 4, -2});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{3, -1, 11});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{5, -1, 4, -1, 4});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{4, -1, 5, -1, 4});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{4, -1, 4, -1, 5});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{11, -1, 3});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{-2, 4, -2, 4, -3});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{3, -1, 4, -1, 6});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{5, -1, 9});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{5, -1, 4, -1, 4});
                crosswordSolverCandidateVWord1.addHWordMapCandidates1(new int[]{5, -1, 4, -1, 4});
                refineHWords1(crosswordSolverCandidateVWord1);

                if (crosswordSolverCandidateVWord1.possibleSolution())
                {
                    CrosswordSolver crosswordSolverClone = crosswordSolverCandidateVWord1.clone();
                    refineHWordFurther1(crosswordSolverClone, 1);
                    refineHWordsFurther(crosswordSolverClone, 1, 15);
                }
            }
        }
    }

    private static void refineVWords1(CrosswordSolver crosswordSolver)
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

    private static void refineHWords1(CrosswordSolver crosswordSolver)
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

    private static void refineVWordsFurther1(CrosswordSolver crosswordSolver)
    {
        int indexLowest = 0;
        int indexSecondLowest = 0;

        for (int i = 1; i < crosswordSolver.gethWordMap().size(); i++)
        {
            if (crosswordSolver.gethWordMap().get(indexLowest).size() > crosswordSolver.gethWordMap().get(i).size() && !crosswordSolver.getIndexesUsed().contains(i))
            {
                indexLowest = i;
            }
        }
        for (int i = 1; i < crosswordSolver.gethWordMap().size(); i++)
        {
            if (crosswordSolver.gethWordMap().get(indexSecondLowest).size() > crosswordSolver.gethWordMap().get(i).size() && i != indexLowest && !crosswordSolver.getIndexesUsed().contains(i))
            {
                indexSecondLowest = i;
            }
        }

        for (int i = 0; i < crosswordSolver.gethWordMap().size(); i++)
        {
            Set<String> refinedVWords = new HashSet<>();

            for (String candidateVWord1 : crosswordSolver.getvWordMap().get(i))
            {
                for (String candidateHWord1 : crosswordSolver.gethWordMap().get(indexLowest))
                {
                    for (String candidateHWord2 : crosswordSolver.gethWordMap().get(indexSecondLowest))
                    {
                        if (candidateVWord1.substring(indexLowest, indexLowest + 1).equals(candidateHWord1.substring(i, i + 1)) && candidateVWord1.substring(indexSecondLowest, indexSecondLowest + 1).equals(candidateHWord2.substring(i, i + 1)))
                        {
                            refinedVWords.add(candidateVWord1);
                        }
                    }
                }
            }

            crosswordSolver.getvWordMap().put(i, refinedVWords);
        }

        crosswordSolver.getIndexesUsed().add(indexLowest);
        crosswordSolver.getIndexesUsed().add(indexSecondLowest);
    }

    private static void refineHWordFurther1(CrosswordSolver crosswordSolver, int index)
    {
        if (index < (crosswordSolver.gethWordMap().size() - 1) / 2)
        {
            refineVWordsFurther1(crosswordSolver);
            removeRedundantHWords(crosswordSolver);

            if (crosswordSolver.isSolution())
            {
                System.out.println("Success!");
            }
            else if (crosswordSolver.possibleSolution())
            {
                index++;
                refineHWordFurther1(crosswordSolver, index);
            }
        }
    }

    private static void removeRedundantHWords(CrosswordSolver crosswordSolver)
    {
        List<String> wordsToRemove = new ArrayList<>();

        for (int i = 0; i < crosswordSolver.getvWordMap().size(); i++)
        {
            List<String[]> wordPartsList = new ArrayList<>();

            for (String word : crosswordSolver.getvWordMap().get(i))
            {
                String[] wordParts = word.trim().split("\\s+");
                wordPartsList.add(wordParts);
            }

            for (String wordPart : wordPartsList.get(0))
            {
                int count = 0;

                for (int j = 1; j < wordPartsList.size(); j++)
                {
                    List<String> list = Arrays.asList(wordPartsList.get(j));

                    if (list.contains(wordPart))
                    {
                        count++;
                    }
                }

                if (count == wordPartsList.size() - 1)
                {
                    wordsToRemove.add(wordPart);
                }
            }
        }

        for (String wordInUse : wordsToRemove)
        {
            for (int i = 1; i < crosswordSolver.gethWordMap().size(); i++)
            {
                Set<String> wordSet = new HashSet<>();

                for (String word : crosswordSolver.gethWordMap().get(i))
                {
                    if (!word.contains(wordInUse))
                    {
                        wordSet.add(word);
                    }
                }

                crosswordSolver.gethWordMap().put(i, wordSet);
            }
        }
    }

    private static void refineHAndVWords(CrosswordSolver crosswordSolver, int vLength)
    {
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

    private static void refineHWordsFurther(CrosswordSolver crosswordSolver, int index, int vLength)
    {
        for (String candidateHWord : crosswordSolver.gethWordMap().get(index))
        {
            CrosswordSolver crosswordSolverClone = crosswordSolver.clone();
            crosswordSolverClone.addhWordCandidate(candidateHWord);
            refineVWordsFurther(crosswordSolverClone);

            if (index + 1 == vLength)
            {
                if (crosswordSolverClone.isSolution())
                {
                    for (String finalHWord : crosswordSolverClone.gethWordCandidates())
                    {
                        System.out.println(finalHWord);
                    }
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

/* Find palindromes...

    Path filePath = new File("wordsEn.txt").toPath();
    Dictionary dictionary = new Dictionary(filePath);

    Set<Integer> keys = dictionary.getWordMap().keySet();
    keys.remove(1);

    for (Integer key : keys)
    {
        for (String word : dictionary.getWordSet(key))
        {
            if (key % 2 == 0)
            {
                int index = key / 2;

                String beginWord = word.substring(0, index);
                StringBuilder sb = new StringBuilder();

                for (int j = word.length() - 1; j >= index; j--)
                {
                    sb.append(word.substring(j, j + 1));
                }

                String endWord = sb.toString();

                if (beginWord.equals(endWord))
                {
                    System.out.println(word);
                    count++;
                }
            }
            else
            {
                int index = (key + 1) / 2;

                String beginWord = word.substring(0, index - 1);
                StringBuilder sb = new StringBuilder();

                for (int j = word.length() - 1; j >= index; j--)
                {
                    sb.append(word.substring(j, j + 1));
                }

                String endWord = sb.toString();

                if (beginWord.equals(endWord))
                {
                    System.out.println(word);
                    count++;
                }
            }
        }
    }
    System.out.println(count);
 */
/*
//for (String candidateHWord2 : crosswordSolverCandidateVWord1.gethWordMap().get(1))
                {
                    String candidateHWord2 = "AXLE ERIE DEERE";
                    CrosswordSolver crosswordSolverCandidateHWord2 = crosswordSolverCandidateVWord1.clone();
                    refineVWordsFurther1(crosswordSolverCandidateHWord2);
                    removeRedundantHWords(crosswordSolverCandidateHWord2);

                    if (crosswordSolverCandidateHWord2.possibleSolution())
                    {
                        for (String candidateHWord3 : crosswordSolverCandidateHWord2.gethWordMap().get(2))
                        {
                            CrosswordSolver crosswordSolverCandidateHWord3 = crosswordSolverCandidateHWord2.clone();
                            refineVWordsFurther1(crosswordSolverCandidateHWord3);
                            removeRedundantHWords(crosswordSolverCandidateHWord3);

                            if (crosswordSolverCandidateHWord3.possibleSolution())
                            {
                                for (String candidateHWord4 : crosswordSolverCandidateHWord3.gethWordMap().get(3))
                                {
                                    CrosswordSolver crosswordSolverCandidateHWord4 = crosswordSolverCandidateHWord3.clone();
                                    refineVWordsFurther1(crosswordSolverCandidateHWord4);
                                    removeRedundantHWords(crosswordSolverCandidateHWord4);

                                    if (crosswordSolverCandidateHWord4.possibleSolution())
                                    {

                                    }
                                }

                            }
                        }
                    }
                }
 */
