//Wrapper class for display method
public class DisplayRowReducedMatrix {
    public static void Display(Fraction[][] mat){
        for(int i = 0; i < mat.length; i++){//rows
            for(int j = 0; j < mat[0].length; j++){//cols
                if(Fraction.toInt(mat[j][i]) != null){
                    System.out.print(Fraction.toInt(mat[j][i]) + " ");
                }
            }
            System.out.println();
        }
    }
}
