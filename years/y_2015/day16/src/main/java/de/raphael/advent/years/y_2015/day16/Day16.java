package de.raphael.advent.years.y_2015.day16;

import de.raphael.advent.core.Application;
import de.raphael.advent.core.annotation.InitializeAdvent;
import de.raphael.advent.years.y_2015.day16.common.Sue;
import de.raphael.advent.years.y_2015.day16.parts.Part1;
import de.raphael.advent.years.y_2015.day16.parts.Part2;

@InitializeAdvent(
        name = "Aunt Sue",
        year = "2015",
        day = "16",
        programm1 = Part1.class,
        programm2 = Part2.class
)
public class Day16 extends Application {

    public static final Sue theOneAndOnly = new Sue(0,3,7,2,3,0,0,5,3,2,1);

}
