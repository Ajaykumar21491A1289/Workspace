package com.jocata.filehandling.main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Assessment {

    public static void main(String[] args){

        Ajay ajay = new Ajay();
        ajay.setName("Malineni");
        ajay.setAge(10);

        Path path = Paths.get("C:\\Workspace\\File\\src\\main\\java\\com\\jocata\\filehandling\\main\\object.txt");

        //Creating a File
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException("Failed to create file", e);
            }
        }

        //Save Object to the File

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(ajay);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save orders to file", e);
        }

        Ajay obj =null;


        //Reading Object From the File

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            obj = (Ajay) ois.readObject();
        } catch (EOFException e) {
           System.out.println("ENd Of File");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load orders from file", e);
        }



        //writing the Data from the Object to file
        Path dataPath = Paths.get("C:\\Workspace\\File\\src\\main\\java\\com\\jocata\\filehandling\\main\\result.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(dataPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(obj.getAge()+" "+obj.getName()+" ");
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write order details to file", e);
        }




    }




    }
}
