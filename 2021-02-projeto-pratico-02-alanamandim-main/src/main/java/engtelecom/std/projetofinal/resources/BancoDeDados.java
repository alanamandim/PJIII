package engtelecom.std.projetofinal.resources;

import engtelecom.std.projetofinal.exceptions.MotoristaNaoEncontradoException;

import java.util.ArrayList;

public  class BancoDeDados {
     public static ArrayList<Motorista> bancodeDados;





    public BancoDeDados(){
        this.bancodeDados = new ArrayList<>();
        adicionamotora();
    }
    public Motorista buscaPeloId(String id){
        for(Motorista d: bancodeDados){
            if(d.getId()==id){
                return d;
            }
        }throw new MotoristaNaoEncontradoException(id);

    }
    public static Motorista verificaMotorista(Motorista motora, String id) {
        for (Motorista d : bancodeDados) {
            if (d.getId() == id) {
                d.setId(id);
                d.setNome_motorista(motora.getNome_motorista());
                ((Motorista) d).setDisponivel(((Motorista) motora).getDisponivel());
                
                return (Motorista) d;


            }

        }
        throw new MotoristaNaoEncontradoException(id);
    }


    // public void setMotorista(Motorista motora, int id) {

    //     this.bancodeDados.set(id,motora) ;
    // }



    public void adicionamotora(){
        Motorista motorista = new Motorista("Joao","4C7254D");
        // Cortina cortina = new Cortina(2,"cortina");
        // Televisao televisao = new Televisao(3,"televisão");
        // Som som = new Som(4,"som");
        // Portao portao = new Portao(5,"portao");
        // ArCondicionado arCondicionado = new ArCondicionado(6,"arcondicionado");
        // Lampada lampada2 = new Lampada(7,"lampada");
        // Cortina cortina2 = new Cortina(8,"cortina");
        // Televisao televisao2 = new Televisao(9,"televisão");
        // Som som2 = new Som(10,"som");
        // Portao portao2 = new Portao(11,"portao");
        // ArCondicionado arCondicionado2 = new ArCondicionado(12,"arcondicionado");
        bancodeDados.add(motorista);
        // bancodeDados.add(cortina);
        // bancodeDados.add(televisao);
        // bancodeDados.add(som);
        // bancodeDados.add(portao);
        // bancodeDados.add(arCondicionado);
        // bancodeDados.add(lampada2);
        // bancodeDados.add(cortina2);
        // bancodeDados.add(televisao2);
        // bancodeDados.add(som2);
        // bancodeDados.add(portao2);
        // bancodeDados.add(arCondicionado2);
    }
}
