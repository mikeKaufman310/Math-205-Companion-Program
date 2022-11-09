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
        int numAllZeroRows = 0;
        for(int i = 0; i < rowsWithOne.length; i++){
            rowsWithOne[i] = 0;//0 means not been used as killer algo, 1 has
        }
        while(numLeadingOnes < rows){
            //check for number of non zero rows
            for(int i = 0; i < rows; i++){
                boolean allZero = true;
                for(int j = 0; j < cols; j++){
                    if(result[j][i].numerator != 0){
                        allZero = false;
                    }
                }
                if(allZero){
                    numAllZeroRows++;
                }
            }

            //check if done
            if(numAllZeroRows + numLeadingOnes == rows){
                break;
            }

        
            int killerRowNumber = -1;
            for(int i = 0; i < rows;i++){//find a leading one
                if(result[currentCol][i].numerator != 0 && rowsWithOne[i] != 1){
                    killerRowNumber = i;
                    rowsWithOne[killerRowNumber] = 1;
                    break;
                }
            }

            if(killerRowNumber == -1){//all zeros in current column
                continue;
            }

            //getting leading one in killer row
            Fraction factorForLeadOne = result[currentCol][killerRowNumber].reciprocal();
            for(int i = 0; i < cols; i++){
                result[i][killerRowNumber] = result[i][killerRowNumber].multiply(factorForLeadOne);
            }

            System.out.println("Getting leading one in row:");
            DisplayRowReducedMatrix.Display(result);


            //kill all the other rows
            for(int i = 0; i < rows; i++){
                if(i != killerRowNumber){
                    Fraction factor = result[currentCol][i];
                    for(int j = currentCol; j < cols; j++){
                        result[j][i] = result[j][i].add((factor.multiply(result[j][killerRowNumber])).negative());
                    }
                }
            }

            System.out.println("Kill other rows of in the current column");
            DisplayRowReducedMatrix.Display(result);
            

            numLeadingOnes++;
            currentCol++;
        }

        result = GaussianElimination.arrange(result);

        return result;
    }

    public static Fraction[][] arrange(Fraction[][] mat){
        int cols = mat.length;
        int rows = mat[0].length;
        int rowsSortNumber = 0;
        for(int i = 0; i < cols; i++){//iterate columns
            boolean almostBottom = false;
            for(int j = rowsSortNumber; j < rows; j++){
                if(j+1 == rows){
                    almostBottom = true;
                }
                if(mat[i][j].numerator == mat[i][j].denominator){
                    Fraction[] temp = new Fraction[cols];
                    for(int k = 0; k < cols; k++){
                        temp[k] = mat[k][j];//temp row with leading one
                    }
                    if(!almostBottom){
                        for(int k = 0; k < cols;k++){
                            mat[k][j] = mat[k][j+1];//swap part 1
                        }
                        for(int k = 0; k < cols;k++){
                            mat[k][j+1] = temp[k];//swap part 2
                        }
                        rowsSortNumber++;
                        break;
                    }else{
                        for(int k = 0; k < cols;k++){
                            mat[k][j] = mat[k][j-1];//swap part 1
                        }
                        for(int k = 0; k < cols;k++){
                            mat[k][j-1] = temp[k];//swap part 2
                        }
                        rowsSortNumber++;
                        break;
                    }
                }
            }
        }
        return mat;
    }

}
