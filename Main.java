import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 8;
    public static int[][] colors = new int[SIZE][SIZE];
    public static int[][] rotatedColors = new int[SIZE][SIZE];

    public static void main(String[] args) {
        System.out.print("Введите угол поворота:");
        Scanner sc = new Scanner(System.in);
        int rotated = sc.nextInt();
        setMatrix(colors);
        rotatedMatrix(colors, rotatedColors, rotated);
        showMatrix(colors, rotatedColors);

    }

    public static void setMatrix(int[][] colors) {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
    }

    public static void rotatedMatrix(int[][] colors, int[][] rotatedColors, int rotated) {
        if (rotated != 90 && rotated != 180 && rotated != 270) {
            System.out.println("Угол поворота должен быть 90, 180 или 270 градусов.");
            System.exit(0);
        }
        if (rotated == 90) {
            for (int i = 0; i < colors.length; i++) {
                for (int j = 0; j < colors.length; j++) {
                    rotatedColors[i][colors.length - 1 - j] = colors[j][i];
                }
            }

        } else if (rotated == 180) {
            for (int i = 0; i < colors.length; i++) {
                for (int j = 0; j < colors.length; j++) {
                    rotatedColors[colors.length - 1 - j][colors.length - 1 - i] = colors[j][i];
                }
            }

        } else if (rotated == 270) {

            for (int i = 0; i < colors.length; i++) {
                for (int j = 0; j < colors.length; j++) {
                    rotatedColors[colors.length - 1 - j][i] = colors[j][i];
                }
            }
        }

    }


    public static void showMatrix(int[][] colors, int[][] rotatedColors) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", rotatedColors[i][j]);
            }
            System.out.println();
        }
    }
}
