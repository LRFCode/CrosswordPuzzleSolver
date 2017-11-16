package com.arkansascodingacademy;

import java.util.HashSet;
import java.util.Set;

public class CrosswordSolver implements Cloneable
{
    private Set<String> hWord1Candidates = new HashSet<>();
    private Set<String> hWord2Candidates = new HashSet<>();
    private Set<String> hWord3Candidates = new HashSet<>();
    private Set<String> hWord4Candidates = new HashSet<>();
    private Set<String> vWord1Candidates = new HashSet<>();
    private Set<String> vWord2Candidates = new HashSet<>();
    private Set<String> vWord3Candidates = new HashSet<>();
    private Set<String> vWord4Candidates = new HashSet<>();

    public CrosswordSolver(Set<String> hWordSet, Set<String> vWordSet)
    {
        hWord1Candidates = hWordSet;
        hWord2Candidates = hWordSet;
        hWord3Candidates = hWordSet;
        hWord4Candidates = hWordSet;
        vWord1Candidates = vWordSet;
        vWord2Candidates = vWordSet;
        vWord3Candidates = vWordSet;
        vWord4Candidates = vWordSet;
    }

    private CrosswordSolver()
    {
    }

    public Set<String> gethWord1Candidates()
    {
        return hWord1Candidates;
    }

    public void sethWord1Candidates(Set<String> hWord1Candidates)
    {
        this.hWord1Candidates = hWord1Candidates;
    }

    public Set<String> gethWord2Candidates()
    {
        return hWord2Candidates;
    }

    public void sethWord2Candidates(Set<String> hWord2Candidates)
    {
        this.hWord2Candidates = hWord2Candidates;
    }

    public Set<String> gethWord3Candidates()
    {
        return hWord3Candidates;
    }

    public void sethWord3Candidates(Set<String> hWord3Candidates)
    {
        this.hWord3Candidates = hWord3Candidates;
    }

    public Set<String> gethWord4Candidates()
    {
        return hWord4Candidates;
    }

    public void sethWord4Candidates(Set<String> hWord4Candidates)
    {
        this.hWord4Candidates = hWord4Candidates;
    }

    public Set<String> getvWord1Candidates()
    {
        return vWord1Candidates;
    }

    public void setvWord1Candidates(Set<String> vWord1Candidates)
    {
        this.vWord1Candidates = vWord1Candidates;
    }

    public Set<String> getvWord2Candidates()
    {
        return vWord2Candidates;
    }

    public void setvWord2Candidates(Set<String> vWord2Candidates)
    {
        this.vWord2Candidates = vWord2Candidates;
    }

    public Set<String> getvWord3Candidates()
    {
        return vWord3Candidates;
    }

    public void setvWord3Candidates(Set<String> vWord3Candidates)
    {
        this.vWord3Candidates = vWord3Candidates;
    }

    public Set<String> getvWord4Candidates()
    {
        return vWord4Candidates;
    }

    public void setvWord4Candidates(Set<String> vWord4Candidates)
    {
        this.vWord4Candidates = vWord4Candidates;
    }

    public CrosswordSolver clone()
    {
        CrosswordSolver crosswordSolver = new CrosswordSolver();
        crosswordSolver.sethWord1Candidates(new HashSet(hWord1Candidates));
        crosswordSolver.sethWord2Candidates(new HashSet(hWord2Candidates));
        crosswordSolver.sethWord3Candidates(new HashSet(hWord3Candidates));
        crosswordSolver.sethWord4Candidates(new HashSet(hWord4Candidates));
        crosswordSolver.setvWord1Candidates(new HashSet(vWord1Candidates));
        crosswordSolver.setvWord2Candidates(new HashSet(vWord2Candidates));
        crosswordSolver.setvWord3Candidates(new HashSet(vWord3Candidates));
        crosswordSolver.setvWord4Candidates(new HashSet(vWord4Candidates));

        return crosswordSolver;
    }

    public boolean possibleSolution()
    {
        return
               gethWord2Candidates().size() > 0 &&
               gethWord3Candidates().size() > 0 &&
               gethWord4Candidates().size() > 0 &&
               getvWord1Candidates().size() > 0 &&
               getvWord2Candidates().size() > 0 &&
               getvWord3Candidates().size() > 0 &&
               getvWord4Candidates().size() > 0;
    }

    public boolean isSolution()
    {
        return
                        getvWord2Candidates().size() == 1 &&
                        getvWord3Candidates().size() == 1 &&
                        getvWord4Candidates().size() == 1;
    }

}
