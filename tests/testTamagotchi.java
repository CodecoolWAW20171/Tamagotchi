import com.codecool.tamagotchi.model.Tamagotchi;
import org.junit.Assert;
import org.junit.Test;

public class testTamagotchi {

    @Test
    public void testFeeding() {
        Tamagotchi tamagotchi = new Tamagotchi();
        tamagotchi.feed();
        Assert.assertEquals(100, tamagotchi.getFeeding());
    }

    @Test
    public void testDecreaseFeeding() {
        Tamagotchi tamagotchi = new Tamagotchi();
        tamagotchi.feed();
        tamagotchi.decreaseFeeding();
        Assert.assertEquals(99, tamagotchi.getFeeding());
    }

    @Test
    public void haveFun() {
        Tamagotchi tamagotchi = new Tamagotchi();
        tamagotchi.haveFun();
        Assert.assertEquals(100, tamagotchi.getFun());
    }

    @Test
    public void getOlder() {
        Tamagotchi tamagotchi = new Tamagotchi();
        Assert.assertEquals(0, tamagotchi.getAge());
        tamagotchi.getOlder();
        Assert.assertEquals(1, tamagotchi.getAge());
    }
}
