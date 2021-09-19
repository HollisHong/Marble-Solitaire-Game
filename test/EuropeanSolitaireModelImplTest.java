
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;


/**
 * represents a test class for MarbleSolitaireModelImpl.
 */
public class EuropeanSolitaireModelImplTest {

  EuropeanSolitaireModelImpl euro1;
  EuropeanSolitaireModelImpl euro2;
  EuropeanSolitaireModelImpl euro3;
  EuropeanSolitaireModelImpl euro4;
  EuropeanSolitaireModelImpl euro5;

  /**
   * init the data we need to use for test.
   */
  public void init() {
    euro1 = new EuropeanSolitaireModelImpl();
    euro2 = new EuropeanSolitaireModelImpl(9);
    euro3 = new EuropeanSolitaireModelImpl(1);
    euro4 = new EuropeanSolitaireModelImpl(3, 2, 2);
    euro5 = new EuropeanSolitaireModelImpl(4, 3);
  }

  @Test
  public void testConstructor1() {
    this.init();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euro1.getGameState());
  }

  @Test
  public void testConstructor2() {
    this.init();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O O O O\n" +
            "    O O O", euro5.getGameState());
  }

  @Test
  public void testConstructor3() {
    this.init();
    assertEquals("                O O O O O O O O O\n" +
            "              O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O _ O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O\n" +
            "              O O O O O O O O O O O\n" +
            "                O O O O O O O O O", euro2.getGameState());
  }

  @Test
  public void testConstructor4() {
    this.init();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euro4.getGameState());
  }

  // test the constructor with wrong input (0,0).
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor5() {
    new EuropeanSolitaireModelImpl(0, 0);
  }

  // test the constructor with wrong input (0,1).
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor5_1() {
    new EuropeanSolitaireModelImpl(0, 1);

  }

  // test the constructor with wrong input (4, which is even).
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor6() {
    new EuropeanSolitaireModelImpl(4);
  }

  // test the constructor with wrong input (10, which is even).
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor6_1() {
    new EuropeanSolitaireModelImpl(10);
  }

  // test the constructor with wrong input (3, 0, 0).
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor7() {
    new EuropeanSolitaireModelImpl(3, 0, 0);
  }

  // test the constructor with wrong input (10, 5, 5).
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor8() {
    new EuropeanSolitaireModelImpl(10, 5, 5);

  }


  // test move on Row
  @Test
  public void testMove1() {
    this.init();
    euro1.move(5, 3, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  O O _ O O\n" +
            "    O O O", euro1.getGameState());
  }

  //test move on the newer grid
  @Test
  public void testMove2() {
    this.init();
    euro1.move(5, 3, 3, 3);
    euro1.move(5, 1, 5, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "  _ _ O O O\n" +
            "    O O O", euro1.getGameState());
  }

  // test move on the newer grid
  @Test
  public void testMove3() {
    this.init();
    euro1.move(3, 5, 3, 3);
    euro1.move(1, 5, 3, 5);
    assertEquals("    O O O\n" +
            "  O O O O _\n" +
            "O O O O O _ O\n" +
            "O O O O _ O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euro1.getGameState());
  }

  //test move on Row
  @Test
  public void testMove4() {
    this.init();
    euro1.move(1, 3, 3, 3);
    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euro1.getGameState());
  }


  //test move on Col
  @Test
  public void testMove5() {
    this.init();
    euro1.move(3, 1, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", euro1.getGameState());
  }


  //if given a position to move *from* that does not exist?
  @Test(expected = IllegalArgumentException.class)
  public void testMove6() {
    this.init();
    euro1.move(-1, 0, 0, 1);
  }

  //if given a position to move *to* that does not exist?
  @Test(expected = IllegalArgumentException.class)
  public void testMove7() {
    this.init();
    euro1.move(0, 0, 0, -1);
  }


  //if given a position to move *from* does not have a marble?
  @Test(expected = IllegalArgumentException.class)
  public void testMove8() {
    this.init();
    euro1.move(3, 3, 5, 3);
  }

  //if given a position to move *from* does not have a marble?
  @Test(expected = IllegalArgumentException.class)
  public void testMove9() {
    this.init();
    euro1.move(3, 3, 3, 5);
  }

  //test if given a position to move *to* is not empty?
  @Test(expected = IllegalArgumentException.class)
  public void testMove10() {
    this.init();
    euro1.move(3, 3, 5, 3);
  }

  //test if the marble is jumping over an empty slot.
  @Test(expected = IllegalArgumentException.class)
  public void testMove11() {
    this.init();
    euro1.move(5,3,3,3);
    euro1.move(6,3,4,3);
  }

  //test if the from and to positions are more than two positions apart?
  @Test
  public void testMove12() {
    this.init();
    try {
      euro1.move(6,3,3,3);
      fail("no!");
    } catch (IllegalArgumentException e) {
      assertEquals("the “to” and “from” positions need exactly two positions away",
              e.getMessage());
    }
  }

  //if the move is diagonal (not horizontal or vertical, but still 2 positions away)?
  @Test
  public void testMove13() {
    this.init();
    try {
      euro1.move(5,5,3,3);
      fail("no!");
    } catch (IllegalArgumentException e) {
      assertEquals("the “to” and “from” positions need exactly two positions away",
              e.getMessage());
    }
  }

  @Test
  public void testGetScore1() {
    this.init();
    assertEquals(36, euro1.getScore());
    assertEquals(480, euro2.getScore());
    assertEquals(0,euro3.getScore());
  }


  @Test
  public void testIsGameOver() {
    this.init();
    assertFalse(euro1.isGameOver());
    assertTrue(euro3.isGameOver());
  }


}