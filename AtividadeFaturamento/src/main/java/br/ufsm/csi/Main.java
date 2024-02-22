package br.ufsm.csi;

public class Main {
    public static void main(String[] args) {
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;
        double total = sp + rj + mg + es + outros;

        System.out.printf("Total: R$ %.2f%n", total);

        double psp = (sp / total) * 100;
        double prj = (rj / total) * 100;
        double pmg = (mg / total) * 100;
        double pes = (es / total) * 100;
        double poutros = (outros / total) * 100;

        System.out.printf("SP: %.2f%%%n", psp);
        System.out.printf("RJ: %.2f%%%n", prj);
        System.out.printf("MG: %.2f%%%n", pmg);
        System.out.printf("ES: %.2f%%%n", pes);
        System.out.printf("Outros: %.2f%%%n", poutros);
    }
}