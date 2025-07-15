package com.jocata.filehandling.main;

import java.io.*;
import java.nio.*;
import java.nio.file.FileSystem;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;

public class FileOperations {

    public static void main(String[] args) {

        try {

            File file = new File("D:\\Jocata_Internship\\JAVA\\JocataFile.txt");
            FileWriter fileWriter = new FileWriter(file,true);
            Scanner scanner = new Scanner(file);

            if (file.createNewFile()) System.out.println("File Created Successfully");
            else System.out.println("File already exist");

            Test test = new Test(101,"ajay");

            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("D:\\Jocata_Internship\\JAVA\\Object.ser"));
            stream.writeObject(test);
            stream.close();
            System.out.println("Object written Successfully ");
            fileWriter.write("Hello Welcome to jocata");
            fileWriter.close();
            System.out.println("Successfully written");


            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Jocata_Internship\\JAVA\\Object.ser")))
            {
                Test testobj = (Test) ois.readObject();
                System.out.println(testobj);
            }

            catch (IOException | ClassNotFoundException e) {e.printStackTrace();}



            while (scanner.hasNext()) {
                String data = scanner.next();
                System.out.println(data);
            }
            scanner.close();

            if (file.delete()) System.out.println("File Deleted Successfully");
            else System.out.println("Failed to delete the file");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
