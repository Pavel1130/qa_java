package com.example;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class FelineTest {

    private static final String EXPECTED_FAMILY = "Кошачьи";
    private static final int EXPECTED_KITTENS_COUNT_FOR_MOCK = 1;

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String actual = feline.getFamily();

        // Одна проверка: результат совпадает с ожидаемым
        assertThat(actual)
                .as("Ожидаемое семейство не соответствует фактическому")
                .isEqualTo(EXPECTED_FAMILY);
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int actual = feline.getKittens();

        assertThat(actual)
                .as("Количество котят не соответствует ожидаемому")
                .isEqualTo(EXPECTED_KITTENS_COUNT_FOR_MOCK);
    }

    @Test
    public void testGetKittensWithArg() {
        Feline feline = new Feline();
        int kittensCount = 5;
        int actual = feline.getKittens(kittensCount);

        assertThat(actual)
                .as("Количество котят не соответствует ожидаемому")
                .isEqualTo(kittensCount);
    }


    @Test
    public void testEatMeat_callsGetFood() throws Exception {
        Feline feline = org.mockito.Mockito.mock(Feline.class);
        org.mockito.Mockito.when(feline.eatMeat()).thenCallRealMethod();
        org.mockito.Mockito.doCallRealMethod().when(feline).getFood(org.mockito.ArgumentMatchers.anyString());

        feline.eatMeat();

        org.mockito.Mockito.verify(feline, org.mockito.Mockito.times(1)).getFood("Хищник");
    }
}
