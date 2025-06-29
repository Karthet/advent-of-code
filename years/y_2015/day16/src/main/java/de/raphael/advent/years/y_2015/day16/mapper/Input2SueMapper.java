package de.raphael.advent.years.y_2015.day16.mapper;

import de.raphael.advent.years.y_2015.day16.common.Sue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Input2SueMapper {

    public static Sue map(String input) {

        var number = Integer.parseInt(input.split(": ")[0].split(" ")[1]);
        var properties = properties2Map(input.substring(input.indexOf(": ") + 2));
        return new Sue(number, properties.get("children"), properties.get("cats"), properties.get("samoyeds"), properties.get("pomeranians"), properties.get("akitas"), properties.get("vizslas"), properties.get("goldfish"), properties.get("trees"), properties.get("cars"), properties.get("perfumes"));
    }

    private static Map<String, Integer> properties2Map(String propertiesString) {
        var properties = propertiesString.split(", ");
        return Arrays.stream(properties).map(property -> property.split(": ")).collect(HashMap::new, (map, property) -> map.put(property[0], Integer.parseInt(property[1])), HashMap::putAll);
    }

}
