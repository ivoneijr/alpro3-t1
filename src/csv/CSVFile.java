package csv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import parsers.CSVParser;

public class CSVFile <T>{

	private CSVParser<T> parser;
	private Scanner scanner;
	
	public void open(String filename){
		try {
			scanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		scanner.close();
	}
	
	public T readObject(){
		String line = "";
		if ((line = scanner.nextLine()) != null) {
			if(line.startsWith("#")){
				line = scanner.nextLine();
			}
			return parser.parseObject(line);
		}
		return null;
	}
	
	public void setParser(CSVParser<T> parser){
		this.parser = parser;
	}
}
