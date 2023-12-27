package med.voll.api.paciente;

public record PacienteResponse(
        Long id,
        String nome,
        String email,
        String cpf
) {
    public PacienteResponse(Paciente paciente){

        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail());
    }

}
