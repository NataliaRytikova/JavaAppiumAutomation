import org.junit.Test;

import static java.lang.String.*;

public class MainClassTest extends MainClass
{
    @Test
    public void testGetLocalNumber()
    {
        int a = this.getLocalNumber();
        if (a != 14)
        {
            System.out.println(format("Тест провелен, отправлено %s, а должно быть 14", a));
        } else
        {
            System.out.println(format("Тест успешен, отправлено %s", a));
        }

        }
}
