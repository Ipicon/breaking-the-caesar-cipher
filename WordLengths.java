import edu.duke.*;
import java.io.*;
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {
    public void countWordLengths(FileResource resource,int[] counts) {
        String[] countsWords = new String[counts.length];
        for(String words : resource.words()) {
            StringBuilder sb = new StringBuilder(words);
            int wordRealLength = words.length();
            int startIndex =0;
            int endIndex = words.length();
            for(int i = 0; i<words.length();i++) {
                char ch = sb.charAt(i);
                if(!Character.isLetter(ch) && i ==0){
                    wordRealLength --;
                    startIndex++;
                }
                if(!Character.isLetter(ch) && i ==(words.length()-1)){
                    wordRealLength --;
                    endIndex--;
                }
            }
            if(wordRealLength > 30){
                counts[30]++;
                if(countsWords[30] == null)
                   countsWords[30] = words.substring(startIndex,endIndex); 
                else
                    countsWords[30] += " " + words.substring(startIndex,endIndex);
            }
            else{
                counts[wordRealLength]++;
                if(countsWords[wordRealLength] == null)
                   countsWords[wordRealLength] = words.substring(startIndex,endIndex);
                else
                    countsWords[wordRealLength] += " " + words.substring(startIndex,endIndex);
            }
        }
        for(int i=0;i<counts.length;i++) {
            if(counts[i] != 0) {
                System.out.println(counts[i] + " words of the length " + i +": " + countsWords[i]);
            }
        }
    }
    public int  indexOfMax(int[] values) {
        int longest = 0;
        int longestCounter = 0;
        for(int i = 0; i<values.length;i++) {
            if(i==0) { 
                longest = i;
                longestCounter = values[i];
            }
            if(values[i] > longestCounter) {
                longest = i;
                longestCounter = values[i];
            }
        }
        return longest;
    }
    public void testCountWordLengths() {
        FileResource fr = new FileResource();
        int [] array = new int[31];
        countWordLengths(fr,array);
        System.out.println("The most common word length is: " + indexOfMax(array));
    }
}
