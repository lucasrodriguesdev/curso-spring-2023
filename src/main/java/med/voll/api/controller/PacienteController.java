package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.DadosPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import med.voll.api.paciente.PacienteResponse;
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
        return repository.findAll(paginacao).map(PacienteResponse::new);
    }
}
