package engtelecom.std.projetofinal.resources;

public class Motorista {
    String nome_motorista;
    String id;
    boolean disponivel;

    public Motorista(String nome_motorista,String id) {
        this.id =id;
        this.nome_motorista = nome_motorista;
        this.disponivel = true; //significa que ele nao está em missão nesse momento
    }
    public Motorista(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   public void setNome_motorista(String nome) {
        this.nome_motorista = nome;
    }

    public String getNome_motorista() {
        return nome_motorista;
    }

    public void setDisponivel(boolean inf){
        this.disponivel = inf;
    }

    public boolean getDisponivel(){
        return disponivel;
    }

    

}

    

    

