
/**
 * markovTest
 * tests the markovChain program
 * Author: August Penny
 * Collaborator(s): The names of anyone you collaborated with here
 * Collaboration: Describe the collaboration that took place
 * Date: 2/24/2022
 **/
import java.io.FileNotFoundException;

public class markovTest {

    public static void main(String[] args) throws FileNotFoundException {
        markovChain m = new markovChain();

        m.fileToDictionary("test.txt"); //makes a dictionary out of the words in the file
        m.genString("output.txt");//generates the words and saves them to a desginated file.
    }
}
