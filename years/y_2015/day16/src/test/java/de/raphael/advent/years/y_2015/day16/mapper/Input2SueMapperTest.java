package de.raphael.advent.years.y_2015.day16.mapper;

import de.raphael.advent.years.y_2015.day16.common.Sue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Input2SueMapperTest {

    @Test
    void map() {
        
        // given
        var testSue = "Sue 42: children: 1, cats: 2, samoyeds: 3, pomeranians: 4, akitas: 5, vizslas: 6, goldfish: 7," +
                " trees: 8, cars: 9, perfumes: 10";
        
        // when
        var result = Input2SueMapper.map(testSue);
        
        // then
        assertEquals(new Sue(42,1,2,3,4,5,6,7,8,9,10),
                result);

        
    }
}