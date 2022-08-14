import org.junit.Assert;
import org.junit.Test;

import static java.lang.String.*;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetLocalNumber()
    {
        int a = this.getLocalNumber();

        if (a == 14)
        {
            System.out.println(format("Тест успешен: отправлено %s", a));
        } else
        {
            Assert.assertTrue(format("Тест провелен: отправлено %s, а должно быть 14", a), a == 14);
        }

    }

    @Test
    public void testGetClassNumber()
    {
        int a = this.getClassNumber();

        Assert.assertTrue(format("Тест провелен: число %s меньше 45", a), a > 45);


    }


}
