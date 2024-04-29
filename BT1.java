import java.util.*;

public class BT1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            int H = sc.nextInt();
            if (H == 0) break;
            
            int numNodes = (1 << H) - 1;
            
            int[] values = new int[numNodes];
            for (int i = 0; i < numNodes; i++) {
                values[i] = sc.nextInt();
            }
            
            long[] P = new long[numNodes];
            for (int i = numNodes - 1; i >= 0; i--) {
                int leftChild = 2 * i + 1;
                int rightChild = 2 * i + 2;
                if (leftChild >= numNodes) {
                    P[i] = values[i];
                } else {
                    long maxChild = Math.max(values[i] * P[leftChild], values[i] * P[rightChild]);
                    P[i] = maxChild % 1_000_000_007;
                }
            }
            
            System.out.println(P[0]);
        }
        
        sc.close();
    }
}
