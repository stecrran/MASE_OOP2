import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		User user = null;
		FileInputStream fileIn = new FileInputStream("C:\\Users\\ohsev\\eclipse-workspace_2025\\Serializer\\UserInfo.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		
		user = (User) in.readObject();
		in.close();
		fileIn.close();
		
		System.out.println(user.name);
		System.out.println(user.password);
		user.sayHello();
		
		long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
		System.out.println(serialVersionUID);
	}
}
