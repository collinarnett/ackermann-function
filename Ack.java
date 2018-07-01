import java.util.*;
public class Ack {

int value = 0;
int called = 0;
List<List<Integer> > array = new ArrayList<List<Integer> >();

public Ack(){
        function(0, 0);
}

public Ack(int m, int n){
        this.value += function(m, n);
        System.out.println(array);
        System.out.println("Ackfunction was called " + called + " times");
}

@Override
public String toString() {
        return "" +this.value;
}

public int function(int m, int n){
        this.called++;
        if (m == 0) {
                addToList(m, n);
//                System.out.println("if statement m = " + m + ", x = " + n);
                return n+1;
        }
        else {
                if (n == 0) {
//                        System.out.println("else if statement m = " + m  + ", x = " + n);
                        if(!array.isEmpty()) {
                                return array.get(m-1).get(0);
                        }
                        return function(m-1, 1);
                }
                else{
//                        System.out.println("deep else if statement m = " + m  + ", x = " + n);
                        if (isNandMintheArray(m, n)) {
//                                System.out.println("triggered");
                                System.out.println(array.get(m-1).get(array.get(m).get(n-1)));
                                return array.get(m-1).get(array.get(m).get(n-1));
                        }
                        return function(m-1, function(m, n-1));
                }
        }

}

public void addToList(int m, int n){
        for(int i = 0; i <= m; i++) {
                this.array.add(new ArrayList<Integer>());
                for(int j = 0; j <= n; j++) {
                        this.array.get(this.array.size() -1).add(n+1);
                }
        }
}

public boolean isNandMintheArray(int m, int n){
        if (!array.isEmpty() && array.size() > m && array.get(m).size() > n && array.get(m).size() > array.get(m).get(n-1)) {
                return true;
        }
        else{
                return false;
        }
}

public static void main(String[] args){
        Ack test = new Ack(2, 2);
        System.out.println("");
        System.out.println("test's function is " + test);
}
}
