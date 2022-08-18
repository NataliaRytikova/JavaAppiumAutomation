package Lesson1.Test1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

import static java.lang.String.*;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetLocalNumber()
    {
        int a = this.getLocalNumber();

        if (a == 14)
        {
            System.out.printf("Тест успешен: отправлено %s%n", a);
        } else
        {
            Assert.assertTrue(format("Тест провелен: отправлено %s, а должно быть 14", a), a == 14);
        }
    }
}