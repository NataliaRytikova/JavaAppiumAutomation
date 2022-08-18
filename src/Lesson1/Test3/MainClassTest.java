package Lesson1.Test3;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.String.format;

public class MainClassTest extends MainClass
{
    @Test
    public void  testGetClassString()
    {
        String text = this.getClassString();
        String word_1 = "Hello";
        String word_2 = "hello";
        String errorWord = "";

        if (text.contains(word_1))
        {
            System.out.println(format("Слово %s найедно", word_1));
        }else if (text.contains(word_2))
        {
            System.out.println(format("Слово %s найедно", word_1));
        } else
        {
            errorWord = word_1 + ", " + word_2;
            Assert.assertTrue(format("Тест провелен: в строке не найдено %s", errorWord), text.contains(errorWord));
        }
    }
    
}