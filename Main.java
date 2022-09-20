public class Main {
    int maxim = 0;
    int minim = 0;
    int answer_digit = 0;

    public static void main(String args[]) {
        // 1 Часть
        int[] a = new int[19];
        for (int i = 0; i < 19; i++) {
            a[i] = 23 - i;
        }
        // 2 Часть
        float[] x = new float[17];
        for (int i = 0; i < 17; i++) {
            x[i] = (float) Math.random() * 15 - 6.0f;
        }
        // 3 Часть
        Main main = new Main();
        double[][] z = new double[10][17];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 17; j++) {
                switch (a[i]) {
                    case 19:
                        z[i][j] = Math.pow(2 * Math.cos(x[j]) / (0.5 - Math.pow(x[j] / (x[j] - 3), 2)),
                                Math.pow((0.5 + Math.cbrt(x[j])) / Math.pow(x[j], 4 - x[j]), Math.tan(x[j])));
                        main.MiniMax(z[i][j]);
                        break;
                    case 11, 13, 17, 21, 23:
                        z[i][j] = Math.tan(Math.cos(Math.tan(x[j])));
                        main.MiniMax(z[i][j]);
                        break;
                    default:
                        z[i][j] = Math.atan(Math.cos(Math.pow((Math.pow(2 * Math.log(Math.abs(x[j])), 2) - 1)
                                / Math.tan(x[j]), 3)));
                }
            }

        }
        //  Вывод
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 17; j++) {
                String format = "%" + (main.answer_digit + 2) + ".3f";
                System.out.printf(format, z[i][j]);
            }
            System.out.println();
        }
    }

    public void MiniMax(double n) {
        if (n > 0) {
            if (n > maxim) {
                maxim = String.format("%.3f", n).length();
            }
        } else if (n < 0) {
            if (n < minim) {
                minim = String.format("%.3f", n).length();
            }
        }
        int current_max = Math.max(maxim, minim);
        answer_digit = Math.max(answer_digit, current_max);
    }
}