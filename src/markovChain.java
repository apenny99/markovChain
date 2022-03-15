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

    
}
