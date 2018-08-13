/**
 * 
 */
package com.ankit.trial.conversion;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @author ankit agarwal
 *
 */
public class Convert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// take the user input for file Path
			String filePath = "C:/Users/anagarw3/Downloads/splitpdf/The Hermitage";
			
			// Loading an existing PDF document
			File file = new File(filePath + ".pdf");
			PDDocument document = PDDocument.load(file);

			// Instantiating Splitter class from apache library
			Splitter splitter = new Splitter();

			// split the pages of a PDF document loaded
			List<PDDocument> Pages = splitter.split(document);

			Iterator<PDDocument> iterator = Pages.listIterator();

			// Save each page as an individual PDF doc and name it incrementally
			int i = 1;
			while (iterator.hasNext()) {
				PDDocument pd = iterator.next();
				pd.save(filePath + i++ + ".pdf");
			}
			System.out.println("Multiple PDF’s created");
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
