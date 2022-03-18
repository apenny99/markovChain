import java.io.File;
import java.io.FileNotFoundException;
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
<<<<<<< HEAD
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
=======
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
>>>>>>> 2f388b1f8fb94ae443342a96d7c97699ccd7172a
                }
            }
<<<<<<< HEAD
        }
    }
=======


        }
        System.out.println(main.values());

    }

    public static void main(String[] args) throws FileNotFoundException {
        markovChain m = new markovChain();
        m.fileToDictionary("test.txt");

>>>>>>> 2f388b1f8fb94ae443342a96d7c97699ccd7172a

    public static void main(String[] args) throws FileNotFoundException {
        markovChain m = new markovChain();
        m.fileToDictionary("test.txt");
        System.out.println(m.main.values());
    }


    
}
