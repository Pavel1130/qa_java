package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static final String MALE = "Самец";
    private static final String UNSUPPORTED_SEX = "unsupported sex";
    private static final String TEXT_EXCEPTION = "Используйте допустимые значения пола животного - самец или самка";

    @Mock
    private Feline feline;

    private Lion lion;

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion(MALE, feline);

        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testDoesHaveManeException() {
        Throwable throwable = catchThrowable(() -> new Lion(UNSUPPORTED_SEX, feline));

        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage(TEXT_EXCEPTION);
    }

    @Test
    public void testGetFood() throws Exception {
        lion = new Lion(MALE, feline);

        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }
}
