import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class FileRead {

	public static void main(String[] args) {

		try {
			FileInputStream fs = new FileInputStream("newFile.txt");
			ObjectInputStream os = new ObjectInputStream(fs);
			
			System.out.println((String)os.readObject());
			System.out.println((String)os.readObject());
			System.out.println((String)os.readObject());
			
			os.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
