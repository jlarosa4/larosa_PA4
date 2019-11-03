import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class DuplicateCounter {
    private Map<String, Integer> wordCounter;

    public void count(String dataFile) throws FileNotFoundException{
        String word = null;
        wordCounter = new HashMap<String, Integer>();
        Scanner sc=new Scanner(new File(dataFile));
        while(sc.hasNext())
        {
            if (wordCounter.containsKey(word)) {
                wordCounter.put(word, wordCounter.get(word) + 1);
            }
            else {

                wordCounter.put(word, 1);
            }
        }
        sc.close();


    }
    public void Write(String outputFile) throws IOException
    {
        File f;
        FileWriter fw = null;

        f = new File(outputFile);

        if(f.exists()) {
            fw=new FileWriter(f,true);
            Iterator itr=wordCounter.iterator();

            while(itr.hasNext())
            {
                String str=(String)itr.next();
                fw.write(str+"\n");
            }
            fw.close();
            System.out.println("Data Written to File");

        }
        else
        {

            f.createNewFile();
            fw=new FileWriter(f);
            Iterator itr=wordCounter.iterator();

            while(itr.hasNext())
            {
                String str=(String)itr.next();
                fw.write(str+"\n");
            }
            fw.close();
            System.out.println("Data Written to File");
        }

    }

}
