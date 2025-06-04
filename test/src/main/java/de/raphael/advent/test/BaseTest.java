package de.raphael.advent.test;

import de.raphael.advent.common.Programm;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BaseTest {

    protected Programm underTest;

    protected void testAdvent(String fileName, Object expectedResult) {

        // when
        var result = underTest.run(fileName);

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

}
