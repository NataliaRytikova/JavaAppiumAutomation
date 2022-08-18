package Lesson1.Test2;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.String.format;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetClassNumber()
    {
        int a = this.getClassNumber();

        Assert.assertTrue(format("Тест провелен: число %s меньше 45", a), a > 45);
    }
}