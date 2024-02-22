package br.ufsm.csi;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Map<String, Object>> faturamentoDiario = objectMapper.readValue(new File("dados.json"),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Map.class));
            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double totalFaturamento = 0;
            int diasComFaturamento = 0;
            for (Map<String, Object> faturamento : faturamentoDiario) {
                double faturamentoValor = (Double) faturamento.get("valor");
                if (faturamentoValor > 0) {
                    totalFaturamento += faturamentoValor;
                    diasComFaturamento++;
                    if (faturamentoValor < menorFaturamento) {
                        menorFaturamento = faturamentoValor;
                    }
                    if (faturamentoValor > maiorFaturamento) {
                        maiorFaturamento = faturamentoValor;
                    }
                }
            }
            double mediaMensal = totalFaturamento / diasComFaturamento;
            int diasAcimaMedia = 0;
            for (Map<String, Object> faturamento : faturamentoDiario) {
                double faturamentoValor = (Double) faturamento.get("valor");
                if (faturamentoValor > 0 && faturamentoValor > mediaMensal) {
                    diasAcimaMedia++;
                }
            }
            System.out.println("Menor valor de faturamento: " + menorFaturamento);
            System.out.println("Maior valor de faturamento: " + maiorFaturamento);
            System.out.println("Média mensal: " + mediaMensal);
            System.out.println("Número de dias acima da média mensal: " + diasAcimaMedia);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}