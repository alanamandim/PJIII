package engtelecom.std.projetofinal.resources;

import engtelecom.std.projetofinal.exceptions.MotoristaNaoEncontradoException;

import java.util.ArrayList;

public class Solicitacoes {

    private String motivodamissao;
    Motorista motora = new Motorista();
    private boolean aprovado = false;
    //private

   // private ArrayList<Motorista>motora=new ArrayList<>();

    // public enum OpcoesMenu {
    //     Aguardando_aprovacao(1), Aprovada(2), Negada(3), Saiu_para_missao(4), Retornou_da_missao(5), Finalizada(6);
        
    //     private final int valor;
    //     OpcoesMenu(int valorOpcao){
    //     valor = valorOpcao;
    // }
    // public int getValor(){
    //     return valor;
    // }



    public Solicitacoes(String motivodamissao, String id){
       this.motivodamissao = motivodamissao;
       this.motora = BancoDeDados.verificaMotorista(motora,id);
   }
    public Solicitacoes(){}

    public void setMotivodamissao(String motivodamissao) {
        this.motivodamissao = motivodamissao;
    }

    public String getMotivodamissao() {
        return motivodamissao;
    }

    // public void setMotorista(Motorista motora) {
    //    this.motora.add(motora);
    // }

    public Motorista getMotorista() {

                return motora;
    }

    public void setMotorista(Motorista motora, String id){
        motora=BancoDeDados.verificaMotorista(motora, id);
    }

    public String getNome_motorista() {
        return motora.getNome_motorista();
    }


    public boolean getAprovado(){
        return aprovado;
    }

    public void setAprovado(){
        aprovado=true;
    }
    // public void setDispositivoCortina(Cortina disp, int id){
    //     equip.add(BancoDeDados.verificaCortina(disp, id));
    // }
    

//    public void excluiMotorista(String id){
//        motora.removeIf(d -> d.getId() == id);
//    }


    // public void adicionaDispositivo(int id){
    //    // banco=bancoDeDados.getBancodeDados();
    //     for( Dispositivo d: BancoDeDados.bancodeDados){
    //         if(d.getId()==id){
    //             System.out.println(d);
    //             this.equip.add(d);
    //         }
    //     }
    //    }


    // public Motorista buscaMotoristaPeloId(int id) {
    //    for(Dispositivo d : equip){
    //        if(d.getId()==id){
    //            return d;

    //        }
    //    }throw new DispositivoNaoEncontradoException(id);

    // }

    
}
