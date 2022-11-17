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
        if (this.numeros[side][0] != p.numeros[(side + 2) % 4][2])
            return false;
        if (this.numeros[side][1] != p.numeros[(side + 2) % 4][1])
            return false;
        if (this.numeros[side][2] != p.numeros[(side + 2) % 4][0])
            return false;
        return true;
    }
}