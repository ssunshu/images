import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class repo {
  private static String s = System.getProperty("user.dir");
  public static void main(String[] args){ 
    File f;
    System.setProperty("user.dir", s +"\\Images");
    
    String imageFile = System.getProperty("user.dir");
    
    System.out.println("What would you like to do");
    System.out.println("1 - add image");
    System.out.println("2 - remove image");
    System.out.println("Any other key - exit");
    
    Scanner input = new Scanner(System.in);
    String command = input.nextLine();
    
    if(command.equals("1")) {
      System.out.println("Enter the full address of the image to be added");
      String image = input.nextLine();
      
      f = new File(image);
      if(f.exists() && !f.isDirectory()) { 
        File dest = new File(imageFile);
        try {
          copyFileUsingStream(f, dest);
          System.out.println("successfully copied");
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    
    else if(command.equals("2")) {
      System.out.println("delete image");
      System.setProperty("user.dir", imageFile);
      System.out.println("Enter the name of the image to be deleted");
      String image = input.nextLine();
      
      f = new File(imageFile + "\\" + "image");
      if(f.exists() && !f.isDirectory()) { 
        if(f.delete()) 
        { 
            System.out.println("File deleted successfully"); 
        } 
        else
        { 
            System.out.println("Failed to delete the file"); 
        } 
      }
    }
    
    else {
      System.out.println("exited");
      System.exit(0);
    }
  }
  
  private static void copyFileUsingStream(File source, File dest) throws IOException {
    InputStream i = null;
    OutputStream o = null;
    try {
        i = new FileInputStream(source);
        o = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = i.read(buffer)) > 0) {
            o.write(buffer, 0, length);
        }
    } finally {
        i.close();
        o.close();
    }
}
}
