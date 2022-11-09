public class Fraction {
    int numerator;
    int denominator;

    public Fraction(int n, int d){
        this.numerator = n;
        this.denominator = d;
    }

    public Fraction multiply(Fraction frac){
        Fraction result = new Fraction(this.numerator, this.denominator);
        result.numerator*=frac.numerator;
        result.denominator*=frac.denominator;
        return result;
    }

    public Fraction add(Fraction frac){
        Fraction result = new Fraction(this.numerator, this.denominator);
        if(frac.denominator == this.denominator){
            result.numerator+=frac.numerator;
            result.denominator+=frac.denominator;
        }else{
            result.denominator*=frac.denominator;
            result.numerator = (this.numerator * frac.denominator) + (frac.numerator * this.denominator);
        }
        return result;
    }

    public Fraction reciprocal(){
        Fraction result = new Fraction(0,0);
        result.numerator = this.denominator;
        result.denominator = this.numerator;
        return result;
    }

    public Fraction negative(){
        Fraction result = new Fraction(this.numerator, this.denominator);
        result.numerator*=-1;
        return result;
    }

    public Fraction add(Fraction f1, Fraction f2){
        Fraction result = new Fraction(0,0);
        result.numerator = f1.numerator + f2.numerator;
        result.denominator = f1.denominator + f2.denominator;
        return result;
    }

    public static Integer toInt(Fraction frac){
        if(frac.numerator == frac.denominator){
            return 1;
        }else if(frac.numerator == 0){
            return 0;
        }
        return null;
    }

    public String toString(){
        String str = "";
        str += this.numerator;
        str+= "/";
        str+= this.denominator;
        return str;
    }
}