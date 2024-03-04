import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.teste.Valores;


public class ValoresTest {

  Valores valores;

  @Before
  public void setUp() throws Exception {
    valores = new Valores();

    valores.ins(1);
    valores.ins(2);
    valores.ins(3);
    valores.ins(4);
    valores.ins(5);
  }


  @Test
  public void testIns() {
    assertTrue(valores.ins(6));
    assertTrue(valores.ins(7));

    assertFalse(valores.ins(0));
    assertFalse(valores.ins(-1));
  }

  @Test
  public void testDel() {
    assertEquals(1, valores.del(0));
    assertEquals(2, valores.del(1));
    assertEquals(3, valores.del(2));
  }

  @Test
  public void testSize() {
    assertEquals(5, valores.size());
  }
  
}
