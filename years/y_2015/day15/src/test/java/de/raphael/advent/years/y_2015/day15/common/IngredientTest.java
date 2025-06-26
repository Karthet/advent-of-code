package de.raphael.advent.years.y_2015.day15.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    void testIngredient() {

        // given
        var input = "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8";

        // when
        var ingredient = new Ingredient(input);

        // then
        assertEquals("Butterscotch", ingredient.getName());
        assertEquals(-1, ingredient.getCapacity());
        assertEquals(-2, ingredient.getDurability());
        assertEquals(6, ingredient.getFlavor());
        assertEquals(3, ingredient.getTexture());
        assertEquals(8, ingredient.getCalories());

    }

}