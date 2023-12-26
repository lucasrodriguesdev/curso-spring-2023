package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import med.voll.api.medico.MedicoResponse;
import med.voll.api.paciente.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<MedicoResponse> listar (Pageable paginacao){
        return repository.findAll(paginacao).map(MedicoResponse::new);
    }

}