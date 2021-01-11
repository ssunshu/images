import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Scanner;

public class repo {
  private static String s = System.getProperty("user.dir");
  public static void main(String[] args){ 
    File f;
    System.setProperty("user.dir", s +"\\Images");
    
    String imageFile = System.getProperty("user.dir");
    System.out.println(imageFile);
    
    System.out.println("What would you like to do");
    System.out.println("1 - add image");
    System.out.println("2 - remove image");
    System.out.println("Any other key - exit");
    
    Scanner input = new Scanner(System.in);
    String command = input.nextLine();
    
    if(command.equals("1")) {
      System.out.println("Enter the url of the image to be added");
      String url = input.nextLine();
      
      try {
        downloadImage(url, imageFile);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
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
  
  public static void downloadImage(String imageUrl, String imageFile) throws IOException {
    URL url = new URL(imageUrl);
    String fileName = url.getFile();
    String destName = imageFile + fileName.substring(fileName.lastIndexOf("/"));
    System.out.println(destName);
 
    InputStream is = url.openStream();
    OutputStream os = new FileOutputStream(destName);
 
    byte[] b = new byte[2048];
    int length;
 
    while ((length = is.read(b)) != -1) {
        os.write(b, 0, length);
    }
 
    is.close();
    os.close();
  }
}
