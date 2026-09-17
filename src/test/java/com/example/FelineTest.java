package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private static final String EXPECTED_FAMILY = "Кошачьи";
    private static final int EXPECTED_KITTENS_COUNT_FOR_MOCK = 1;

    @Spy
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();

        assertThat(actual)
                .as("Ожидаемое семейство не соответствует фактическому")
                .isEqualTo(EXPECTED_FAMILY);
    }

    @Test
    public void testGetKittens() {
        int actual = feline.getKittens();
        Mockito.verify(feline).getKittens(EXPECTED_KITTENS_COUNT_FOR_MOCK);

        assertThat(actual)
                .as("Количество котят не соответствует ожидаемому")
                .isEqualTo(EXPECTED_KITTENS_COUNT_FOR_MOCK);
    }

    @Test
    public void testGetKittensWithArg() {
        int kittensCount = 5;
        int actual = feline.getKittens(kittensCount);
        Mockito.verify(feline).getKittens(Mockito.anyInt());

        assertThat(actual)
                .as("Количество котят не соответствует ожидаемому")
                .isEqualTo(kittensCount);
    }
}
