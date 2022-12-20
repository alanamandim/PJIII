package engtelecom.std.projetofinal.controller;


import engtelecom.std.projetofinal.exceptions.MotoristaNaoEncontradoException;
import engtelecom.std.projetofinal.resources.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/motoristas")
public class MotoristaController {



        BancoDeDados motoristas = new BancoDeDados();
        public List<Motorista> mot = new ArrayList<>();


        @GetMapping //ok
        public ArrayList<Motorista> obterTodosMotoristas(){return BancoDeDados.bancodeDados;}

        @GetMapping("/{id}") //ok
        public Motorista obterMotoristaPeloId(@PathVariable String id){
                    return motoristas.buscaPeloId(id);
        }

            @ControllerAdvice
            class MotoristaNaoEncontrado {
                @ResponseBody
                @ExceptionHandler(MotoristaNaoEncontradoException.class)
                @ResponseStatus(HttpStatus.NOT_FOUND)
                String motoristaNaoEncontrado(MotoristaNaoEncontradoException p) {
                    return p.getMessage();
                }
            }
        

        @PostMapping("{nome_motorista}") //ok
        @ResponseStatus(HttpStatus.CREATED)
        public Motorista adicionaMotorista(@PathVariable String nome_motorista,  @RequestParam(value = "id")String id){
            Motorista mo = new Motorista(nome_motorista,id);
            this.mot.add(mo);
            return mo;
        }
    }

        













