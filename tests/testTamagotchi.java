import com.codecool.tamagotchi.model.Tamagotchi;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testTamagotchi {

    Tamagotchi tamagotchi;

    @Before
    public void initialize() {
        this.tamagotchi = new Tamagotchi();
    }


    @Test
    public void testFeeding() {
        tamagotchi.feed();
        Assert.assertEquals(100, tamagotchi.getFeeding());
    }

    @Test
    public void testDecreaseFeeding() {
        tamagotchi.feed();
        tamagotchi.decreaseFeeding();
        Assert.assertEquals(99, tamagotchi.getFeeding());
    }

    @Test
    public void haveFun() {
        tamagotchi.haveFun();
        Assert.assertEquals(100, tamagotchi.getFun());
    }

    @Test
    public void getOlder() {
        Assert.assertEquals(0, tamagotchi.getAge());
        tamagotchi.getOlder();
        Assert.assertEquals(1, tamagotchi.getAge());
    }
}
