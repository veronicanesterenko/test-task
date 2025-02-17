package org.example;

import org.apache.commons.cli.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class App {

    public static void main(String[] args) {

        Options options = new Options();
        options.addOption("s", "sort", true, "Sort by name or salary");
        options.addOption("o", "output", true, "Output to console or file");
        options.addOption("p", "path", true, "Path to output file");
        options.addOption("order", true, "Sort order (asc or desc)");

        CommandLineParser parser = new DefaultParser();

        CommandLine cmd = null;
        try {
            cmd = parser.parse(options, args);
            String sort = cmd.getOptionValue("sort");
            String output = cmd.getOptionValue("output", "console");
            String path = cmd.getOptionValue("path");
            String order = cmd.getOptionValue("order");

            if (output.equals("file") && path == null) {
                System.out.println("Ошибка: необходимо задать путь к файлу!");
                return;
            }

            FileReader fileReader = new FileReader();
            List<String> staff = new ArrayList<>();
            try {
                staff = fileReader.readFile();
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден!");

            }
            DataWriter dataWriter = new DataWriter();
            PrintWriter writer = null;
            if (output.equals("console")) {
                writer = new PrintWriter(System.out);
            } else if (output.equals("file")) {
                writer = new PrintWriter(new FileWriter(path));
            }

            StringToObjectConverter converter = new StringToObjectConverter();
            List<List<Object>> allData = converter.convertToObjects(staff);

            if (sort != null) {
                Comparator comparator = null;
                if (sort.equals("name")) {
                    if (order != null && order.equals("desc")) {
                        comparator = new SortByName().reversed();
                    } else {
                        comparator = new SortByName();
                    }
                } else if (sort.equals("salary")) {
                    if (order != null && order.equals("desc")) {
                        comparator = new SortBySalary().reversed();
                    } else {
                        comparator = new SortBySalary();
                    }
                }
                dataWriter.printSortedData(writer, comparator, allData);
            } else {
                dataWriter.printData(writer, allData);
            }

        } catch (ParseException e) {
            System.out.println("Ошибка в аргументах команднной строки: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Неверный путь, такого файла не существует: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Ошибка! Изучите инструкцию по запуску: " + e.getMessage());
        }
    }
}
