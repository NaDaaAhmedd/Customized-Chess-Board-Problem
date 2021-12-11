import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the solve function below.
    static String solve(List<List<Integer>> board) {
        int Colnum = 0, ind, N = board.size(), compared;
        for (List<Integer> curCol : board){
            for (ind = 0; ind < N; ind++){
                compared = curCol.get(ind);
                if ((Colnum < N - 1 && board.get(Colnum + 1).get(ind) == compared) ||
                        (ind < N - 1 && curCol.get(ind + 1) == compared) )
                    return "No";
            }
            Colnum++;
        }
        return "Yes";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> board = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        board.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = solve(board);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
