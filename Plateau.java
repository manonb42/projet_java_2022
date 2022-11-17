public class Plateau {
    private Grille g;

    Plateau(Grille g) {
        this.g = g;
    }

    public Grille getG() {
        return g;
    }

    public void setG(Grille g) {
        this.g = g;
    }

    public boolean placer(Piece p, Coordonnees coordonnee) {
        if (validPlacement(p, coordonnee)) {
            g.setPiece(coordonnee.getX(), coordonnee.getY(), p);
            return true;
        }
        return false;
    }

    // a changer
    private boolean validPlacement(Piece p, Coordonnees coordonnee) {
        boolean cotevide = true;
        boolean plateauvide = true;
        int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int delta = 0; delta < deltas.length; delta++) {
            int coordX = coordonnee.getX() + deltas[delta][0];
            int coordY = coordonnee.getY() + deltas[delta][1];

            if (g.getPiece(coordX, coordY) != null) {
                cotevide = false;
                if (!(p.sidesMatch(g.getPiece(coordX, coordY), delta)))
                    return false;
            }
        }
        for (int i = 0; i < g.getListPieces().size(); i++) {
            for (int j = 0; j < g.getListPieces().get(i).size(); j++) {
                if (g.getListPieces().get(i).get(j) != null) {
                    plateauvide = false;
                }
            }
        }
        if (plateauvide)
            return true;
        if (cotevide)
            return false;
        return true;
    }

}
