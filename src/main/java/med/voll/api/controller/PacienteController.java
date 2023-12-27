package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastroPaciente(@RequestBody @Valid DadosPaciente dadosPaciente){
        repository.save(new Paciente(dadosPaciente));
    }

    @GetMapping
    public Page<PacienteResponse> listar (@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(PacienteResponse::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaveisPaciente dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizaDadosPaciente(dados);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }

}
