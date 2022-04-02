import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
class Main {
  public static void main(String[] args)throws IOException {
    
    JFrame frame = new JFrame("Image Viewer");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Scanner sc = new Scanner(System.in);
    //String url = sc.nextLine();
    //System.out.println(url);
    int width;
    int height;
    BufferedImage image =null;
    File f=null;
    try{
      f = new File("D:\\images\\photo-1533450718592-29d45635f0a9.jpg");
      image = ImageIO.read(f);
      width = image.getWidth();
      height = image.getHeight();
      image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
      System.out.println("Read complete.");
    }
    catch(IOException e){
      System.out.println("Error:"+e);
    }
    
    ImageIcon imgIcon = new ImageIcon(image);
    JLabel lbl = new JLabel();
    lbl.setIcon(imgIcon);
    frame.add(lbl, BorderLayout.CENTER);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    System.out.println("done");
    
    /*
    try{
      f = new File("C:\\Users\\Rohan\\Downloads\\Output.jpg");
      ImageIO.write(image, "jpg",f);
      System.out.println("writing complete");
    }
    catch(IOException e){
      System.out.println("Error: "+e);
    }
    */
  }
}
