package engtelecom.std.projetofinal.exceptions;

public class SolicitacoesNaoEncontradoException extends  RuntimeException{

        public SolicitacoesNaoEncontradoException(String motivomissao){
            super("Não foi possível encontrar a solicitação com a missão:  "+motivomissao);
        }

}
