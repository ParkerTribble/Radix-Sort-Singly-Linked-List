package BookSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;


public class BookListSort {
	public static LinkedList books;
	public static LinkedList[] bins;
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		setup();
		radixSort();
		System.out.println("\nThe Linked List\n");
		books.print();
		newFile();
		long end = System.currentTimeMillis();
		long total = (end - start);
		System.out.println("Program took "+total+" miliseconds to run");
	}
	
	public static void radixSort(){
		Node temp;
		for(int c=24; c>=0; c--){
			while(!books.isempty()){
				temp = books.removeFront();
				char ch = 0;
				if(temp.author.toCharArray().length - 1 >= c)
					ch = temp.author.toCharArray()[c];
				if(Character.isAlphabetic(ch)) ch = Character.toLowerCase(ch);
				bins[ch].insertRear(temp);
			}
			for(int i = 0; i<bins.length; i++){
				books.append(bins[i]);
			}
		}
	}
	
	public static void setup(){
		String name;
		books = new LinkedList();
		bins = new LinkedList[256];
		for(int i = 0; i<bins.length; i++)
			bins[i] = new LinkedList();		
		
		Node bk;
		File diskfile = new File("C:\\Users\\James\\workspace\\book.txt");
		Scanner namefile = null;
		try {
			namefile = new Scanner(diskfile);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the book file!");
			System.exit(1);
		}

		while (namefile.hasNext()) {
			name = namefile.nextLine();
			String callNum = name.substring(0,19);
			String author = name.substring(20,45);
			String title = name.substring(45,name.length()-1);
			bk = new Node(author, title, callNum, null);
			books.insertRear(bk);
		}
	}
	
	public static void newFile(){
	 
		File file = new File("C:\\Users\\James\\workspace\\sortedbooks.txt");
		FileWriter fw;
		
		BufferedWriter writer;
		try
		{
			if(file.exists())
			{
				fw = new FileWriter(file);
			}else{
				file.createNewFile();
				fw = new FileWriter(file);
			}
				writer = new BufferedWriter(fw);
				while(!books.isempty()){
					Node node = books.removeFront();
					if(node != null){
						//System.out.println(node.toString());
						writer.write(node.toString());
						writer.newLine();
					}
				}
				writer.close();
		}
				catch(IOException e){
					System.out.println("could not write the file");
					System.exit(1);
				}
		
		
}
}


