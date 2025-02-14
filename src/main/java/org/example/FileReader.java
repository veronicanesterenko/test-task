package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public List<String> readFile() throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);
        List<String> staffMembers = new ArrayList<>();
        while(scanner.hasNextLine()) {
            staffMembers.add(scanner.nextLine());

        }
        scanner.close();
        return staffMembers;
    }


}
