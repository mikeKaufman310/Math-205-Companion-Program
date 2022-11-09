//Wrapper class for eliminate method
public class GaussianElimination {
    public static Fraction[][] eliminate(Fraction[][] ogMatrix){
        Fraction[][] result = new Fraction[ogMatrix.length][ogMatrix[0].length];
        for(int i = 0; i < ogMatrix.length; i++){//copy matrix
            for(int j = 0; j < ogMatrix[i].length; j++){
                result[i][j] = ogMatrix[i][j];
            }
        }
        int rows = ogMatrix[0].length;
        int cols = ogMatrix.length;
        int numLeadingOnes = 0;
        int currentCol = 0;
        int[] rowsWithOne = new int[rows];//use to keep track of what i cant use for killer rows anymore
        for(int i = 0; i < rowsWithOne.length; i++){
            rowsWithOne[i] = 0;//0 means not been used as killer algo, 1 has
        }
        while(numLeadingOnes < rows){
            

            /**
             * Algorithm:
             * Check if row has leading 0
             * Find row that has leading non-zero
             * Turn leading non-zero into one (need to check if fraction)
             * Kill all other non-zero rows with the leading one (need to check if fraction)
             * advance to next column
             * increment number of leading ones
             * 
             * result[cols][rows]
             */
            int killerRowNumber = -1;
            for(int i = 0; i < rows;i++){//find a leading one
                if(result[currentCol][i].numerator != 0 && rowsWithOne[i] != 1){
                    killerRowNumber = i;
                    rowsWithOne[killerRowNumber] = 1;
                    break;
                }
            }

            if(killerRowNumber == -1){//all zeros in first column
                continue;
            }

            //getting leading zero in killer row
            for(int i = 0; i < cols; i++){
                result[i][killerRowNumber].multiply(result[0][killerRowNumber].reciprocal());
            }

            //kill all the other rows
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    if(i != killerRowNumber){
                        Fraction factorOfMultiplication = result[0][i];
                        result[j][i] = result[j][i].add(result[j][killerRowNumber].multiply(factorOfMultiplication).negative(), result[j][i]);
                    }
                }
            }

            //get your leading ones
            for(int i = 0; i < cols; i++){
                for(int j = 0; j < rows; j++){
                    if(result[i][j].numerator != 0){
                        result[i][j] = result[i][j].multiply(result[i][j].reciprocal());
                        break;
                    }
                }
            }

            numLeadingOnes++;
            currentCol++;
        }
        return result;
    }

}
