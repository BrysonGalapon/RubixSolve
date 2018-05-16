package src;

import java.util.*;

/**
 * Represents a mutable Rubix Cube
 */
public class RubixCube {
  // Maps a color to the face of the cube
  private final Map<Color, Face> c2f;

  /**
   * Create a new Rubix Cube
   */
  public RubixCube() {
    this.c2f = new HashMap<Color, Face>();

    this.c2f.put(Color.RED, new Face(Color.RED));
    this.c2f.put(Color.WHITE, new Face(Color.WHITE));
    this.c2f.put(Color.BLUE, new Face(Color.BLUE));
    this.c2f.put(Color.GREEN, new Face(Color.GREEN));
    this.c2f.put(Color.ORANGE, new Face(Color.ORANGE));
    this.c2f.put(Color.YELLOW, new Face(Color.YELLOW));
  }

  /**
   * Get the face of this cube of a particular color
   * @param color the color of the side to get
   */
  public Face getFace(Color color) {
    return this.c2f.get(color).copy();
  }

  /**
   * Rotates a particular side a certain direction
   * @param color color of the side to turn
   * @param direction the direction to turn that side
   */
  public void rotate(Color color, Direction direction) {
    switch(color) {
      case RED:
        rotateRed(direction);
        break;
      case WHITE:
        rotateWhite(direction);
        break;
      case BLUE:
        rotateBlue(direction);
        break;
      case GREEN:
        rotateGreen(direction);
        break;
      case ORANGE:
        rotateOrange(direction);
        break;
      case YELLOW:
        rotateYellow(direction);
        break;
      default:
        throw new Error("Unhandled Color");
    }
  }

  /**
   * Rotates the Red side a certain direction
   * @param direction the direction to turn that side
   */
  public void rotateRed(Direction direction) {
    // get all the relevant faces
    Face redFace = this.c2f.get(Color.RED);
    Face whiteFace = this.c2f.get(Color.WHITE);
    Face blueFace = this.c2f.get(Color.BLUE);
    Face yellowFace = this.c2f.get(Color.YELLOW);
    Face greenFace = this.c2f.get(Color.GREEN);

    // rotate the colors on rotating face
    redFace.rotate(direction);

    // get all the relevant colors on sides
    Color[] whiteColors = whiteFace.getColumn(3);
    Color[] blueColors = blueFace.getRow(3);
    Color[] yellowColors = yellowFace.getColumn(1);
    Color[] greenColors = greenFace.getRow(1);

    // rotate them, given the direction
    switch(direction) {
      case CLOCKWISE:
        whiteFace.setColumn(3, greenColors, true);
        blueFace.setRow(3, whiteColors, true);
        yellowFace.setColumn(1, blueColors, true);
        greenFace.setRow(1, yellowColors, true);
        break;
      case COUNTER_CLOCKWISE:
        whiteFace.setColumn(3, blueColors, true);
        blueFace.setRow(3, yellowColors, true);
        yellowFace.setColumn(1, greenColors, true);
        greenFace.setRow(1, whiteColors, true);
        break;
      default:
        throw new Error("Unhandled Direction");
    }
  }

  /**
   * Rotates the White side a certain direction
   * @param direction the direction to turn that side
   */
  public void rotateWhite(Direction direction) {
    // get all the relevant faces
    Face whiteFace = this.c2f.get(Color.WHITE);
    Face redFace = this.c2f.get(Color.RED);
    Face blueFace = this.c2f.get(Color.BLUE);
    Face greenFace = this.c2f.get(Color.GREEN);
    Face orangeFace = this.c2f.get(Color.ORANGE);

    // rotate the colors on rotating face
    whiteFace.rotate(direction);

    // get all the relevant colors on sides
    Color[] redColors = redFace.getColumn(1);
    Color[] blueColors = blueFace.getColumn(1);
    Color[] greenColors = greenFace.getColumn(1);
    Color[] orangeColors = orangeFace.getColumn(1);

    // rotate them, given the direction
    switch(direction) {
      case CLOCKWISE:
        redFace.setColumn(1, blueColors, true);
        blueFace.setColumn(1, orangeColors, true);
        greenFace.setColumn(1, redColors, true);
        orangeFace.setColumn(1, greenColors, true);
        break;
      case COUNTER_CLOCKWISE:
        redFace.setColumn(1, greenColors, true);
        blueFace.setColumn(1, redColors, true);
        greenFace.setColumn(1, orangeColors, true);
        orangeFace.setColumn(1, blueColors, true);
        break;
      default:
        throw new Error("Unhandled Direction");
    }
  }

