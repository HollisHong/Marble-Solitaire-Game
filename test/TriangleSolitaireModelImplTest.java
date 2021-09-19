
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;


/**
 * represents a test class for MarbleSolitaireModelImpl.
 */
public class TriangleSolitaireModelImplTest {
  TriangleSolitaireModelImpl tri1;
  TriangleSolitaireModelImpl tri2;
  TriangleSolitaireModelImpl tri3;
  TriangleSolitaireModelImpl tri4;
  TriangleSolitaireModelImpl tri5;
  TriangleSolitaireModelImpl tri6;



  /**
   * init the data we need to use for test.
   */
  public void init() {
    tri1 = new TriangleSolitaireModelImpl();
    tri2 = new TriangleSolitaireModelImpl(6);
    tri3 = new TriangleSolitaireModelImpl(7);
    tri4 = new TriangleSolitaireModelImpl(5, 0, 0);
    tri5 = new TriangleSolitaireModelImpl(0, 0);
    tri6 = new TriangleSolitaireModelImpl(1);
  }

  @Test
  public void testConstructor1() {
    this.init();
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", tri1.getGameState());
  }

  @Test
  public void testConstructor2() {
    this.init();
    assertEquals("     _\n" +
            "    O O\n" +
            "   O O O\n" +
            "  O O O O\n" +
            " O O O O O\n" +
            "O O O O O O", tri2.getGameState());
  }


  @Test
  public void testConstructor3() {
    this.init();
    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", tri3.getGameState());
  }

  @Test
  public void testConstructor4() {
    this.init();
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", tri4.getGameState());
  }

  @Test
  public void testConstructor5() {
    this.init();
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", tri5.getGameState());
  }

  // test the constructor with wrong input -1.
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor6() {
    new TriangleSolitaireModelImpl(-1);
  }

  // test the constructor with wrong input -1.
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor7() {
    new TriangleSolitaireModelImpl(-1, 0, 0);
  }

  // test the constructor with wrong input (0,2) as the empty position.
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor8() {
    new TriangleSolitaireModelImpl(1, 0, 2);
  }

  // test the constructor with wrong input (0,-2) as the empty position.
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor9() {
    new TriangleSolitaireModelImpl(0, -2);
  }

  // test the constructor with wrong input (0,-2) as the empty position.
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor10() {
    new TriangleSolitaireModelImpl(10, 0, -2);
  }


  @Test
  public void testMove1() {
    this.init();
    tri1.move(2, 0, 0, 0);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", tri1.getGameState());
  }

  @Test
  public void testMove2() {
    this.init();
    tri1.move(2, 0, 0, 0);
    tri1.move(2, 2, 2, 0);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  O _ _\n" +
            " O O O O\n" +
            "O O O O O", tri1.getGameState());
  }

  @Test
  public void testMove3() {
    this.init();
    tri1.move(2, 0, 0, 0);
    tri1.move(2, 2, 2, 0);
    tri1.move(4, 3, 2, 1);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  O O _\n" +
            " O O _ O\n" +
            "O O O _ O", tri1.getGameState());
  }

  @Test
  public void testMove4() {
    this.init();
    tri1.move(2, 0, 0, 0);
    tri1.move(2, 2, 2, 0);
    tri1.move(4, 3, 2, 1);
    tri1.move(3, 0, 3, 2);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  O O _\n" +
            " _ _ O O\n" +
            "O O O _ O", tri1.getGameState());
  }

  @Test
  public void testMove5() {
    this.init();
    tri1.move(2, 0, 0, 0);
    tri1.move(2, 2, 2, 0);
    tri1.move(4, 3, 2, 1);
    tri1.move(3, 0, 3, 2);
    tri1.move(4, 2, 2, 2);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  O O O\n" +
            " _ _ _ O\n" +
            "O O _ _ O", tri1.getGameState());
  }

  @Test
  public void testMove6() {
    this.init();
    tri1.move(2, 0, 0, 0);
    tri1.move(4, 2, 2, 0);
    tri1.move(3, 3, 3, 1);
    tri1.move(2, 0, 4, 2);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O _ _ _\n" +
            "O O O O O", tri1.getGameState());
  }

  //if given a position to move *from* that does not exist?
  @Test(expected = IllegalArgumentException.class)
  public void testMove7() {
    this.init();
    tri1.move(-1, 0, 0, 1);
  }

  //if given a position to move *to* that does not exist?
  @Test(expected = IllegalArgumentException.class)
  public void testMove8() {
    this.init();
    tri1.move(0, 0, 0, -1);
  }


  //if given a position to move *from* does not have a marble?
  @Test(expected = IllegalArgumentException.class)
  public void testMove9() {
    this.init();
    tri1.move(3, 3, 5, 3);
  }

  //if given a position to move *from* does not have a marble?
  @Test(expected = IllegalArgumentException.class)
  public void testMove10() {
    this.init();
    tri1.move(3, 3, 3, 5);
  }

  //test if given a position to move *to* is not empty?
  @Test(expected = IllegalArgumentException.class)
  public void testMove11() {
    this.init();
    tri1.move(3, 3, 5, 3);
  }

  //test if the marble is jumping over an empty slot.
  @Test(expected = IllegalArgumentException.class)
  public void testMove12() {
    this.init();
    tri1.move(5, 3, 3, 3);
    tri1.move(6, 3, 4, 3);
  }

  //test if the from and to positions are more than two positions apart?
  @Test
  public void testMove13() {
    this.init();
    try {
      tri1.move(3, 0, 0, 0);
      fail("no!");
    } catch (IllegalArgumentException e) {
      assertEquals("the “to” and “from” positions need exactly two positions away",
              e.getMessage());
    }
  }

  //if the move is diagonal (not horizontal or vertical, but still 2 positions away)?
  @Test
  public void testMove14() {
    this.init();
    try {
      tri1.move(4, 0, 0, 0);
      fail("no!");
    } catch (IllegalArgumentException e) {
      assertEquals("the “to” and “from” positions need exactly two positions away",
              e.getMessage());
    }
  }

  @Test
  public void testGetScore1() {
    this.init();
    assertEquals(14, tri1.getScore());
    assertEquals(20, tri2.getScore());
    assertEquals(27, tri3.getScore());
  }


  @Test
  public void testIsGameOver() {
    this.init();
    assertFalse(tri1.isGameOver());
    assertTrue(tri6.isGameOver());
  }


}



