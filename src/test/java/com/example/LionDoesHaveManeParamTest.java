package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionDoesHaveManeParamTest {

    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";

    private final String sex;
    private final boolean hasMane;

    public LionDoesHaveManeParamTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "sex={0}, hasMane={1}")
    public static Object[][] getParameters() {
        return new Object[][] {
                {MALE, true},
                {FEMALE, false}
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, feline);

        boolean actual = lion.doesHaveMane();
        assertEquals("Значение doesHaveMane не соответствует ожидаемому",
                hasMane, actual);
    }
}
