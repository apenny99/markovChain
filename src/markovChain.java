/**
 * MarkovChain
 * Makes a markov chain based on strings
 * Author: August Penny
 * Collaborator(s): The names of anyone you collaborated with here
 * Collaboration: Describe the collaboration that took place
 * Date: 3/18/21
 **/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class markovChain {
    ArrayDictionary main = new ArrayDictionary();
    private int counter=0;
    private int numWords=0;
    private String finalString="";

    public void fileToDictionary(String fileName) throws FileNotFoundException {
        File qF=new File(fileName);
        Scanner fR=new Scanner(qF);
        while(fR.hasNextLine()){
            String temp=fR.nextLine();
            String[] tmpArr = temp.split(" ");
            for(int i=0;i<tmpArr.length-1;i++){
                if(!main.contains(tmpArr[i])){
                    ArrayList tmp3=new ArrayList();
                    tmp3.add(tmpArr[i+1]);
                    main.put(tmpArr[i],tmp3);
                } else if(main.contains(tmpArr[i])){
                    ArrayList tmp4= (ArrayList) main.get(tmpArr[i]);
                    tmp4.add(tmpArr[i+1]);
                }
            }
        }
    }



    public String genString(String fileToSave){
        Scanner s=new Scanner(System.in);
        System.out.println("How many words would you like your string to be?: ");
        int words=s.nextInt();//gets desired number of words
        System.out.println("What would you like your starting word to be?: ");
        String startWord=s.next();//gets desired starting word
        finalString+=startWord;
        String baseWord="";
        String genWord="";
        Random r=new Random();
        for(int i=0;i<words-1;i++){
            if(i==0){
                baseWord=startWord;
            }
            ArrayList posWrds=(ArrayList) main.get(baseWord);
            int rVal=r.nextInt(posWrds.size());
            genWord=(String) posWrds.get(rVal);

            finalString+=" ";
            finalString+=genWord;
            baseWord=genWord;

        }
        try { //writes the output string to a file
            FileWriter myWriter = new FileWriter(fileToSave);
            myWriter.write(finalString);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        return finalString;

    }




}