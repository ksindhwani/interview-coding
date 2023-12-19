package main.java.com.example.securiti.iterview;

public class SprialMatrix {
    int displayCount = 0;
    public void displaySpiralMatrix(int[][] matrix, int r, int c) 
    {
        int i = 0;
        while(displayCount < r * c) {
            // Print row from top
            printRowFromTop(i, matrix, r,c);
            i++;



            // Print column from right

            

            //Print row from bottom

            // Print column from left
        }

    }
}
