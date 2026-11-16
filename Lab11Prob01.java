import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab11Prob01 {

	public static void main(String[] args) {

		try (DataInputStream input = new DataInputStream(
				new BufferedInputStream(new FileInputStream("src/people.dat")));
				DataOutputStream output = new DataOutputStream(
						new BufferedOutputStream(new FileOutputStream("src/people-copy.dat")));) {
			int age = 0;
			String name = "";
			String address = "";
			int zipcode = 0;
			double salary = 0;
			while (true) {
				age = input.readInt();
				name = input.readUTF();
				address = input.readUTF();
				zipcode = input.readInt();
				salary = input.readDouble();

				System.out.printf("%d%n%s%n%s%n%d%n%.2f%n%n", age, name, address, zipcode, salary);

				output.writeInt(age);
				output.writeUTF(name);
				output.writeUTF(address);
				output.writeInt(zipcode);
				output.writeDouble(salary);
			}
		} catch (EOFException e) {
			System.out.println("EOF");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOE");
			e.printStackTrace();
		}
	}
}
