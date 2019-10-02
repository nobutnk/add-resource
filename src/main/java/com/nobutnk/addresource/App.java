package com.nobutnk.addresource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * convert CSV file to Map.
 *
 */
public class App {
    
    private final Properties properties;
    
    public App() throws IOException {
        try(InputStream is = getClass().getClassLoader()
                .getResource("main.properties").openStream()){
                properties = new Properties();
                properties.load(is);
            }
    }
    public Map<String, String> map(String pathInClassPath) throws URISyntaxException, IOException {
        Map<String, String> map = new HashMap<>();
        map.put("header", properties.getProperty("header"));
        
        Path path = Paths.get(getClass().getClassLoader()
          .getResource(pathInClassPath).toURI());
              
        Stream<String> lines = Files.lines(path);
        lines.forEach(line -> {
            String[] data = line.split(",");
            map.put(data[0], data[1]);
        });
        lines.close();
        
        return map;
    }
}
