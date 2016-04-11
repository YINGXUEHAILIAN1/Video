import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Uther on 2016/4/10.
 */
public class DP {

    static final int SIZE = 1000;
    static List<Integer>[] childs = new ArrayList[SIZE];


    static int[][] dp = new int[SIZE][2];

    static final int FATHER = 0;
    static final int NO_FATHER = 1;

    static int Dp(int k,int status){
        if (dp[k][status] != -1){
            return dp[k][status];
        }

        if (childs[k].size() == 0){
            if (status == FATHER){
                dp[k][status] = 1;
            }else{
                dp[k][status] = 2;
            }
            return dp[k][status];
        }

        dp[k][status] = 0;

        if (status == NO_FATHER){
            int ans = 1;
            for (int child : childs[k]){
                ans *= Dp(child,FATHER);
            }
            dp[k][status] += ans;
        }

        int ans = 1;
        for (int child : childs[k]){
            ans *= Dp(child,NO_FATHER);
        }
        dp[k][status] += ans;


        return dp[k][status];
    }

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        for (int i=0;i<n;i++)
            childs[i] = new ArrayList<>();
        for (int i=1;i<n;i++){
            int father = cin.nextInt();
            childs[father-1].add(i);
        }
        for (int i=0;i<n;i++)
            for (int status=0;status<2;status++)
                dp[i][status] = -1;
        System.out.println(Dp(0,NO_FATHER)-1);
    }

}
