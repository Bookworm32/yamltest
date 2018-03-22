import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileReader;
import java.util.Map;

/**
 * Created by Alex on 22.03.2018.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        YamlReader reader = new YamlReader(new FileReader("artefacts.yml"));
        Object object = reader.read();
        System.out.println(object);
        System.out.println();
        Map map = (Map)object;
        System.out.println("version - "+map.get("version"));
        System.out.println("cross_core - " + map.get("cross_core"));
    }
}
