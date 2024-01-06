package assignments.assign01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileOperations {

    /*
     * As per the problem of assignment,
     * load the contents of both files & then process by sorting them & then add in some output file
     * */

    public List<Integer> readFileContents(File file) {
        List<Integer> fileContents = new ArrayList<>();
        try {

            Scanner dataRead = new Scanner(file);
            while (dataRead.hasNextLine()) {
                int contents = dataRead.nextInt();
                fileContents.add(contents);
            }
            dataRead.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Collections.sort(fileContents);
        return fileContents;
    }

    public List<Integer> mergeSort(List<Integer> list1, List<Integer> list2) {

        int size1 = list1.size();
        int size2 = list2.size();
        List<Integer> ans = new ArrayList<>(size1 + size2);
        int pointer1 = 0, pointer2 = 0;

        while (pointer1 < size1 && pointer2 < size2) {

            if (list1.get(pointer1) < list2.get(pointer2)) {
                ans.add(list1.get(pointer1));
                pointer1++;
            } else {
                ans.add(list2.get(pointer2));
                pointer2++;
            }
        }

        while (pointer1 < size1) {
            ans.add(list1.get(pointer1));
            pointer1++;
        }
        while (pointer2 < size2) {
            ans.add(list2.get(pointer2));
            pointer2++;
        }

        return ans;
    }


    public void writeIntoTheFile(List<Integer> data) {
        String output = "src/main/java/assignments/assign01/";
        try {
            FileWriter writer = new FileWriter(output + "output.txt");
            for (int value : data) {
                // Convert integer to String before writing
                writer.write(Integer.toString(value));
                // Optionally, add a newline character after each value
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
