import javax.swing.*;

public class PrimaryWindow extends JFrame{

  /**
   * Constructor for PrimaryWindow
   * Creates object and renders it on screen
   * @param width  window width
   * @param height window height
   */
  public PrimaryWindow(int width, int height){
    super();
    super.setSize(width, height);
    super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    super.setVisible(true);
  }
}
