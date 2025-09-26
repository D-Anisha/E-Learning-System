package utils;

import java.io.*;

public class DataPersistence {
    private static final String DATA_DIR = "data/";
    
    public DataPersistence() {
        createDataDirectory();
    }
    
    private void createDataDirectory() {
        File dir = new File(DATA_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }
    
    public void saveData(Object data, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(DATA_DIR + filename))) {
            oos.writeObject(data);
        } catch (IOException e) {
            System.err.println("Error saving data to " + filename + ": " + e.getMessage());
        }
    }
    
    public Object loadData(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(DATA_DIR + filename))) {
            return ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Data file " + filename + " not found. Starting with empty data.");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data from " + filename + ": " + e.getMessage());
            return null;
        }
    }
}
