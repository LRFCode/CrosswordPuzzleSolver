package com.arkansascodingacademy;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class Main
{
    private static int count = 0;

    public static void main(String[] args)
    {
        /*Path filePath = new File("wordsEn.txt").toPath();
        Dictionary dictionary = new Dictionary(filePath);

        Set<String> hWordSet3 = dictionary.getWordSet(3);
        Set<String> hWordSet4 = dictionary.getWordSet(4);
        Set<String> hWordSet6 = dictionary.getWordSet(6);
        Set<String> hWordSet15 = dictionary.getWordSet(15);

        Set<String> vWordSet3 = dictionary.getWordSet(3);
        Set<String> vWordSet5 = dictionary.getWordSet(5);
        Set<String> vWordSet10 = dictionary.getWordSet(10);

        CrosswordSolver crosswordSolver = new CrosswordSolver();
        crosswordSolver.gethWordMap().put(0, hWordSet4);

        for (String candidateHWord1 : crosswordSolver.gethWordMap().get(0))
        {
            CrosswordSolver crosswordSolverHWord1 = crosswordSolver.clone();
            crosswordSolverHWord1.addhWordCandidate(candidateHWord1);

            for (int i = 0; i < 2; i++)
            {
                Set<String> wordSet = new HashSet<>();

                for (String candidateVWord1 : vWordSet5)
                {
                    if (candidateHWord1.substring(i, i + 1).equals(candidateVWord1.substring(0, 1)))
                    {
                        wordSet.add(candidateVWord1);
                    }
                }
                crosswordSolverHWord1.getvWordMap().put(i, wordSet);
            }

            for (int i = 2; i < 3; i++)
            {
                Set<String> wordSet = new HashSet<>();

                for (String candidateVWord1 : vWordSet10)
                {
                    if (candidateHWord1.substring(i, i + 1).equals(candidateVWord1.substring(0, 1)))
                    {
                        wordSet.add(candidateVWord1);
                    }
                }
                crosswordSolverHWord1.getvWordMap().put(i, wordSet);
            }

            for (int i = 3; i < candidateHWord1.length(); i++)
            {
                Set<String> wordSet = new HashSet<>();

                for (String candidateVWord1 : vWordSet3)
                {
                    if (candidateHWord1.substring(i, i + 1).equals(candidateVWord1.substring(0, 1)))
                    {
                        wordSet.add(candidateVWord1);
                    }
                }
                crosswordSolverHWord1.getvWordMap().put(i, wordSet);
            }

            if (crosswordSolverHWord1.getvWordMap().get(0).size() > 0 && crosswordSolverHWord1.getvWordMap().get(1).size() > 0 && crosswordSolverHWord1.getvWordMap().get(2).size() > 0 && crosswordSolverHWord1.getvWordMap().get(3).size() > 0)
            {
                for (String candidateVWord1 : crosswordSolverHWord1.getvWordMap().get(0))
                {
                    CrosswordSolver crosswordSolverCandidateVWord1 = crosswordSolverHWord1.clone();

                    for (int i = 1; i < 2; i++)
                    {
                        Set<String> wordSet = new HashSet<>();

                        for (String candidateHWord2 : hWordSet4)
                        {
                            if (candidateVWord1.substring(i, i + 1).equals(candidateHWord2.substring(0, 1)))
                            {
                                wordSet.add(candidateHWord2);
                            }
                        }

                        crosswordSolverCandidateVWord1.gethWordMap().put(i, wordSet);
                    }
                    for (int i = 2; i < 3; i++)
                    {
                        Set<String> wordSet = new HashSet<>();

                        for (String candidateHWord3 : hWordSet15)
                        {
                            if (candidateVWord1.substring(i, i + 1).equals(candidateHWord3.substring(0, 1)))
                            {
                                wordSet.add(candidateHWord3);
                            }
                        }

                        crosswordSolverCandidateVWord1.gethWordMap().put(i, wordSet);
                    }
                    for (int i = 3; i < 4; i++)
                    {
                        Set<String> wordSet = new HashSet<>();

                        for (String candidateHWord4 : hWordSet3)
                        {
                            if (candidateVWord1.substring(i, i + 1).equals(candidateHWord4.substring(0, 1)))
                            {
                                wordSet.add(candidateHWord4);
                            }
                        }

                        crosswordSolverCandidateVWord1.gethWordMap().put(i, wordSet);
                    }
                    for (int i = 4; i < candidateVWord1.length(); i++)
                    {
                        Set<String> wordSet = new HashSet<>();

                        for (String candidateHWord5 : hWordSet6)
                        {
                            if (candidateVWord1.substring(i, i + 1).equals(candidateHWord5.substring(0, 1)))
                            {
                                wordSet.add(candidateHWord5);
                            }
                        }
                        crosswordSolverCandidateVWord1.gethWordMap().put(i, wordSet);
                    }

                    if (crosswordSolverCandidateVWord1.gethWordMap().get(0).size() > 0 && crosswordSolverCandidateVWord1.gethWordMap().get(1).size() > 0 && crosswordSolverCandidateVWord1.gethWordMap().get(2).size() > 0 && crosswordSolverCandidateVWord1.gethWordMap().get(3).size() > 0 && crosswordSolverCandidateVWord1.gethWordMap().get(4).size() > 0)
                    {
                        for (String candidateHWord2 : crosswordSolverCandidateVWord1.gethWordMap().get(1))
                        {
                            CrosswordSolver crosswordSolverCandidateHWord2 = crosswordSolverCandidateVWord1.clone();
                            crosswordSolverCandidateHWord2.addhWordCandidate(candidateHWord2);

                            for (int i = 1; i < 4; i++)
                            {
                                Set<String> vWordsRefined = new HashSet<>();

                                String searchWord = searchWord(i, crosswordSolverCandidateHWord2.gethWordCandidates());

                                for (String candidateVWord : crosswordSolverCandidateHWord2.getvWordMap().get(i))
                                {
                                    if (candidateVWord.substring(0, crosswordSolverCandidateHWord2.gethWordCandidates().size()).equals(searchWord))
                                    {
                                        vWordsRefined.add(candidateVWord);
                                    }
                                }

                                crosswordSolverCandidateHWord2.getvWordMap().put(i, vWordsRefined);
                            }

                            if (crosswordSolverCandidateHWord2.getvWordMap().get(1).size() > 0 && crosswordSolverCandidateHWord2.getvWordMap().get(2).size() > 0 && crosswordSolverCandidateHWord2.getvWordMap().get(3).size() > 0)
                            {
                                for (String candidateHWord3 : crosswordSolverCandidateHWord2.gethWordMap().get(2))
                                {
                                    CrosswordSolver crosswordSolverCandidateHWord3 = crosswordSolverCandidateHWord2.clone();
                                    crosswordSolverCandidateHWord3.addhWordCandidate(candidateHWord3);

                                    for (int i = 1; i < 4; i++)
                                    {
                                        Set<String> vWordsRefined = new HashSet<>();

                                        String searchWord = searchWord(i, crosswordSolverCandidateHWord3.gethWordCandidates());

                                        for (String candidateVWord : crosswordSolverCandidateHWord3.getvWordMap().get(i))
                                        {
                                            if (candidateVWord.substring(0, crosswordSolverCandidateHWord3.gethWordCandidates().size()).equals(searchWord))
                                            {
                                                vWordsRefined.add(candidateVWord);
                                            }
                                        }

                                        crosswordSolverCandidateHWord3.getvWordMap().put(i, vWordsRefined);
                                    }
                                    if (crosswordSolverCandidateHWord3.getvWordMap().get(1).size() > 0 && crosswordSolverCandidateHWord3.getvWordMap().get(2).size() > 0 && crosswordSolverCandidateHWord3.getvWordMap().get(3).size() > 0)
                                    {
                                        for (String candidateHWord4 : crosswordSolverCandidateHWord3.gethWordMap().get(3))
                                        {
                                            CrosswordSolver crosswordSolverCandidateHWord4 = crosswordSolverCandidateHWord3.clone();
                                            crosswordSolverCandidateHWord4.addhWordCandidate(candidateHWord4);

                                            for (int i = 1; i < 3; i++)
                                            {
                                                Set<String> vWordsRefined = new HashSet<>();

                                                String searchWord = searchWord(i, crosswordSolverCandidateHWord4.gethWordCandidates());

                                                for (String candidateVWord : crosswordSolverCandidateHWord4.getvWordMap().get(i))
                                                {
                                                    if (candidateVWord.substring(0, crosswordSolverCandidateHWord4.gethWordCandidates().size()).equals(searchWord))
                                                    {
                                                        vWordsRefined.add(candidateVWord);
                                                    }
                                                }

                                                crosswordSolverCandidateHWord4.getvWordMap().put(i, vWordsRefined);
                                            }
                                            if (crosswordSolverCandidateHWord4.getvWordMap().get(1).size() > 0 && crosswordSolverCandidateHWord4.getvWordMap().get(2).size() > 0 && crosswordSolverCandidateHWord4.getvWordMap().get(3).size() > 0)
                                            {
                                                for (String candidateHWord5 : crosswordSolverCandidateHWord4.gethWordMap().get(4))
                                                {
                                                    CrosswordSolver crosswordSolverCandidateHWord5 = crosswordSolverCandidateHWord4.clone();
                                                    crosswordSolverCandidateHWord5.addhWordCandidate(candidateHWord5);

                                                    for (int i = 1; i < 3; i++)
                                                    {
                                                        Set<String> vWordsRefined = new HashSet<>();

                                                        String searchWord = searchWord(i, crosswordSolverCandidateHWord5.gethWordCandidates());

                                                        for (String candidateVWord : crosswordSolverCandidateHWord5.getvWordMap().get(i))
                                                        {
                                                            if (candidateVWord.substring(0, crosswordSolverCandidateHWord5.gethWordCandidates().size()).equals(searchWord))
                                                            {
                                                                vWordsRefined.add(candidateVWord);
                                                            }
                                                        }

                                                        crosswordSolverCandidateHWord5.getvWordMap().put(i, vWordsRefined);
                                                    }
                                                    if (crosswordSolverCandidateHWord5.getvWordMap().get(1).size() > 0 && crosswordSolverCandidateHWord5.getvWordMap().get(2).size() > 0 && crosswordSolverCandidateHWord5.getvWordMap().get(3).size() > 0)
                                                    {
                                                        System.out.println("Success!");
                                                        for(String finalHWord : crosswordSolverCandidateHWord5.gethWordCandidates())
                                                        {
                                                            System.out.println(finalHWord);
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
            }
        }
        */

       CrosswordSolver cs = new CrosswordSolver(15,2);
       refineHAndVWords(cs, 2);
    }

    private static void refineHAndVWords(CrosswordSolver crosswordSolver, int vLength)
    {
        for (String candidateHWord1 : crosswordSolver.gethWordMap().get(0))
        //String candidateHWord1 = "SPOTS";
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
                    count++;
                    System.out.println(count);
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
