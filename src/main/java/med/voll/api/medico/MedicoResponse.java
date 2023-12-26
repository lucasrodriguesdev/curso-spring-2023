package med.voll.api.medico;

public record MedicoResponse(
 String nome,
 String email,
 String crm,
 Especialidade especialidade
) {
    public MedicoResponse(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
