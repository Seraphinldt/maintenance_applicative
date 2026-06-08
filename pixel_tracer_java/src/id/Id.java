package id;

import java.io.*;

public class Id {
    private static final String ID_FILE = "id.txt";
    private static long currentId = 0;

    static {
        loadId();
    }

    public static long getNextId() {
        return ++currentId;
    }

    public static void setId(long id) {
        currentId = id;
    }

    public static void saveId() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ID_FILE))) {
            writer.println(currentId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadId() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ID_FILE))) {
            String line = reader.readLine();
            if (line != null) {
                currentId = Long.parseLong(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            currentId = 0;
        }
    }
}