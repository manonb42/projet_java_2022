public class Piece {
    private int numeros[][] = new int[4][3];

    Piece(int numeros[][]) {
        this.numeros = numeros;
    }

    public int[][] getNumeros() {
        return this.numeros;
    }

    public void setNumeros(int cote, int placement, int valeur) {
        this.numeros[cote][placement] = valeur;
    }

    public void tourner(int nbTours) {
        if (nbTours > 0) {
            for (int i = 0; i < nbTours; i++) {
                int[] tmp = this.numeros[3];
                this.numeros[3] = this.numeros[2];
                this.numeros[2] = this.numeros[1];
                this.numeros[1] = this.numeros[0];
                this.numeros[0] = tmp;
            }
        } else {
            for (int i = 0; i < -nbTours; i++) {
                int[] tmp = this.numeros[0];
                this.numeros[0] = this.numeros[1];
                this.numeros[1] = this.numeros[2];
                this.numeros[2] = this.numeros[3];
                this.numeros[3] = tmp;
            }
        }
    }

    public boolean sidesMatch(Piece p, int side) {
        for (int i = 0; i < numeros[0].length; i++) {
            if (this.numeros[side][i] != p.numeros[(side + 2) % 4][i])
                return false;
        }
        return true;
    }

}