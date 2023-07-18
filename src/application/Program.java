package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			Map<String, Integer> candidates = new HashMap<>();
			
			while (line != null) {				
				String[] fields = line.split(",");				
				String name = fields[0];
				int votes = Integer.parseInt(fields[1]);
				
				if (candidates.containsKey(name)) {
					int replace = candidates.get(name); // retorna a quantidade de votos anterior
					candidates.replace(name, votes + replace);
				}
				
				else {
					candidates.put(name, votes);
				}
				
				line = br.readLine();
			}
			for (String candidate : candidates.keySet()) {
				System.out.println(candidate + ": " + candidates.get(candidate));
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}
}
