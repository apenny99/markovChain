import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class markovChain {
    ArrayDictionary main = new ArrayDictionary();
    private int counter=0;
    private int numWords=0;
    private String finalString="";

    private void fileToDictionary(String fileName) throws FileNotFoundException {
        File qF=new File(fileName);
        Scanner fR=new Scanner(qF);
        while(fR.hasNextLine()){
            String temp=fR.nextLine();
            String[] tmpArr = temp.split(" ");
            for(int i=0;i<tmpArr.length-1;i++){
//                if(tmpArr[i].indexOf(".")>-1){
//                    tmpArr[i].replace('.',' ');
//                }
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



    public String genString(int words, String startWord){
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
        return finalString;

    }

    public static void main(String[] args) throws FileNotFoundException {
        markovChain m = new markovChain();
        m.fileToDictionary("test.txt");
        System.out.println(m.genString(100, "down"));
    }


    
}
