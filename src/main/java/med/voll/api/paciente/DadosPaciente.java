package med.voll.api.paciente;

import med.voll.api.endereco.DadosEndereco;

public record DadosPaciente(
        String nome,
        String cpf,
        String telfone,
        DadosEndereco endereco
) {
}