  /**
   * Rotates the Blue side a certain direction
   * @param direction the direction to turn that side
   */
  public void rotateBlue(Direction direction) {
    // TODO
  }

  /**
   * Rotates the Green side a certain direction
   * @param direction the direction to turn that side
   */
  public void rotateGreen(Direction direction) {
    // TODO
  }

  /**
   * Rotates the Orange side a certain direction
   * @param direction the direction to turn that side
   */
  public void rotateOrange(Direction direction) {
    // TODO
  }

  /**
   * Rotates the Yellow side a certain direction
   * @param direction the direction to turn that side
   */
  public void rotateYellow(Direction direction) {
    // get all the relevant faces
    Face yellowFace = this.c2f.get(Color.YELLOW);
    Face redFace = this.c2f.get(Color.RED);
    Face blueFace = this.c2f.get(Color.BLUE);
    Face greenFace = this.c2f.get(Color.GREEN);
    Face orangeFace = this.c2f.get(Color.ORANGE);

    // rotate the colors on rotating face
    yellowFace.rotate(direction);

    // get all the relevant colors on sides
    Color[] redColors = redFace.getColumn(3);
    Color[] blueColors = blueFace.getColumn(3);
    Color[] greenColors = greenFace.getColumn(3);
    Color[] orangeColors = orangeFace.getColumn(3);

    // rotate them, given the direction
    switch(direction) {
      case CLOCKWISE:
        redFace.setColumn(3, greenColors, true);
        blueFace.setColumn(3, redColors, true);
        greenFace.setColumn(3, orangeColors, true);
        orangeFace.setColumn(3, blueColors, true);
       break;
      case COUNTER_CLOCKWISE:
        redFace.setColumn(3, blueColors, true);
        blueFace.setColumn(3, orangeColors, true);
        greenFace.setColumn(3, redColors, true);
        orangeFace.setColumn(3, greenColors, true);
       break;
      default:
        throw new Error("Unhandled Direction");
    }
  }

  /**
   * Get string representation for this cube
   * @return six 3-by-3 arrays representing each face of the cube, in order of 
   *          1. RED face
   *          2. WHITE face
   *          3. BLUE face
   *          4. GREEN face
   *          5. ORANGE face
   *          6. YELLOW face
   *
   *          where each array is a tab-delimited, and the color of each 
   *          cubelet face is described by the following map:
   *          - RED = "R"
   *          - WHITE = "W"
   *          - BLUE = "B"
   *          - GREEN = "G"
   *          - ORANGE = "O"
   *          - YELLOW = "Y"
   *
   *         also, each array is separated by a newline ('\n') character
   */
  @Override
  public String toString() {
    String rep = "";
    // red 
    rep += this.c2f.get(Color.RED).toString();
    rep += "\n";
    // white
    rep += this.c2f.get(Color.WHITE).toString();
    rep += "\n";
    // blue 
    rep += this.c2f.get(Color.BLUE).toString();
    rep += "\n";
    // green 
    rep += this.c2f.get(Color.GREEN).toString();
    rep += "\n";
    // orange 
    rep += this.c2f.get(Color.ORANGE).toString();
    rep += "\n";
    // yellow 
    rep += this.c2f.get(Color.YELLOW).toString();
    rep += "\n";

    return rep;
  }
  


}
