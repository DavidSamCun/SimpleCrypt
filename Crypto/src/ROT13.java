import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    private static int shiftDif;

    ROT13(Character cs, Character cf) {

        shiftDif = cf - cs;

    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {
        String output = "";


        for(char a : text.toCharArray()){
            output += (char)(a + 1);
        }

        return output;
    }

    public String encrypt(String input) {

        String output = "";

        for(char letter : input.toCharArray()){
            if (letter >= 97 && letter <= 122){
                letter += shiftDif;
                if(letter > 122){
                    letter -= 26;
                }
            }
            if (letter >= 65 && letter <= 90){
                letter += shiftDif;
                if(letter > 90){
                    letter-=26;
                }
            }
            output += (char)(letter);
        }

        return output;
        //lower case letters a = 97, z = 122
        //upper case letters A = 65, Z = 90

    }

    public String decrypt(String input) {
        String output = "";

        for(char letter : input.toCharArray()){
            if (letter >= 97 && letter <= 122){
                letter -= shiftDif;
                if(letter < 97){
                    letter += 26;
                }
            }
            if (letter >= 65 && letter <= 90){
                letter -= shiftDif;
                if(letter < 65){
                    letter+=26;
                }
            }
            output += (char)(letter);
        }

        return output;
    }

    public static String rotate(String input, Character c) {

        shiftDif = c - 'A';

        int shift = c - 'A';

        String output = "";

        for(char letter : input.toCharArray()){
            if (letter >= 97 && letter <= 122){
                letter += shift;
                if(letter > 122){
                    letter -= 26;
                }
            }
            if (letter >= 65 && letter <= 90){
                letter += shift;
                if(letter > 90){
                    letter-=26;
                }
            }
            output += (char)(letter);
        }

        return output;
        //lower case letters a = 97, z = 122
        //upper case letters A = 65, Z = 90

    }

    public int getShiftDif(){
        return shiftDif;
    }

    public String encryptfromQuiz(String word) {

        String output = "";      //( (87 <= letter && letter <=90) || (120 <= letter || letter <=122))

        for (char letter : word.toCharArray())//for each loop

            if (letter == 32){
                output+= (char)(letter);
            } else if ( (87 <= letter && letter <=90) || (120 <= letter && letter <=122)){    //if   characters are x y and z
                output += (char)(letter -23);
            } else {                                                                          //all   other alphabetical characters
                output += (char) (letter + 3);
            }
        System.out.println(output);       //testing purposes
        return output;
    }

    public String reWriteCode(String input, int shift){

        String outputTest = "";
        for(char letter : input.toCharArray()){
            if (letter >= 97 && letter <= 122){
                letter += shift;
                if(letter > 122){
                    letter -= 26;
                }
            }
            if (letter >= 65 && letter <= 90){
                letter += shift;
                if(letter > 90){
                    letter-=26;
                }
            }
            outputTest += (char)(letter);
        }

        //lower case letters a = 97, z = 122
        //upper case letters A = 65, Z = 90

        return outputTest;
    }

}
