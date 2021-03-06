package textextraction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.poi.hwpf.extractor.Word6Extractor;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class DOCTextExtractor implements TextExtractor{
	
	@Override
	public ArrayList<String> getText(File file) {
		
		return new ArrayList<String>(Arrays.asList(this.parse(file).split("\n")));
		
	}
	
	public String parse(File file) {
		String text = this.getWord6or95(file);
	    
	    if (text == "")
	    	text = this.getWord1997or2003(file);
	    
	    return text;
	}
	
	private String getWord6or95(File file) {
		try {
	    	
			InputStream stream = new FileInputStream(file);
			Word6Extractor extractor = new Word6Extractor(stream);
			
			String text = extractor.getText();
			
			extractor.close();
			
			return text;
			
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	private String getWord1997or2003(File file) {
		try {
	    	
			InputStream stream = new FileInputStream(file);
			WordExtractor extractor = new WordExtractor(stream);
			
			String text = extractor.getText();
			
			extractor.close();
			
			return text;
			
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		} 
	}

}
