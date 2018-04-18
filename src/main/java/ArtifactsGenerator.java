import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 22.03.2018.
 */
public class ArtifactsGenerator {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            try (FileReader fr = new FileReader(args[0])) {
                YamlReader reader = new YamlReader(fr);
                Map<String, Object> conf = (Map) reader.read();

                for (String group : conf.keySet()) {
                    if (group.equals("version"))
                        System.out.println(conf.get(group));
                    else {
                        System.out.println("\n#" + ((Map<String, Object>) conf.get(group)).get("name"));
                        for (Map distr : (List<Map>) ((Map<String, Object>) conf.get(group)).get("distributions"))
                            System.out.println(distr.get("url") + "@" + distr.get("path"));
                    }
                }
            }
        } else
            System.out.println("Usage: generate-artifacts.jar <file with cradle config>.yml");
    }
}
