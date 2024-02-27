package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.User;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<User> list = new ArrayList<>();
		
		String path = "S:\\ws\\ws-eclipse\\register_system\\formulario.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
			String name = sc.nextLine();
			String email = sc.nextLine();
			int age = sc.nextInt();
			double height = sc.nextDouble();
			
			User user = new User(name, email, age, height);
			
			System.out.println(user);
			
			list.add(user);
			
			File sourceFile = new File(path);
			
			String sourceFolderStr = sourceFile.getParent();
			
			boolean success = new File(sourceFolderStr + "\\Users").mkdir();
			
			String[] fields = user.getName().split(" ");
			String firstName = fields[0];
			String secondName = fields[1];
			
			String targetFileStr = sourceFolderStr + "\\Users\\" + firstName.toUpperCase() + secondName.toUpperCase() + ".txt";
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
				
				for (User info : list) {
					bw.write(user.getName() + "\n" + user.getEmail() + "\n" + user.getAge() + "\n" + user.getHeight() + "\n");
				}	
				
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}