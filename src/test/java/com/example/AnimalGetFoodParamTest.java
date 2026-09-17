package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalGetFoodParamTest {

    private static final String ANIMAL_KIND_HERBIVORE = "Травоядное";
    private static final String ANIMAL_KIND_PREDATOR = "Хищник";
    private static final List<String> FOODS_HERBIVORE = List.of("Трава", "Различные растения");
    private static final List<String> FOODS_PREDATOR = List.of("Животные", "Птицы", "Рыба");

    private final String animalKind;   // <-- final: задаётся в конструкторе, не меняется
    private final List<String> foods;  // <-- final: задаётся в конструкторе, не меняется

    public AnimalGetFoodParamTest(String animalKind, List<String> foods) {
        this.animalKind = animalKind;
        this.foods = foods;
    }

    @Parameterized.Parameters(name = "kind={0}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {ANIMAL_KIND_HERBIVORE, FOODS_HERBIVORE},
                {ANIMAL_KIND_PREDATOR, FOODS_PREDATOR}
        };
    }

    @Test
    public void testGetFood() throws Exception {
        // animal больше не поле класса — создаём локально, чтобы тест был полностью независимым
        Animal animal = new Animal();
        List<String> actual = animal.getFood(animalKind);

        assertEquals("Список еды для животных не совпадает с ожидаемым",
                foods, actual);
    }
}
