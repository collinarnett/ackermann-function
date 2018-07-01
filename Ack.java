import java.util.*;
public class Ack {

int value = 0;
int called = 0;
int array[][] = new int[10000][10000];
public Ack(){
        function(0, 0);
}

public Ack(int m, int n){
        this.value += function(m, n);
//        System.out.println(array);
        System.out.println("Ackfunction was called " + called + " times");
}

@Override
public String toString() {
        return "" +this.value;
}

public int function(int m, int n){
        this.called++;

        if (isNandMintheArray(m, n)) {
      //          System.out.println("triggered");
  //              System.out.println(this.array[m][n]);
                return this.array[m][n];
        }
        else{
                if (m == 0) {
//                        System.out.println("if statement m = " + m + ", x = " + n);
                        this.array[m][n] = n+1;
                        return n+1;
                }
                else {
                        if (n == 0) {
  //                              System.out.println("else if statement m = " + m  + ", x = " + n);
                                return function(m-1, 1);
                        }
                        else{
    //                            System.out.println("deep else if statement m = " + m  + ", x = " + n);
                                return function(m-1, function(m, n-1));
                        }
                }
        }
}




private boolean isNandMintheArray(int m, int n){
        if (this.array[m][n] != 0) {
                return true;
        }
        else{
                return false;
        }
}

public static void main(String[] args){
        Ack test = new Ack(3, 7);
        System.out.println("");
        System.out.println("test's function is " + test);
}
}
