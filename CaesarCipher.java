
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    public String encrypt (String input, int key) {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(abc);
        String abcNew = abc.substring(key) + abc.substring(0,key);
        String newPhrase = "";
        for(int i =0; i<input.length(); i++) {
            char chCurr = input.charAt(i);
            char chCurrHigh = Character.toUpperCase(chCurr);
            char ch = chCurr;
            if(Character.isAlphabetic(chCurr)) {
                int index = abc.indexOf(chCurr);
                if(index == -1 ) {
                    index = abc.indexOf(chCurrHigh);
                    ch = abcNew.charAt(index);
                    ch = Character.toLowerCase(ch);
                }
                else 
                    ch = abcNew.charAt(index);
            }
            newPhrase += ch;
        }
        return newPhrase;
    }
    public String encryptTwoKeys(String input,int key1,int key2) {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(abc);
        String abcNew = abc.substring(key1) + abc.substring(0,key1);
        String abcNew2 = abc.substring(key2) + abc.substring(0,key2);
        String newPhrase = "";
        for(int i =0; i<input.length(); i++) {
            char chCurr = input.charAt(i);
            char chCurrHigh = Character.toUpperCase(chCurr);
            char ch = chCurr;
            if((i+1) % 2 != 0) {
                if(Character.isAlphabetic(chCurr)) {
                    int index = abc.indexOf(chCurr);
                    if(index == -1 ) {
                        index = abc.indexOf(chCurrHigh);
                        ch = abcNew.charAt(index);
                        ch = Character.toLowerCase(ch);
                    }
                    else 
                        ch = abcNew.charAt(index);
                }
            }
            else {
                if(Character.isAlphabetic(chCurr)) {
                    int index = abc.indexOf(chCurr);
                    if(index == -1 ) {
                        index = abc.indexOf(chCurrHigh);
                        ch = abcNew2.charAt(index);
                        ch = Character.toLowerCase(ch);
                    }
                    else 
                        ch = abcNew2.charAt(index);
                }
            }
            newPhrase += ch;
        }
        return newPhrase;
    }
    public void testCaesar() {
        //System.out.println(encrypt("Just a test string with lots of eeeeeeeeeeeeeeeees",24));
        System.out.println(encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx",24,6));
    }
}
