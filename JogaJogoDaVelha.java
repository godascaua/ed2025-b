import java.util.Random;
import java.util.Scanner;

public class JogaJogoDaVelha {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao teste do Jogo da Velha!");

        Scanner scanner = new Scanner(System.in);

        

        System.out.println("Digite 1 para jogar ou 0 para sair: ");
        int opcao = scanner.nextInt();
        System.out.println("Digite um número inteiro para a dimensão do tabuleiro: ");
            int dimensao = scanner.nextInt();

        JogoDaVelha jogo = new JogoDaVelha(dimensao);
        Random random = new Random();
        while (opcao!=0) {
            int i, j;
            jogo.limpaTabuleiro();
            while (jogo.venceuUsando().equals("continuar")) {
                i = random.nextInt(dimensao);
                j = random.nextInt(dimensao);
                try {
                    jogo.poePeca(i, j);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                
            }
            if (! jogo.venceuUsando().equals("empate")) {
                System.out.println("Jogador ganhou utilizando: " + jogo.venceuUsando() );
            } else  {
                System.out.println("Empate!");
            }
        
            System.out.println(jogo.toString());
            System.out.println("Deseja jogar novamente? (1-sim, 0-nao): ");
            opcao = scanner.nextInt();
        }
    }
}
