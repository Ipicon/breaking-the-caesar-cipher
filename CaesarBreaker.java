import edu.duke.*;
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarBreaker {
    public String decrypt(String encrypted,int key) {
        CaesarCipher cc = new CaesarCipher();
        String message = cc.encrypt(encrypted,26-key);
        return message;
    }
    public String halfOfString(String message,int start) {
        StringBuilder sb = new StringBuilder(message);
        for(int i=0; i<message.length(); i++) {
            char ch = sb.charAt(i);
            if(i<start)
                sb.setCharAt(i,'\0');
            else {
            if((start-i) % 2 == 0) 
                sb.setCharAt(i,ch);
            
            else
                sb.setCharAt(i,'\0');
            }
        }
        return sb.toString();
    }
    public int[] countLetters(String s) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        int[] array = new int[26];
        for(int i = 0; i<s.length() ; i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            int index = abc.indexOf(ch);
            if(index !=-1)
                array[index]++;
        }
        return array;
    }
    public int maxIndex(int[] array) {
        int index = 0;
        int indexCounter =0;
        for(int i = 0 ; i<array.length ; i++) {
            if(i==0) {
                index = i;
                indexCounter = array[i];
            }
            if(array[i] > indexCounter) {
                index = i;
                indexCounter = array[i];
            }
        }
        return index;
    }
    public int getKey(String s) {
        int[] array = countLetters(s);
        int currIndex = maxIndex(array);
        int esIndex = 4;
        int key = 0;
        key = currIndex-esIndex;
        if(key < 0) 
            return 26 + key;
        return key;
    }
    public String decryptTwoKeys(String encrypted) {
        String halfFirst = halfOfString(encrypted,0);
        String halfSecond = halfOfString(encrypted,1);
        int keyFirst = getKey(halfFirst);
        int keySecond = getKey(halfSecond);
        CaesarCipher cc = new CaesarCipher();
        System.out.println("The keys used are:" + keyFirst + " and :" +keySecond);
        String message = cc.encryptTwoKeys(encrypted,26-keyFirst,26-keySecond);
        if(keyFirst == 0 && keySecond == 0) 
            System.out.println("The message is not encrypted");
        return message;
    }
    public void testDecrypt() {
        /*System.out.println(halfOfString("Qbkm Zgis",0));
        System.out.println(halfOfString("Qbkm Zgis",1));*/
        //System.out.println(decrypt("Yr lmml zc gl rfc amldcpclac pmmk ugrf wmsp fyr ml dmp y qspnpgqc nyprw. WCJJ JMSB!",24));
        //System.out.println(getKey("Hsqr y rcqr qrpgle ugrf jmrq md cccccccccccccccccq")); 
        FileResource fr = new FileResource();
        System.out.println(decryptTwoKeys(fr.asString()));   
    }
}
