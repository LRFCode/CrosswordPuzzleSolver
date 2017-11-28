package com.arkansascodingacademy;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Connector
{
    Set<String> connectorCandidates;

    public Connector(int wordLength)
    {
        Path filePath = new File("wordsEn.txt").toPath();
        Dictionary dictionary = new Dictionary(filePath);

        connectorCandidates = dictionary.getWordSet(wordLength);
    }

    public Set<String> getConnectorCandidates()
    {
        return connectorCandidates;
    }

    public void setConnectorCandidates(Set<String> connectorCandidates)
    {
        this.connectorCandidates = connectorCandidates;
    }
}
