package com.jocata.ordermanagement.customermanagement.dao.impl;

import com.jocata.ordermanagement.customermanagement.dao.CustomerDao;
import com.jocata.ordermanagement.customermanagement.entity.CustomerEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    private List<CustomerEntity> customerList;
    private Path path = Paths.get("D:\\Files\\customerObject.txt");


    public CustomerDaoImpl(){
        this.customerList = loadCustomerData();
    }
    public String addCustomer(CustomerEntity entity){
        customerList.add(entity);
        saveCustomerToFile();
        return "Customer Added Successfully";


    }

    public String updateCustomer(CustomerEntity entity){
        for(CustomerEntity customer: customerList){
            if(customer.getCustomerId().equals(entity.getCustomerId())){
                customer.setName(entity.getName());
                customer.setEmail(entity.getEmail());
                customer.setAddress(entity.getAddress());
                saveCustomerToFile();
                return "Customer Updated Successfully";
            }
        }
        return "Customer Not Found";
    }

    @Override
    public CustomerEntity getCustomer(Integer customerId) {
        for (CustomerEntity customer : customerList) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }


    public String deleteCustomer(Integer customerId){
        Iterator<CustomerEntity> iterator = customerList.iterator();
        while(iterator.hasNext()){
            CustomerEntity customer = iterator.next();
            if(customer.getCustomerId().equals(customerId)){
                iterator.remove();
                saveCustomerToFile();
                return " Customer Deleted Successfully";
            }
        }
        return "Customer Not Found";
    }


    private void saveCustomerToFile(){
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))){
            oos.writeObject(customerList);
        } catch(IOException e){
            throw new RuntimeException("Failed to save Data To File");
        }
    }

    private List<CustomerEntity> loadCustomerData(){
        if(!Files.exists(path)){
            try{
                Files.createFile(path);
                return new ArrayList<>();
            } catch (IOException e){
                throw new RuntimeException("Failed to Create a File");
            }
        }
        try(ObjectInputStream ois = new ObjectInputStream((Files.newInputStream(path)))){
            return (List<CustomerEntity>) ois.readObject();
        } catch(EOFException e){
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(" Failed to load Orders from the File");
        }
    }

    private Path loadDetails(CustomerEntity customer){
        Path outputPath = Paths.get("D:\\Files\\customerOutput.txt");
        try(BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE,StandardOpenOption.APPEND)){
            writer.write(customer.getCustomerId()+","+
                    customer.getName()+","+
                    customer.getEmail()+","+
                    customer.getAddress());
            writer.newLine();
        }catch (IOException e){
            throw new RuntimeException("Failed to write Cusomer to File");
        }
        return outputPath;
    }
}
