package br.com.stefanini.roversquad.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import br.com.stefanini.roversquad.commons.AppConstants;

/**
 * 
 * @author luizhenriquesantana
 *
 */
public class OutputFile {

	/**
	 * Writes an output file
	 * 
	 * @param wordsAvg
	 */
	public static void writeOutput(List<String> coordinates) {

		StringBuilder outputPath = new StringBuilder();
		outputPath.append(AppConstants.DIRECTORY);
		outputPath.append(AppConstants.DEFAULT_SEPARATOR);
		outputPath.append(AppConstants.DEFAULT_OUTPUT_FILE);

		try (PrintWriter writer = new PrintWriter(outputPath.toString(), AppConstants.DEFAUL_ENCODING)) {
			for (String str : coordinates) {
				writer.println(str);
			}
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
