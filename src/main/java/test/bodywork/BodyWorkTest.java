package test.bodywork;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import industry.bodywork.BodyWork;

public class BodyWorkTest extends TestCase {

  public BodyWorkTest() {
    super("Body Work Test");
  }

  public static Test suite() {
    return new TestSuite(BodyWorkTest.class);
  }

  public void testGetInstance() {
//    test if return a singleton
    BodyWork pickup = BodyWork.getInstance("pickup");
    BodyWork pickup2 = BodyWork.getInstance("pickup");

    assertEquals(pickup, pickup2);
  }

  public void testGetAllInstances() {
//    test if that returns all instances added in the bodiesWork
    String[] bodies = { "pickup", "SUV", "hatch", "sedan", "sedan"};
    for (String body : bodies) {
      BodyWork.getInstance(body);
    }
    BodyWork[] allBodies = BodyWork.getAllInstances();
    assertEquals(4, allBodies.length);
    assertEquals(BodyWork.getInstance("pickup"), allBodies[0]);
    assertEquals(BodyWork.getInstance("SUV"), allBodies[1]);
    assertEquals(BodyWork.getInstance("hatch"), allBodies[2]);
    assertEquals(BodyWork.getInstance("sedan"), allBodies[3]);
  }
}
