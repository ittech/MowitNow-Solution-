package mowItNow;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import exceptions.InvalidArgumentException;

public class Main {

	public static void main(String[] args) throws IOException, InvalidArgumentException {

		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader("TestFiles\\InputFile.txt"));

			String sCurrentLine = br.readLine();
			if (sCurrentLine == null)
				throw new InvalidArgumentException(" fichier vide");

			/*
			 * lire les coordonnées du coin supérieur droite de la grille, le
			 * coin sup gauche étant (0,0)
			 */
			String[] coords = sCurrentLine.split(" ");
			if (coords.length != 2)
				throw new InvalidArgumentException(" nombre d'arguments invalide");
			Grille g = new Grille(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));

			/* parcourir l'ensemble des tondeuses */
			while ((sCurrentLine = br.readLine()) != null) {

				/* récupérer la position initiale de la tondeuse */
				coords = sCurrentLine.split(" ");
				if (coords.length != 3)
					throw new InvalidArgumentException(" nombre d'arguments invalide");
				Tondeuse t = new Tondeuse(
						new Position(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]), coords[2]));

				/* recupérer les instructions */
				sCurrentLine = br.readLine();
				String[] instructions = sCurrentLine.split("");
				/* invoquer la tondeuse pour réaliser les instructions */
				t.move(instructions, g);

				/* la tondeuse communique communique sa dernière position */

				System.out.println(t.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			br.close();
		}

	}

}
