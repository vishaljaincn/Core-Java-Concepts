package serializationdeserialisation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Student student = new Student(12, "Vishal Jain", "Jain Street, Chamarajanagar");
		Student student2= new Student(15, "anil Jain", "madison Street, los angles");
		student.setX(10);
		System.out.println(student.getX());

		// Construct the file path for the Downloads folder
		String userHome = System.getProperty("user.home");
		String filename = userHome + "/Downloads/ser.txt";

		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;

		// Serialization
		fileOut = new FileOutputStream(filename);
		objOut = new ObjectOutputStream(fileOut);
		objOut.writeObject(student);
		objOut.writeObject(student2);

		System.out.println("Object is now serialized");
		System.out.println(student);
		fileOut.close();
		objOut.close();

		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;

		// Deserialization
		fileIn = new FileInputStream(filename);
		objIn = new ObjectInputStream(fileIn);
		Student student1 = (Student) objIn.readObject();

		System.out.println("Object is now deserialized");
		System.out.println(student1);
		System.out.println(student1.getX());
		fileIn.close();
		objIn.close();
	}
}
