package co.pragra.learning.pragraec;

import co.pragra.learning.pragraec.service.DummyClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PragraEcApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void test1(){
        DummyClass service = new DummyClass();
        String s = service.demoMethod();
        assertEquals("matchme",s);
    }

}
