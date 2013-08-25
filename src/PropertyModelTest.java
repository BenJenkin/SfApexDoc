import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class PropertyModelTest {
  @Test
  public void testPropertyModelInvalidParameters() {
    ArrayList<String> comments = new ArrayList<String>();
    try {
      new PropertyModel(null, null);
      assertTrue("invalid parameters", false);
    } catch (NullPointerException e) {
    }
    
    try {
      new PropertyModel("", null);
      assertTrue("invalid parameters", false);
    } catch (NullPointerException e) {
    }
    
    try {
      new PropertyModel(null, comments);
      assertTrue("invalid parameters", false);
    } catch (NullPointerException e) {
    }
  }
  
  @Test
  public void testGetName() {
    ArrayList<String> comments = new ArrayList<String>();
    
    PropertyModel m = new PropertyModel("", comments);
    assertEquals("", m.getName());
    
    m = new PropertyModel(" ", comments);
    assertEquals("", m.getName());
    
    m = new PropertyModel("\t", comments);
    assertEquals("", m.getName());
    
    m = new PropertyModel(" private static int whatever junk a = 5 ", comments);
    assertEquals("a", m.getName());
    
    m = new PropertyModel(" enum b  { 1, 2, 3}", comments);
    assertEquals("b", m.getName());
    
    m = new PropertyModel("String[] c = null", comments);
    assertEquals("c", m.getName());
    
    m = new PropertyModel("int d=5;", comments);
    assertEquals("d", m.getName());
    
    m = new PropertyModel(" int e; ", comments);
    assertEquals("e", m.getName());
    
    m = new PropertyModel("f", comments);
    assertEquals("f", m.getName());
    
    m = new PropertyModel(" g", comments);
    assertEquals("g", m.getName());
    
    m = new PropertyModel("h   ", comments);
    assertEquals("h", m.getName());
  }
}