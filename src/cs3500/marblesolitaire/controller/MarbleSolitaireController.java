package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;


/**
 * This interface represents the Controller of the game. One object of the Controller represents one
 * Controller of marble solitaire.
 */
public interface MarbleSolitaireController {

  /**
   * play the game with the controller by using the data from the model.
   *
   * @param model the model we are going to control
   * @throws IllegalArgumentException when the given model is null
   * @throws IllegalStateException    iff the Appendable object is unable to transmit output or the
   *                                  Readable object is unable to provide inputs
   */
  void playGame(MarbleSolitaireModel model);

}
