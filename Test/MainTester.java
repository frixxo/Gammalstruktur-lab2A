import Movables.*;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Has all the test
 */
public class MainTester {

    @Test
    public void TestGallardoSpoilerDown() {
        LamborghiniGallardo x = new LamborghiniGallardo();
        double d=x.speedFactor();
        assertEquals(3.2,d,0);
    }

    @Test
    public void TestGallardoSpoilerUp(){
        LamborghiniGallardo x = new LamborghiniGallardo();
        x.setSpoilerUp(true);
        double d=x.speedFactor();
        assertEquals((float)2.88,(float)d,0);
    }

    @Test
    public void TestTurnleftX(){
        Saab95 saab = new Saab95();
        saab.turnLeft();
        assertEquals(0,saab.getDirection().getX(),0.01);

    }
    @Test
    public void TestTurnleftY(){
        Saab95 saab = new Saab95();
        saab.turnLeft();
        assertEquals(1,saab.getDirection().getY(),0.01);

    }
    @Test
    public void TestTurnRightX(){
        Saab95 saab = new Saab95();
        saab.turnRight();
        assertEquals(0,saab.getDirection().getX(),0.01);

    }
    @Test
    public void TestTurnRightY(){
        Saab95 saab = new Saab95();
        saab.turnRight();
        assertEquals(-1,saab.getDirection().getY(),0.01);

    }
    @Test
    public void TestVolvoSpeedFactor(){
        Volvo240 volvo = new Volvo240();
        assertEquals(1.25d,volvo.speedFactor(),0.01d);
    }
    @Test
    public void TestGasHigher(){
        Volvo240 volvo=new Volvo240();
        volvo.gas(10);
        assertEquals(1.25d,volvo.getCurrentSpeed(),0.01);
    }
    @Test
    public void TestBrakeHigher(){
        Volvo240 volvo=new Volvo240();
        volvo.gas(10);
        volvo.brake(10);
        assertEquals(0,volvo.getCurrentSpeed(),0.01);
    }
    @Test
    public void TestMoveX(){
        Saab95 saab=new Saab95();
        saab.gas(1);
        saab.move();
        assertEquals(1,saab.getPosition().getX(),0.01);
    }
    @Test
    public void TestMoveY(){
        Saab95 saab=new Saab95();
        saab.gas(1);
        saab.move();
        assertEquals(0,saab.getPosition().getY(),0.01);
    }
    @Test   //testar 500 olika kombinationer, klarar över 20000 innan duplicering
    public void TestRegNrGenerator(){
        Saab95 k;
        ArrayList<String> j= new ArrayList<>();
        for(int x=0;x<500;x++){
            k=new Saab95();
            for(int y=0; y<(j.size());y++){
                if(j.get(y).equals(k.getRegNr())){
                    System.out.println(x+" "+y+" "+k.getRegNr());
                    fail();
                }
            }
            j.add(k.getRegNr());
        }
        assertTrue(true);
    }
    @Test
    public void TestbilverkstadAdd(){
        Bilverkstad<Volvo240> x=new Bilverkstad<>(new Point(0,0),5);
        Volvo240 y=new Volvo240();
        assertTrue(x.add(y));

    }
    @Test
    public void TestbilverkstadGet(){
        Bilverkstad<Volvo240> x=new Bilverkstad<>(new Point(0,0),5);
        Volvo240 y=new Volvo240();
        x.add(y);
        assertSame(x.get(y.getRegNr()), y);

    }
    @Test
    public void TestCarTransportloadRampDown(){
        CarTransport x=new CarTransport();
        Volvo240 y= new Volvo240();
        assertFalse(x.load(y));
    }
    @Test
    public void TestCarTransportloadRampUp(){
        CarTransport x=new CarTransport();
        Volvo240 y= new Volvo240();
        x.raiseRamp();
        assertTrue(x.load(y));
    }
    @Test
    public void TestCarTransportGet(){
        CarTransport x=new CarTransport();
        Volvo240 y= new Volvo240();
        x.raiseRamp();
        x.load(y);
        assertSame(x.release(), y);
    }
    @Test
    public void TestCarFerryLowerRamp(){
        CarFerry ferry=new CarFerry();
        Volvo240 y= new Volvo240();

        assertTrue(ferry.lowerRamp());
    }
    @Test
    public void TestCarFerryLoad(){
        CarFerry ferry=new CarFerry();
        Volvo240 y= new Volvo240();
        ferry.lowerRamp();
        assertTrue(ferry.load.load(y));
    }
    @Test
    public void TestCarFerryGet(){
        CarFerry ferry=new CarFerry();
        Volvo240 y= new Volvo240();
        ferry.lowerRamp();
        ferry.load.load(y);
        ferry.load.load(new Saab95());
        assertSame(ferry.load.release(), y);
    }
    @Test
    public void TestScaniaMoveRampUpX(){
        Scania s = new Scania();
        s.raiseRamp();
        Point p = s.getPosition();
        s.move();
        assertEquals(s.getPosition().getX(),p.x,0.01);
    }
    @Test
    public void TestScaniaMoveRampUpY(){
        Scania s = new Scania();
        s.raiseRamp();
        Point p = s.getPosition();
        s.move();
        assertEquals(s.getPosition().getY(),p.y,0.01);
    }
   /* @Test         cannot compare pictures easily
    public void TestPicture() throws IOException {
        File file=new File("pics");
        Image x= ImageIO.read(new File(file.getAbsolutePath()+"/Volvo240.jpg"));
        Volvo240 volvo=new Volvo240();

        assertTrue(volvo.getPicture().equals(x));
    }*/
}