package br.com.stefanini.roversquad;

import java.util.List;

import br.com.stefanini.roversquad.commons.AppConstants;
import br.com.stefanini.roversquad.exceptions.DirectionException;
import br.com.stefanini.roversquad.exceptions.RegisterException;
import br.com.stefanini.roversquad.exploration.Exploration;
import br.com.stefanini.roversquad.file.OutputFile;

/**
 * The main class of the project
 * @author luizhenriquesantana
 *
 */
public class Main {

	/**
	 * The main method of the Main class, it runs the project.
	 * @param args
	 */
	public static void main (String[] args){
				
		
		try {
			StringBuilder inputPath = new StringBuilder();
			inputPath.append(AppConstants.DIRECTORY);
			inputPath.append(AppConstants.DEFAULT_SEPARATOR);
			inputPath.append(AppConstants.DEFAULT_INPUT_FILE);

			List<String> coordinates = Exploration.coordinates(inputPath.toString());
			OutputFile.writeOutput(coordinates);
			System.out.println("The process is ended. The file location is: files/output.txt");
			
		} catch (RegisterException | DirectionException e) {
			e.printStackTrace();
		}

	}
}
