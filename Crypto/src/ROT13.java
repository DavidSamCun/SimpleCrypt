import java.io.*;
import java.util.Scanner;

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


        return encrypt(text);
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

        int charFirstVal = input.charAt(0);
        int charLastVal = input.charAt(input.length()-1);
        int range = charLastVal - charFirstVal;

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

        int charFirstVal = input.charAt(0);
        int charLastVal = input.charAt(input.length()-1);
        int range = input.length();
        int shift = c - charFirstVal;

        String output = "";

        for(char letter : input.toCharArray()){
            letter += shift;
                if(letter > charLastVal){
                    letter -= range;
                }
            output += (char)(letter);
        }

        return output;
        //lower case letters a = 97, z = 122
        //upper case letters A = 65, Z = 90

    } //Need to redo because it only rotates sequential alphabets, not words.

    public void encryptFile(String inputFile, String outputFile) {

        //Read and encrypt

        String encryptThis = readFile(inputFile);
        String encrypted = encrypt(encryptThis);

        //Create and output
        createFile(outputFile);
        writeFile(outputFile, encrypted);

        System.out.println("Successfully Encrypted");
    }

    public String readFile(String filename) {
        String data = "";
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data+= myReader.nextLine()+"\n";
                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(data);
        return data;
    }

    public void createFile(String filename){
        try {
            File myObj = new File("C:\\Users\\spart\\Documents\\Dev Folder\\SimpleCrypt\\" + filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeFile(String outputfile, String encrypted){
        try {
            FileWriter myWriter = new FileWriter(outputfile);
            myWriter.write(encrypted);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    //Extra crap for testing

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
    //Read Write Test


}
