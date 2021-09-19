
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;


/**
 * represents a test class for MarbleSolitaireModelImpl.
 */
public class MarbleSolitaireModelImplTest {

  MarbleSolitaireModelImpl mar1;
  MarbleSolitaireModelImpl mar2;
  MarbleSolitaireModelImpl mar3;
  MarbleSolitaireModelImpl mar4;
  MarbleSolitaireModelImpl mar5;


  /**
   * init the data we need to use for test.
   */
  public void init() {
    mar1 = new MarbleSolitaireModelImpl();
    mar2 = new MarbleSolitaireModelImpl(4, 3);
    mar3 = new MarbleSolitaireModelImpl(9);
    mar4 = new MarbleSolitaireModelImpl(9, 10, 10);
    mar5 = new MarbleSolitaireModelImpl(1);
  }

  @Test
  public void testConstructor1() {
    this.init();
    assertEquals("    O O O\n" + "    O O O\n" + "O O O O O O O\n" + "O O O _ O O O\n"
            + "O O O O O O O\n" + "    O O O\n" + "    O O O", mar1.getGameState());
  }

  @Test
  public void testConstructor2() {
    this.init();
    assertEquals("    O O O\n" + "    O O O\n" + "O O O O O O O\n" + "O O O O O O O\n"
            + "O O O _ O O O\n" + "    O O O\n" + "    O O O", mar2.getGameState());
  }

  @Test
  public void testConstructor3() {
    this.init();
    assertEquals(
            "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O _ O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O",
            mar3.getGameState());
  }

  @Test
  public void testConstructor4() {
    this.init();
    assertEquals(
            "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O _ O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O O O O O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O\n"
                    + "                O O O O O O O O O\n" + "                O O O O O O O O O",
            mar4.getGameState());
  }

  @Test
  public void testConstructor5() {
    try {
      new MarbleSolitaireModelImpl(10, 10);
    } catch (IllegalArgumentException e) {
      assertEquals("Input needs to be valid", e.getMessage());
    }
  }

  @Test
  public void testConstructor6() {
    try {
      new MarbleSolitaireModelImpl(1, 1);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (1,1)", e.getMessage());
    }
  }

  @Test
  public void testConstructor7() {
    try {
      new MarbleSolitaireModelImpl(10);
    } catch (IllegalArgumentException e) {
      assertEquals("Input is not a positive odd number", e.getMessage());
    }
  }


  @Test
  public void testConstructor8() {
    try {
      new MarbleSolitaireModelImpl(1, 3, 3);
    } catch (IllegalArgumentException e) {
      assertEquals("Inputs are invalid", e.getMessage());
    }
  }

  @Test
  public void testConstructor9() {
    try {
      new MarbleSolitaireModelImpl(3, 1, 1);
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid empty cell position (1,1)", e.getMessage());
    }
  }



  @Test
  public void testMove1() {
    this.init();
    mar1.move(5, 3, 3, 3);
    assertEquals("    O O O\n" + "    O O O\n" + "O O O O O O O\n" + "O O O O O O O\n"
            + "O O O _ O O O\n" + "    O _ O\n" + "    O O O", mar1.getGameState());
  }

  @Test
  public void testMove2() {
    this.init();
    mar1.move(3, 5, 3, 3);
    assertEquals("    O O O\n" + "    O O O\n" + "O O O O O O O\n" + "O O O O _ _ O\n"
            + "O O O O O O O\n" + "    O O O\n" + "    O O O", mar1.getGameState());
  }

  @Test
  public void testMove3() {
    this.init();
    try {
      mar1.move(-1,0,0,1);
    } catch (IllegalArgumentException e) {
      assertEquals("invalid(outbound) input given", e.getMessage());
    }
  }

  @Test
  public void testMove4() {
    this.init();
    try {
      mar1.move(0,0,0,1);
    } catch (IllegalArgumentException e) {
      assertEquals("from or to position is invalid", e.getMessage());
    }
  }

  @Test
  public void testMove5() {
    this.init();
    try {
      mar1.move(3,3,3,5);
    } catch (IllegalArgumentException e) {
      assertEquals("Need a marble at the “from” position", e.getMessage());
    }
  }

  @Test
  public void testMove6() {
    this.init();
    try {
      mar1.move(3,4,3,6);
    } catch (IllegalArgumentException e) {
      assertEquals("Need a empty space at the “to” position", e.getMessage());
    }
  }

  @Test
  public void testMove7() {
    this.init();
    try {
      mar1.move(3,4,3,3);
    } catch (IllegalArgumentException e) {
      assertEquals("the “to” and “from” positions need exactly two positions away"
              , e.getMessage());
    }
  }

  @Test
  public void testMove8() {
    this.init();
    try {
      mar1.move(5,3,3,3);
      mar1.move(6,3,4,3);
    } catch (IllegalArgumentException e) {
      assertEquals("a marble needed between from and to", e.getMessage());
    }
  }

  @Test
  public void testMove9() {
    this.init();
    try {
      mar1.move(3,5,3,3);
      mar1.move(3,6,3,4);
    } catch (IllegalArgumentException e) {
      assertEquals("a marble needed between from and to", e.getMessage());
    }
  }

  @Test
  public void testMove10() {
    this.init();
    try {
      mar4.move(3,5,3,2);
    } catch (IllegalArgumentException e) {
      assertEquals("from or to position is invalid", e.getMessage());
    }
  }


  @Test
  public void testIsGameOver1() {
    this.init();
    assertEquals(false, mar1.isGameOver());
  }

  @Test
  public void testIsGameOver2() {
    this.init();
    assertEquals(false, mar2.isGameOver());
  }

  @Test
  public void testIsGameOver3() {
    this.init();
    assertEquals(false, mar3.isGameOver());
  }

  @Test
  public void testIsGameOver4() {
    this.init();
    assertEquals(false, mar4.isGameOver());
  }


  @Test
  public void testIsGameOver5() {
    this.init();
    assertEquals(true, mar5.isGameOver());
  }


  @Test
  public void testGetScore1() {
    this.init();
    assertEquals(32, mar1.getScore());
  }

  @Test
  public void testGetScore2() {
    this.init();
    assertEquals(368, mar3.getScore());
  }

  @Test
  public void testGetScore3() {
    this.init();
    assertEquals(0, mar5.getScore());
  }

}