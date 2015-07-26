package mowItNow;
import exceptions.InvalidArgumentException;

public class Tondeuse {

	Position pos;

	public Tondeuse(Position p) {

		pos = p;

	}

	public void move(String[] instructions, Grille g) throws InvalidArgumentException {

		for (String s : instructions) {

			/*
			 * le mouvement de la tondeuse doit respecter les conditions
			 * suivantes : -La case directement au Nord de la position (x, y) a
			 * pour coordonn�es (x, y+1) -Si la position apr�s mouvement est en
			 * dehors de la pelouse, la tondeuse ne bouge pas, conserve son
			 * orientation et traite la commande suivante -Si la position apr�s
			 * mouvement est celle d'une autre tondeuse � l'arret apr�s
			 * ex�cution d'instructions la tondeuse ne bouge pas, conserve son
			 * orientation et traite la commande suivante - les instructions �
			 * traiter sont A,D et G
			 */
			if (!(s.equals("A") || s.equals("D") || s.equals("G")))
				throw new InvalidArgumentException(
						" instruction invalide," + " les instructions possibles sont A, D et G");
			else if (s.equals("A") && pos.getDir().equals("N") && (pos.getY() < g.getUpperRightPosition().getY())
					&& g.isEmpty(pos.getX(), pos.getY() + 1))
				pos.setY(this.pos.getY() + 1);
			else if (s.equals("A") && pos.getDir().equals("S") && (pos.getY() > 0))
				pos.setY(pos.getY() - 1);
			else if (s.equals("A") && pos.getDir().equals("E") && (pos.getX() < g.getUpperRightPosition().getX()))
				pos.setX(pos.getX() + 1);
			else if (s.equals("A") && pos.getDir().equals("W") && (pos.getX() > 0))
				pos.setX(pos.getX() - 1);

			/* initialement au Nord */
			// Nord + change � Droite = Est
			else if (pos.getDir().equals("N") && s.equals("D"))
				pos.setDir("E");
			// Nord + change � Gauche = West
			else if (pos.getDir().equals("N") && s.equals("G"))
				pos.setDir("W");

			/* initialement � l'Est */
			// Est + change � Droite = Sud
			else if (pos.getDir().equals("E") && s.equals("D"))
				pos.setDir("S");
			// Est + change � Gauche = Nord
			else if (pos.getDir().equals("E") && s.equals("G"))
				pos.setDir("N");

			/* initialement au Sud */
			// Sud + change � Droite = West
			else if (pos.getDir().equals("S") && s.equals("D"))
				pos.setDir("W");
			// Sud + change � Gauche = Est
			else if (pos.getDir().equals("S") && s.equals("G"))
				pos.setDir("E");

			/* initialement � l'West */

			// West + change � Droite = Nord
			else if (pos.getDir().equals("W") && s.equals("D"))
				pos.setDir("N");
			// West + change � Gauche = Sud
			else if (pos.getDir().equals("W") && s.equals("G"))
				pos.setDir("S");

		}

		g.fill(pos.getX(), pos.getY());

	}

	@Override
	public String toString() {

		return pos.getX() + " " + pos.getY() + " " + pos.getDir();
	}

}
