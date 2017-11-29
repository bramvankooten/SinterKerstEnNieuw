import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private static List<Question> algemeen;
    private static List<Question> dieren;
    private static List<Question> eten;
    private static List<Question> geschiedenis;
    private static List<Question> geografie;
    private static List<Question> muziek;
    private static List<Question> nederland;
    private static List<Question> sport;
    private static List<Question> technologie;
    private static List<Question> tv;
    private static List<Question> vervoer;

    public static void loadCategories() throws IOException {
        algemeen = loadCategory("algemeen");
        dieren = loadCategory("dieren");
        eten = loadCategory("eten");
        geschiedenis = loadCategory("geschiedenis");
        geografie = loadCategory("geografie");
        muziek = loadCategory("muziek");
        nederland = loadCategory("nederland");
        sport = loadCategory("sport");
        technologie = loadCategory("technologie");
        tv = loadCategory("tv");
        vervoer = loadCategory("vervoer");
    }

    public static List<Question> loadCategory(String category) throws IOException {
        List<String> vragen = readFile("./data/" + category + "_vragen.txt");
        List<String> antwoorden = readFile("./data/" + category + "_antwoorden.txt");
        List<Question> result = new ArrayList<>();
        for (int i = 0; i < vragen.size(); i++) {
            result.add(new Question(vragen.get(i), antwoorden.get(i)));
        }
        return result;
    }

    public static List<String> readFile(String fileName) throws IOException {
        File file = getResourceAsFile(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> result = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            result.add(line);
        }
        return result;
    }

    public static File getResourceAsFile(String resourcePath) {
        try {
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resourcePath);
            if (in == null) {
                return null;
            }

            File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");
            tempFile.deleteOnExit();

            try (FileOutputStream out = new FileOutputStream(tempFile)) {
                //copy stream
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

        try {
            loadCategories();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
