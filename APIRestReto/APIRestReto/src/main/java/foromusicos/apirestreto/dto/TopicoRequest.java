package foromusicos.apirestreto.dto;

import jakarta.validation.constraints.NotBlank;

public record TopicoRequest(
        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotBlank
        String curso
) {
}
