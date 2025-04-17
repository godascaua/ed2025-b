public final class JogoDaVelha {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int dimensao;
    protected int [][]tabuleiro;
    protected int jogador;

    public JogoDaVelha(int dimensao) {
        this.dimensao = dimensao;
        this.tabuleiro = new int[dimensao][dimensao];
        limpaTabuleiro();
    }

    public void limpaTabuleiro() {
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                tabuleiro[i][j] = VAZIO;
            }
        }
        jogador = X;
    }

    public void poePeca(int i, int j) {
        if (i < 0 || i >= dimensao || j < 0 || j >= dimensao){
            throw new IllegalArgumentException("Posição Inválida");
        }
        if (tabuleiro[i][j]!=VAZIO) throw new IllegalArgumentException("Posição Ocupada");
        tabuleiro[i][j]=jogador;
        jogador = -jogador;
    }


    public String venceuUsando() {
        String resultado = "continuar";

        for (int i = 0; i < dimensao; i++) {
            int somaLinha = 0, somaColuna = 0;
            for (int j = 0; j < dimensao; j++) {
                somaLinha += tabuleiro[i][j];
                somaColuna += tabuleiro[j][i];
            }
            if (somaLinha == dimensao * X || somaLinha == dimensao * O ) return resultado = "linha";
            if (somaColuna == dimensao * X || somaColuna == dimensao* O) return resultado = "coluna";
        }
        int somaDiagonalPrincipal = 0, somaDiagonalSecundaria = 0;
        for (int i = 0; i < dimensao; i++) {
            somaDiagonalPrincipal += tabuleiro[i][i];
            somaDiagonalSecundaria += tabuleiro[i][dimensao - i - 1];
        }
        if (somaDiagonalPrincipal == dimensao * X || somaDiagonalSecundaria == dimensao * X) return resultado = "diagonal";
        if (somaDiagonalPrincipal == dimensao * O || somaDiagonalSecundaria == dimensao * O) return resultado = "diagonal";
        // Implemente este método que deve retornar se o vencedor venceu com
        // uma linha, coluna ou diagonal. O retorno deve ser "linha", "coluna",
        // "diagonal" ou "continuar" caso o jogo não tenha terminado.

        return resultado;
    }
    
    @Override
    public String toString() {
        /** Implementar o método to String que deve retornar
         * uma string com o tabuleiro do jogo da velha com as peças
         * nas posições corretas.
         */

         StringBuilder retorno = new StringBuilder();
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                switch (tabuleiro[i][j]) {
                    case X -> retorno.append("X");
                    case O -> retorno.append("O");
                    default -> retorno.append(" ");
                }
                if (j < dimensao - 1) retorno.append("|");
            }
            if (i < dimensao - 1) {
                retorno.append("\n");
                for (int k = 0; k < dimensao * 2 - 1; k++) retorno.append("─");
                retorno.append("\n");
            }
        }
        return retorno.toString();
      
    }
}