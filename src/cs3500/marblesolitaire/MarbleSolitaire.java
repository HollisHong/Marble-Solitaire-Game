package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelImpl;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModelImpl;

/**
 * represent a MarbleSolitaire class which is used to run the main method in this class.
 */
public final class MarbleSolitaire {

  /**
   * The main method to render the board for the user to play.
   *
   * @param args the row number of the position to be moved from
   */
  public static void main(String[] args) {
    if (args.length > 0) {
      if (args[0].equals("english")) {
        if (args.length > 2 && args[1].equals("-size")) {
          new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
                  .playGame(new MarbleSolitaireModelImpl(Integer.parseInt(args[2])));
        }
        if (args.length > 3 && args[1].equals("-hole")) {
          new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
                  .playGame(new MarbleSolitaireModelImpl(3,
                          Integer.parseInt(args[2]), Integer.parseInt(args[3])));

        } else {
          new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
                  .playGame(new MarbleSolitaireModelImpl());
        }
      }
      if (args[0].equals("european")) {
        if (args.length > 2 && args[1].equals("-size")) {
          new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
                  .playGame(new EuropeanSolitaireModelImpl(Integer.parseInt(args[2])));
        }
        if (args.length > 3 && args[1].equals("-hole")) {
          new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
                  .playGame(new EuropeanSolitaireModelImpl(3,
                          Integer.parseInt(args[2]), Integer.parseInt(args[3])));

        } else {
          new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
                  .playGame(new EuropeanSolitaireModelImpl());
        }
      }
      if (args[0].equals("triangular")) {
        if (args.length > 2 && args[1].equals("-size")) {
          new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
                  .playGame(new TriangleSolitaireModelImpl(Integer.parseInt(args[2])));
        }
        if (args.length > 3 && args[1].equals("-hole")) {
          new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
                  .playGame(new TriangleSolitaireModelImpl(5,
                          Integer.parseInt(args[2]), Integer.parseInt(args[3])));

        } else {
          new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out)
                  .playGame(new TriangleSolitaireModelImpl());
        }
      }
    }
  }
}