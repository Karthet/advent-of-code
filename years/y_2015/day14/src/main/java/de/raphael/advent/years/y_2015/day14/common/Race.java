package de.raphael.advent.years.y_2015.day14.common;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

@Slf4j
public class Race {

    private static final Pattern registration =
            Pattern.compile("(?<name>\\w+).* (?<speed>\\d+) km.* (?<duration>\\d+).* (?<rest>\\d+).*");

    private final Set<Reindeer> participants;
    private final Map<Integer, String> leaderBoard;

    public Race() {
        this.participants = new TreeSet<>();
        this.leaderBoard = new TreeMap<>();
    }

    public void registerReindeer(String description) {
        var matcher = registration.matcher(description);
        if (matcher.matches()) {
            participants.add(Reindeer.builder()
                    .name(matcher.group("name"))
                    .speed(Integer.parseInt(matcher.group("speed")))
                    .duration(Integer.parseInt(matcher.group("duration")))
                    .rest(Integer.parseInt(matcher.group("rest")))
                    .build());

        } else {
            log.error("{} cannot be processed!", description);
        }
    }

    /**
     * Run a race between the participants.
     *
     * @param duration Duration of the race.
     * @return Longest distance run.
     */
    public long execute(int duration) {
        participants.forEach(p -> {
            var cycle = p.duration + p.rest;
            var runTimes = (duration / cycle);
            var rest = duration - (runTimes * cycle);
            var distance = runTimes * p.duration * p.speed;

            while (rest != 0) {
                var elapsed = p.duration;
                if (rest >= cycle) {
                    rest -= cycle;
                } else if (rest >= p.duration) {
                    rest = 0;
                } else {
                    elapsed = rest;
                    rest = 0;
                }

                distance += (p.speed * elapsed);
            }

            leaderBoard.put(distance, p.name);

        });
        return leaderBoard.keySet().stream().max(Comparator.naturalOrder()).orElse(-1);
    }

    /**
     * Run a race between the participants. Each second the participant at first place will get a point.
     *
     * @param duration Duration of the race.
     * @return Longest distance run.
     */
    public int executeWithPoints(int duration) {
        var max = new AtomicInteger(0);
        for (var t = 0; t < duration; t++) {
           max.set(participants.stream().map(p -> p.step(max.get())).max(Comparator.naturalOrder()).orElse(-1));
        }
        return participants.stream().map(Reindeer::getPoints).max(Comparator.naturalOrder()).orElse(-1);
    }
}
