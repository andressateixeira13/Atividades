package br.ufsm.csi;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira um numero: ");
        int numero = scanner.nextInt();
        List<Integer> fibonacciSequencia = calculaFibonacciSequencia(numero);
        if (fibonacciSequencia.contains(numero)) {
            System.out.println("O numero " + numero + " esta na sequencia Fibonacci.");
            System.out.println("A sequencia e "+ fibonacciSequencia);
        } else {
            System.out.println("O numero " + numero + " nao esta na sequencia Fibonacci.");
        }
    }

    private static List<Integer> calculaFibonacciSequencia(int number) {
        List<Integer> sequencia = new ArrayList<>();
        sequencia.add(0);
        sequencia.add(1);
        while (sequencia.get(sequencia.size() - 1) + sequencia.get(sequencia.size() - 2) <= number) {
            sequencia.add(sequencia.get(sequencia.size() - 1) + sequencia.get(sequencia.size() - 2));
        }
        return sequencia;
    }
}