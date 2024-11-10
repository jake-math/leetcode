package solutions.grind75.week6;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        
        List<Integer> sol = new ArrayList<>();        
        int count = 0;

        int topVisited = 0;
        int bottomVisited = n;
        int leftVisited = -1;
        int rightVisited = m;

        int i = 0;
        int j = 0;

        String direction = "right";

        while (count < (m * n)) {
            switch (direction) {
                case "right":
                    if (i < rightVisited) {
                        System.out.println("good");
                        sol.add(matrix[j][i]);
                        i++;
                        count++;
                    } else {
                        rightVisited = i - 1;
                        i--;
                        j++;
                        direction = "down";
                    }
                    break;

                case "down":
                    if (j < bottomVisited) {
                        sol.add(matrix[j][i]);
                        j++;
                        count++;
                    } else {
                        bottomVisited = j - 1;
                        j--;
                        i--;
                        direction = "left";
                    }
                    break;

                case "left":
                    if (i > leftVisited) {
                        sol.add(matrix[j][i]);
                        i--;
                        count++;
                    } else {
                        leftVisited = i + 1;
                        i++;
                        j--;
                        direction = "up";                   
                    }                
                    break;

                case "up":
                    if (j > topVisited) {
                        sol.add(matrix[j][i]);
                        j--;
                        count++;
                    } else {
                        topVisited = j + 1;
                        j++;
                        i++;
                        direction = "right";                    
                    }
                    break;
            }
        }

        return sol;  
    }
}
