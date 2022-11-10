public class Plateau {
    // changer array en arraylist
    private Piece[][] pieces;

    Plateau(Piece[][] pieces) {
        this.pieces = pieces;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }

    public boolean placer(Piece p, Coordonnees coordonnee) {
        if (validPlacement(p, coordonnee)) {
            pieces[coordonnee.getY()][coordonnee.getX()] = p;
            return true;
        }
        return false;
    }

    private boolean validPlacement(Piece p, Coordonnees coordonnee) {
        int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int delta = 0; delta < deltas.length; delta++) {
            int coordX = coordonnee.getX() + deltas[delta][0];
            int coordY = coordonnee.getY() + deltas[delta][1];
            if (coordX < 0 || coordY < 0)
                return false; // non
            if (pieces[coordX][coordY] != null) {
                if (!p.sidesMatch(pieces[coordX][coordY], delta))
                    return false;
            }
        }
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (pieces[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }

}
