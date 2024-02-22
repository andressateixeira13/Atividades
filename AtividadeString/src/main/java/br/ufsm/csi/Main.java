package br.ufsm.csi;
import java.util.Scanner;
public class Main {
    public static String reverso(String string) {
        StringBuilder sb = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            char c = string.charAt(i);
            if (Character.isHighSurrogate(c)) {
                sb.append(string.charAt(i - 1));
                sb.append(c);
                i--;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com uma string: ");
        String string = scanner.nextLine();
        System.out.println(reverso(string));
    }
}