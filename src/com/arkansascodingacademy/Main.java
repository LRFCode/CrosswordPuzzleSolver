package com.arkansascodingacademy;

import java.io.File;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        Path filePath = new File("wordsEn.txt").toPath();
        Dictionary dictionary = new Dictionary(filePath);

        int hLength = 4;
        int vLength = 4;

        Set<String> hWordSet = dictionary.getWordSet(hLength);
        Set<String> vWordSet = dictionary.getWordSet(vLength);

        CrosswordSolver crosswordSolver = new CrosswordSolver(hWordSet, vWordSet);

        List<String> hWord1Candidates = new ArrayList<String>(crosswordSolver.gethWord1Candidates());

        for (String candidateHWord1 : hWord1Candidates)
        {
            candidateHWord1 = "DIGS";

            crosswordSolver.setvWord1Candidates(vWordPossibilities(hWord1Candidates, candidateHWord1, 0));
            crosswordSolver.setvWord2Candidates(vWordPossibilities(hWord1Candidates, candidateHWord1, 1));
            crosswordSolver.setvWord3Candidates(vWordPossibilities(hWord1Candidates, candidateHWord1, 2));
            crosswordSolver.setvWord4Candidates(vWordPossibilities(hWord1Candidates, candidateHWord1, 3));

            if (crosswordSolver.getvWord1Candidates().size() > 0 && crosswordSolver.getvWord2Candidates().size() > 0 && crosswordSolver.getvWord3Candidates().size() > 0 && crosswordSolver.getvWord4Candidates().size() > 0)
            {
                for (String candidateVWord1 : crosswordSolver.getvWord1Candidates())
                {
                    crosswordSolver.sethWord2Candidates(hWordPossibilities(hWord1Candidates, candidateVWord1, 1));
                    crosswordSolver.sethWord3Candidates(hWordPossibilities(hWord1Candidates, candidateVWord1, 2));
                    crosswordSolver.sethWord4Candidates(hWordPossibilities(hWord1Candidates, candidateVWord1, 3));

                    if (crosswordSolver.gethWord2Candidates().size() > 0 && crosswordSolver.gethWord3Candidates().size() > 0 && crosswordSolver.gethWord4Candidates().size() > 0)
                    {
                        for (String candidateHWord2 : crosswordSolver.gethWord2Candidates())
                        {
                            Map<Integer, Set<String>> vWordPossiblesRefined1 = wordPossibilitiesRefined1(crosswordSolver, candidateHWord1, candidateHWord2);

                            crosswordSolver.setvWord2Candidates(vWordPossiblesRefined1.get(0));
                            crosswordSolver.setvWord3Candidates(vWordPossiblesRefined1.get(1));
                            crosswordSolver.setvWord4Candidates(vWordPossiblesRefined1.get(2));

                            if (crosswordSolver.getvWord2Candidates().size() > 0 && crosswordSolver.getvWord3Candidates().size() > 0 && crosswordSolver.getvWord4Candidates().size() > 0)
                            {
                                for (String candidateHWord3 : crosswordSolver.gethWord3Candidates())
                                {
                                    Map<Integer, Set<String>> vWordPossiblesRefined2 = wordPossibilitiesRefined2(crosswordSolver, candidateHWord1, candidateHWord2, candidateHWord3);

                                    crosswordSolver.setvWord2Candidates(vWordPossiblesRefined2.get(0));
                                    crosswordSolver.setvWord3Candidates(vWordPossiblesRefined2.get(1));
                                    crosswordSolver.setvWord4Candidates(vWordPossiblesRefined2.get(2));

                                    if (crosswordSolver.getvWord2Candidates().size() > 0 && crosswordSolver.getvWord3Candidates().size() > 0 && crosswordSolver.getvWord4Candidates().size() > 0)
                                    {
                                        for (String candidateHWord4 : crosswordSolver.gethWord4Candidates())
                                        {
                                            Map<Integer, Set<String>> vWordPossiblesRefined3 = wordPossibilitiesRefined3(crosswordSolver, candidateHWord1, candidateHWord2, candidateHWord3, candidateHWord4);

                                            crosswordSolver.setvWord2Candidates(vWordPossiblesRefined3.get(0));
                                            crosswordSolver.setvWord3Candidates(vWordPossiblesRefined3.get(1));
                                            crosswordSolver.setvWord4Candidates(vWordPossiblesRefined3.get(2));

                                            if (crosswordSolver.getvWord2Candidates().size() > 0 && crosswordSolver.getvWord3Candidates().size() > 0 && crosswordSolver.getvWord4Candidates().size() > 0)
                                            {
                                                System.out.println("***************");
                                                System.out.println("Success!");
                                                System.out.println("vWord 1: " + candidateVWord1);
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

    private static Map<Integer, Set<String>> wordPossibilitiesRefined1(CrosswordSolver crosswordSolver, String candidateHWord1, String candidateHWord2)
    {
        Set<String> vWord2Possibles = new HashSet<>();
        Set<String> vWord3Possibles = new HashSet<>();
        Set<String> vWord4Possibles = new HashSet<>();

        for (String candidateVWord2 : crosswordSolver.getvWord2Candidates())
        {
            String searchVWord2 = candidateHWord1.substring(1, 2) + candidateHWord2.substring(1, 2);

            if (candidateVWord2.substring(0, 2).equals(searchVWord2))
            {
                for (String candidateVWord3 : crosswordSolver.getvWord3Candidates())
                {
                    String searchVWord3 = candidateHWord1.substring(2, 3) + candidateHWord2.substring(2, 3);

                    if (candidateVWord3.substring(0, 2).equals(searchVWord3))
                    {
                        for (String candidateVWord4 : crosswordSolver.getvWord4Candidates())
                        {
                            String searchVWord4 = candidateHWord1.substring(3, 4) + candidateHWord2.substring(3, 4);

                            if (candidateVWord4.substring(0, 2).equals(searchVWord4))
                            {
                                vWord2Possibles.add(candidateVWord2);
                                vWord3Possibles.add(candidateVWord3);
                                vWord4Possibles.add(candidateVWord4);
                            }
                        }
                    }
                }
            }
        }

        Map<Integer, Set<String>> map = new HashMap<>();

        map.put(0, vWord2Possibles);
        map.put(1, vWord3Possibles);
        map.put(2, vWord4Possibles);

        return map;
    }

    private static Map<Integer, Set<String>> wordPossibilitiesRefined2(CrosswordSolver crosswordSolver, String candidateHWord1, String candidateHWord2, String candidateHWord3)
    {
        Set<String> vWord2Possibles = new HashSet<>();
        Set<String> vWord3Possibles = new HashSet<>();
        Set<String> vWord4Possibles = new HashSet<>();

        for (String candidateVWord2 : crosswordSolver.getvWord2Candidates())
        {
            String searchVWord2 = candidateHWord1.substring(1, 2) + candidateHWord2.substring(1, 2) + candidateHWord3.substring(1, 2);

            if (candidateVWord2.substring(0, 3).equals(searchVWord2))
            {
                for (String candidateVWord3 : crosswordSolver.getvWord3Candidates())
                {
                    String searchVWord3 = candidateHWord1.substring(2, 3) + candidateHWord2.substring(2, 3) + candidateHWord3.substring(2, 3);

                    if (candidateVWord3.substring(0, 3).equals(searchVWord3))
                    {
                        for (String candidateVWord4 : crosswordSolver.getvWord4Candidates())
                        {
                            String searchVWord4 = candidateHWord1.substring(3, 4) + candidateHWord2.substring(3, 4) + candidateHWord3.substring(3, 4);

                            if (candidateVWord4.substring(0, 3).equals(searchVWord4))
                            {
                                vWord2Possibles.add(candidateVWord2);
                                vWord3Possibles.add(candidateVWord3);
                                vWord4Possibles.add(candidateVWord4);
                            }
                        }
                    }
                }
            }
        }

        Map<Integer, Set<String>> map = new HashMap<>();

        map.put(0, vWord2Possibles);
        map.put(1, vWord3Possibles);
        map.put(2, vWord4Possibles);

        return map;
    }

    private static Map<Integer, Set<String>> wordPossibilitiesRefined3(CrosswordSolver crosswordSolver, String candidateHWord1, String candidateHWord2, String candidateHWord3, String candidateHWord4)
    {
        Set<String> vWord2Possibles = new HashSet<>();
        Set<String> vWord3Possibles = new HashSet<>();
        Set<String> vWord4Possibles = new HashSet<>();

        for (String candidateVWord2 : crosswordSolver.getvWord2Candidates())
        {
            String searchVWord2 = candidateHWord1.substring(1, 2) + candidateHWord2.substring(1, 2) + candidateHWord3.substring(1, 2) + candidateHWord4.substring(1, 2);

            if (candidateVWord2.substring(0, 4).equals(searchVWord2))
            {
                for (String candidateVWord3 : crosswordSolver.getvWord3Candidates())
                {
                    String searchVWord3 = candidateHWord1.substring(2, 3) + candidateHWord2.substring(2, 3) + candidateHWord3.substring(2, 3) + candidateHWord4.substring(2, 3);

                    if (candidateVWord3.substring(0, 4).equals(searchVWord3))
                    {
                        for (String candidateVWord4 : crosswordSolver.getvWord4Candidates())
                        {
                            String searchVWord4 = candidateHWord1.substring(3, 4) + candidateHWord2.substring(3, 4) + candidateHWord3.substring(3, 4) + candidateHWord4.substring(3, 4);

                            if (candidateVWord4.substring(0, 4).equals(searchVWord4))
                            {
                                vWord2Possibles.add(candidateVWord2);
                                vWord3Possibles.add(candidateVWord3);
                                vWord4Possibles.add(candidateVWord4);
                            }
                        }
                    }
                }
            }
        }

        Map<Integer, Set<String>> map = new HashMap<>();

        map.put(0, vWord2Possibles);
        map.put(1, vWord3Possibles);
        map.put(2, vWord4Possibles);

        return map;
    }
}
