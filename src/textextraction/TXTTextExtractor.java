package textextraction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class TXTTextExtractor implements ITextExtractor {

	private BufferedReader reader;

	@Override
	public ArrayList<String> getText(File file) {
		
		ArrayList<String> lines = new ArrayList<>();
		this.addLines(file, lines);
		
		return lines;
	}
	
	private void addLines(File file, ArrayList<String> lines) {
		
		String line;
		
		try {
			
			this.reader = new BufferedReader(new FileReader(file));
			
			while((line = this.reader.readLine()) != null) 
				lines.add(line);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
