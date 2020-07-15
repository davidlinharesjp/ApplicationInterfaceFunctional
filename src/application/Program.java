package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entity.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o Path do aqrquivo");
		String path = sc.nextLine();
		
		int cont = 0;

		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {

			List<Product> products = new ArrayList<>();

			String line = bf.readLine();
			while (line != null) {
				cont++;
				String[] fields = line.split(",");
				products.add(new Product(Long.parseLong(fields[0]), fields[1], Double.parseDouble(fields[2])));
				line = bf.readLine();
			}
			
			Double avg = products.stream()
			.map(p -> p.getPrice())
			.reduce(0D,  (x,y) -> x+y);
			
			System.out.println("A media dos Produtos: "+ (avg / cont));
			
			Comparator<String> comp = (s1, s2 ) -> s1.toUpperCase().compareToIgnoreCase(s2);
			List<String> names = products.stream()
					.filter(p -> p.getPrice() < avg)
					.map(p -> p.getName().toUpperCase())
					.sorted(comp.reversed())
					.collect(Collectors.toList());
			
			names.forEach(System.out :: println);
			System.out.println("Final");
			
			

		} catch (IOException e) {
			System.out.println("Message Error:" + e.getMessage());
		}
		
		sc.close();

	}
	
}
