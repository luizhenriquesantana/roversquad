package br.com.stefanini.roversquad.exploration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.stefanini.roversquad.enums.Command;
import br.com.stefanini.roversquad.exceptions.CommandParseException;
import br.com.stefanini.roversquad.exceptions.DirectionException;
import br.com.stefanini.roversquad.exceptions.RegisterException;
import br.com.stefanini.roversquad.model.Plateau;
import br.com.stefanini.roversquad.model.Rover;

public class Exploration {

	private static BufferedReader bufferedReader;

	public static List<String> coordinates(String filePath) throws RegisterException, DirectionException {
		List<String> coordinates = new ArrayList<String>();

		try {
			FileReader fr = new FileReader(filePath);
			bufferedReader = new BufferedReader(fr);

			Integer line = 0;

			String strLine = bufferedReader.readLine();

			Plateau pl = null;
			Rover r = null;
			Command[] c = null;

			// Read File line by line
			while (strLine != null) {

				if (strLine != null) { // the last readLine returns null

					if (line == 0) {
						pl = new Plateau(strLine);

					} else {
						if (0 != line % 2) {

							if (!strLine.contains("N") && !strLine.contains("S") && !strLine.contains("E")
									&& !strLine.contains("W")) {
								throw new CommandParseException("The Rover Line does not contain direction", 0);
							}

							// rover
							r = new Rover(strLine);
							pl.register(r);
						} else {
							// command
							c = Command.parse(strLine);
							if (r != null) {
								for (Command cmd : c) {
									r.control(cmd);
								}
								coordinates.add(r.getCoordinate());
							}
						}
					}
				}

				strLine = bufferedReader.readLine();
				line++;
			}

			bufferedReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CommandParseException e) {
			e.printStackTrace();
		}

		return coordinates;
	}
}
