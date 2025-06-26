package de.raphael.advent.years.y_2015.day15.common;

import lombok.Data;

@Data
public class Ingredient {
   private final String name;
   private final int capacity;
   private final int durability;
   private final int flavor;
   private final int texture;
   private final int calories;
   private int amount;

   public Ingredient(String input) {
       var tmp = input.split(":");
       this.name = tmp[0];
       tmp = tmp[1].replaceAll("[a-z]","").split(",");
       this.capacity = Integer.parseInt(tmp[0].trim());
       this.durability = Integer.parseInt(tmp[1].trim());
       this.flavor = Integer.parseInt(tmp[2].trim());
       this.texture = Integer.parseInt(tmp[3].trim());
       this.calories = Integer.parseInt(tmp[4].trim());
   }

   public int calcCapacity() {
       return capacity * amount;
   }

   public int calcDurability() {
       return durability * amount;
   }

   public int calcFlavor() {
       return flavor * amount;
   }

   public int calcTexture() {
       return texture * amount;
   }

    public int calcCalories() {
        return calories * amount;
    }

}
