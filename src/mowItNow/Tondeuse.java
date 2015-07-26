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
			 * pour coordonnées (x, y+1) -Si la position après mouvement est en
			 * dehors de la pelouse, la tondeuse ne bouge pas, conserve son
			 * orientation et traite la commande suivante -Si la position après
			 * mouvement est celle d'une autre tondeuse à l'arret après
			 * exécution d'instructions la tondeuse ne bouge pas, conserve son
			 * orientation et traite la commande suivante - les instructions à
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
			// Nord + change à Droite = Est
			else if (pos.getDir().equals("N") && s.equals("D"))
				pos.setDir("E");
			// Nord + change à Gauche = West
			else if (pos.getDir().equals("N") && s.equals("G"))
				pos.setDir("W");

			/* initialement à l'Est */
			// Est + change à Droite = Sud
			else if (pos.getDir().equals("E") && s.equals("D"))
				pos.setDir("S");
			// Est + change à Gauche = Nord
			else if (pos.getDir().equals("E") && s.equals("G"))
				pos.setDir("N");

			/* initialement au Sud */
			// Sud + change à Droite = West
			else if (pos.getDir().equals("S") && s.equals("D"))
				pos.setDir("W");
			// Sud + change à Gauche = Est
			else if (pos.getDir().equals("S") && s.equals("G"))
				pos.setDir("E");

			/* initialement à l'West */

			// West + change à Droite = Nord
			else if (pos.getDir().equals("W") && s.equals("D"))
				pos.setDir("N");
			// West + change à Gauche = Sud
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
