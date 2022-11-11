//Wrapper class for determinant function
public class Determinant {
    public static Fraction det(Fraction[][] mat){
        Fraction returnVal = new Fraction(0,1);
        int rows = mat[0].length;
        int cols = mat.length;
        if(rows != cols){//check if square matrix
            return null;
        }
        if(rows == 2){//2x2 matrix (easy determinant)
            Fraction bigFrac1 = new Fraction(0,1);
            Fraction bigFrac2 = new Fraction(0,1);
            bigFrac1 = mat[0][0].multiply(mat[1][1]);
            bigFrac2 = mat[1][0].multiply(mat[0][1]);
            bigFrac2 = bigFrac2.reciprocal();
            return (bigFrac1.add(bigFrac2));
        }
        /**
         * ALGORITHM:
         * make sure that the matrix passed is square (return null if not)
         * get cofactor matrix for each col
         * call determinant of each cofactor matrix and add (have option just for 2x2 matrices)
         * add all cofactor determinats
         * return sum
         */
        return returnVal;
    }

    public static Fraction[][] cofactor(Fraction[][] mat, int indexCol, int indexRow){
        Fraction[][] result = new Fraction[mat.length - 1][mat.length -1];

        //IMPLEMENT COFACTOR ALGORITHM

        return result;
    }
}
