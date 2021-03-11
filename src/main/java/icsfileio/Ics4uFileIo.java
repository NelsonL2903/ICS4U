package icsfileio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ics4uFileIo {

	public static void main(String[] args) {
		Ics4uFileIo fileio = new Ics4uFileIo();
		fileio.initialize();
		fileio.write();
		fileio.read();
		fileio.print();
	}

	private List<String> strings = new ArrayList<String>();
	
	public void initialize() {
		strings.add("Hello!");
	}
	
	public void write() {
		Path path = Paths.get("myfile.txt");
	try {
	Files.write(path, strings);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void read() {
		Path path = Paths.get("myfile.txt");
	try {
	strings = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void print() {
		
	}
	
}
