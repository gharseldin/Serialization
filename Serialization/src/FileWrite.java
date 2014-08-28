import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileWrite {

	public static void main(String[] args) {

		String first = "This is the first line";
		String second = "This is the second line";
		String third = "This is the third line";

		
		try {
			FileOutputStream fs = new FileOutputStream("newFile.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeObject(first);
			os.writeObject(second);
			os.writeObject(third);
			
			System.out.println("All objects Written");
			
			
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
