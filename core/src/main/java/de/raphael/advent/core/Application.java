package de.raphael.advent.core;

import de.raphael.advent.core.annotation.InitializeAdvent;
import lombok.extern.slf4j.Slf4j;
import com.google.common.reflect.ClassPath;

import java.io.IOException;


@Slf4j
public abstract class Application {

    public static void main(String ... args) throws IOException {

        var annotation = extractInitializeAdvent();

        try {

            var year = annotation.year();
            var day = annotation.day();
            var part1 = annotation.programm1().getDeclaredConstructor().newInstance();
            var part2 = annotation.programm2().getDeclaredConstructor().newInstance();
            var name = annotation.name();

            var start = System.currentTimeMillis();
            var result1 = part1.run();
            var stop = System.currentTimeMillis();
            var time1 = stop - start;
            log.info("[Year {}|Day {} - {}|Part 1]: {} ({}ms)", year, day, name, result1, time1);

            start = System.currentTimeMillis();
            var result2 = part2.run();
            stop = System.currentTimeMillis();
            var time2 = stop - start;
            log.info("[Year {}|Day {} - {}|Part 2]: {} ({}ms)", year, day, name, result2, time2);

        } catch (Exception ex) {
            log.error("Unexpected error", ex);
        }

    }

    private static InitializeAdvent extractInitializeAdvent() throws IOException {

        var annotations = ClassPath.from(ClassLoader.getSystemClassLoader()).getAllClasses().stream()
                .filter(c -> c.getName().startsWith("de.raphael"))
                .map(ClassPath.ClassInfo::load)
                .filter(c -> c.getAnnotation(InitializeAdvent.class) != null)
                .map(c -> c.getAnnotation(InitializeAdvent.class))
                .toList();

        if (annotations.size() > 1) {
            throw new IllegalStateException("Only one class may be annotated with InitializeAdvent");
        }

        if (annotations.isEmpty()) {
            throw new IllegalStateException("At least one class must be annotated with InitializeAdvent");
        }

        return annotations.get(0);

    }

}
