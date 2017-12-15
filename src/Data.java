import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Data {

    public static Iterator<Question> algemeen;
    public static Iterator<Question> dieren;
    public static Iterator<Question> eten;
    public static Iterator<Question> geschiedenis;
    public static Iterator<Question> geografie;
    public static Iterator<Question> muziek;
    public static Iterator<Question> nederland;
    public static Iterator<Question> sport;
    public static Iterator<Question> technologie;
    public static Iterator<Question> tv;
    public static Iterator<Question> vervoer;

    public static void loadCategories() throws IOException {
        List<Question> algemeenList = loadCategory("algemeen");
        Collections.shuffle(algemeenList);
        algemeen = algemeenList.iterator();
        List<Question> dierenList = loadCategory("dieren");
        Collections.shuffle(dierenList);
        dieren = dierenList.iterator();
        List<Question> etenList = loadCategory("eten");
        Collections.shuffle(etenList);
        eten = etenList.iterator();
        List<Question> geschiedenisList = loadCategory("geschiedenis");
        Collections.shuffle(geschiedenisList);
        geschiedenis = geschiedenisList.iterator();
        List<Question> geografieList = loadCategory("geografie");
        Collections.shuffle(geografieList);
        geografie = geografieList.iterator();
        List<Question> muziekList = loadCategory("muziek");
        Collections.shuffle(muziekList);
        muziek = muziekList.iterator();
        List<Question> nederlandList = loadCategory("nederland");
        Collections.shuffle(nederlandList);
        nederland = nederlandList.iterator();
        List<Question> sportList = loadCategory("sport");
        Collections.shuffle(sportList);
        sport = sportList.iterator();
        List<Question> technologieList = loadCategory("technologie");
        Collections.shuffle(technologieList);
        technologie = technologieList.iterator();
        List<Question> tvList = loadCategory("tv");
        Collections.shuffle(tvList);
        tv = tvList.iterator();
        List<Question> vervoerList = loadCategory("vervoer");
        Collections.shuffle(vervoerList);
        vervoer = vervoerList.iterator();
    }

    public static List<Question> loadCategory(String category) throws IOException {
        List<String> vragen = readFile("data/" + category + "_vragen.txt");
        List<String> antwoorden = readFile("data/" + category + "_antwoorden.txt");
        List<Question> result = new ArrayList<>();
        for (int i = 0; i < vragen.size(); i++) {
            result.add(new Question(vragen.get(i), antwoorden.get(i)));
        }
        return result;
    }

    public static List<String> readFile(String fileName) throws IOException {
        InputStream file = getResourceAsFile(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        List<String> result = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            result.add(line);
        }
        return result;
    }

    public static InputStream getResourceAsFile(String resourcePath) {
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resourcePath);
        if (in == null) {
            return null;
        }

        return in;
    }
}
