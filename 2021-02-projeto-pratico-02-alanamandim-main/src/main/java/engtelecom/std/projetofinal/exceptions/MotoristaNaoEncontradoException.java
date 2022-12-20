package engtelecom.std.projetofinal.exceptions;

public class MotoristaNaoEncontradoException extends  RuntimeException{
    public MotoristaNaoEncontradoException(String id){
        super("Não foi possível encontrar o motorista com id: "+id);
    }
}