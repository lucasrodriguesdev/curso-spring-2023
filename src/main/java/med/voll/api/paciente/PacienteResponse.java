package med.voll.api.paciente;

public record PacienteResponse(
        String nome,
        String email,
        String cpf
) {
    public PacienteResponse(Paciente paciente){
        this(paciente.getNome(), paciente.getCpf(), paciente.getEmail());
    }

}
