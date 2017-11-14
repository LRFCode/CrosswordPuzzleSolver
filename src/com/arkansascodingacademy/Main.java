package com.arkansascodingacademy;


import java.io.File;
import java.nio.file.Path;

public class Main
{

    public static void main(String[] args)
    {
        Path filePath = new File("wordsEn.txt").toPath();

        Dictionary dictionary = new Dictionary(filePath);

        System.out.println(dictionary);

        Object word[] = dictionary.getWordSet(4).toArray();

        for (Object candidateHObject : word)
        {
            String candidateHWord = (String)candidateHObject;

            String vWord1 = possibleWord(word, candidateHWord, 0);
            String vWord2 = possibleWord(word, candidateHWord, 1);
            String vWord3 = possibleWord(word, candidateHWord, 2);
            String vWord4 = possibleWord(word, candidateHWord, 3);

            if (vWord1 != null && vWord2 != null && vWord3 != null && vWord4 != null && horizontalWordsValid(dictionary,vWord1,vWord2,vWord3,vWord4))
            {
                System.out.println("Success!");
                System.out.println(candidateHWord + " " + vWord1 + " " + vWord2 + " " + vWord3 + " " + vWord4);
                break;
            }

        }
    }

    private static boolean horizontalWordsValid(Dictionary dictionary, String vWord1, String vWord2, String vWord3, String vWord4)
    {
        String hWord2 = vWord1.substring(1,2) + vWord2.substring(1,2) + vWord3.substring(1,2) + vWord4.substring(1,2);
        String hWord3 = vWord1.substring(2,3) + vWord2.substring(2,3) + vWord3.substring(2,3) + vWord4.substring(2,3);
        String hWord4 = vWord1.substring(3,4) + vWord2.substring(3,4) + vWord3.substring(3,4) + vWord4.substring(3,4);

        return dictionary.wordExists(hWord2) && dictionary.wordExists(hWord3) && dictionary.wordExists(hWord4);

    }


    private static String possibleWord(Object word[], String horizontalWord, int index)
    {
        for (Object candidateVObject : word)
        {
            String vWord = (String)candidateVObject;
            if (horizontalWord.substring(index,index+1).equals(vWord.substring(0,1)))
            {
                return vWord;
            }

        }

        return null;
    }
}
