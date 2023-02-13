
import java.io.*;
import java.util.*;

public class Exercise8 {
    public static void main(String args[]) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: SortFile<filename>");
        }
        File file = new File(args[0]);
        File temp = new File("temp.txt");
        BufferedReader input = null;
        PrintWriter output = null;
        List<String> list = new ArrayList<>();

        try {
            input = new BufferedReader(new FileReader(file));
            output = new PrintWriter(new FileWriter(temp));
            String line;
            while ((line = input.readLine()) != null) {
                list.add(line);
            }
            Collections.sort(list);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                output.println(it.next());
            }
            file.delete();
            temp.renameTo(file);
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }
}
