import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
public class markovChain {
    ArrayDictionary main = new ArrayDictionary();

    private void fileToDictionary(String fileName) throws FileNotFoundException {
        File qF=new File(fileName);
        Scanner fR=new Scanner(qF);
        while(fR.hasNextLine()){
            String temp=fR.nextLine();
            String[] tmpArr = temp.split(" ");
            for(int i=0;i< tmpArr.length-1;i++){
                String key = tmpArr[i];
                String followWord = tmpArr[i+1];
                if(main.contains(key)){
                    ArrayList tmp = (ArrayList) main.remove(key);
                    tmp.add(followWord);
                    main.put(key,tmp);
                }
                if(main.contains(key)==false){
                    ArrayList tmp = new ArrayList();
                    tmp.add(followWord);
                    main.put(key,tmp);
                }


            }


        }
        System.out.println(main.values());

    }

    public static void main(String[] args) throws FileNotFoundException {
        markovChain m = new markovChain();
        m.fileToDictionary("test.txt");


    }

    
}
