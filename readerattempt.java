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

  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(img,0,0,width,height,this);
    System.out.println("Print complete.");
  }

  public static void main(String[] args){
    System.out.println("Image URL: ");
    JFrame frm = new JFrame();
    frm.setVisible(true);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.add(new Main());
    frm.setSize(width,height);
    //System.out.println(width);
    //System.out.println(height);
  }
}
