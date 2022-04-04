import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.SwingUtilities;

public class Main extends JPanel{
  BufferedImage img;
  static int width;
  static int height;
  
  public Main(){
    setSize(width,height);
    setVisible(true);
    loadImage("photo-1533450718592-29d45635f0a9.jpg");
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
    JFrame frm = new JFrame();
    frm.setSize(700,500);
    frm.setVisible(true);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.add(new Main());
  }
}
