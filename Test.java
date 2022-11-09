public class Test {
    public static void main(String[] args){
        //Test Matrix
        Fraction[][] mat = new Fraction[2][2];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                mat[i][j] = new Fraction(1, 1);
            }
        }
        //End Test Matrix Creation

        mat = GaussianElimination.eliminate(mat);
        DisplayRowReducedMatrix.Display(mat);

    }
}
