public class Test {
    public static void main(String[] args){
        //Test Matrix
        Fraction[][] mat = new Fraction[2][2];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                mat[i][j] = new Fraction(0, 1);
            }
        }
        //Fraction frac = new Fraction(3, 1);
        //Fraction frac2 = new Fraction(4, 1);
        //mat[1][0] = frac;
        //mat[0][1] = frac2;
        //End Test Matrix Creation

        DisplayRowReducedMatrix.Display(mat);

        boolean RR = false;

        for(int i = 0; i < args.length; i++){
            if(args[i].equals("RowReduce")){
                RR = true;
                break;
            }
        }

        if(RR){
            mat = GaussianElimination.eliminate(mat);
            DisplayRowReducedMatrix.Display(mat);
        }
    }
}
