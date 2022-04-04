import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.SwingUtilities;
import java.util.Scanner;

public class Main extends JPanel{
  BufferedImage img;
  static int width;
  static int height;
  Scanner sc = new Scanner(System.in);
  String url = sc.nextLine();
  public Main(){
    //setSize(5,5);
    setVisible(true);
    loadImage(url);
  }

  public void loadImage(String URL){
    try{
      img = ImageIO.read(Main.class.getResource(URL));
      width = img.getWidth();
      height = img.getHeight();
      System.out.println("Read complete.");
    }
    catch(IOException e){
      e.printStackTrace();
    }
  }
  /*
  static final int PIXEL_SIZE = 20;
  static final int SCREEN_WIDTH = width;
  static final int SCREEN_HEIGHT = height;
  static final int ALL_PIXELS = (SCREEN_WIDTH*SCREEN_HEIGHT)/PIXEL_SIZE;
  */
  
  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(img,0,0,width,height,this);
    System.out.println("Print complete.");
  }

  static final int PIXEL_SIZE = 20;
  static int SCREEN_WIDTH = width;
  static int SCREEN_HEIGHT = height;
  static int ALL_PIXELS = (SCREEN_WIDTH*SCREEN_HEIGHT)/PIXEL_SIZE;

   public void draw(Graphics g){
        //if the game is on draw these lines that make up the grid
    //super.draw(g);
    for(int i =0; i<SCREEN_HEIGHT/PIXEL_SIZE;i++){
      g.drawLine(i*PIXEL_SIZE, 0, i*PIXEL_SIZE, SCREEN_HEIGHT);
      g.drawLine(0,i*PIXEL_SIZE, SCREEN_WIDTH, i*PIXEL_SIZE);
    }
  }
  
  public static void main(String[] args){
    System.out.println("Image URL: ");
    JFrame frm = new JFrame();
    frm.setVisible(true);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.add(new Main());
    frm.setSize(width,height);
    SCREEN_WIDTH = width;
    SCREEN_HEIGHT = height;
    System.out.println(SCREEN_WIDTH);
    System.out.println(SCREEN_HEIGHT);
    ALL_PIXELS = (SCREEN_WIDTH*SCREEN_HEIGHT)/PIXEL_SIZE;
    
    
  }
}
