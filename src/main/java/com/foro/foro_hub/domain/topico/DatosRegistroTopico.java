package com.foro.foro_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        @NotBlank(message = "El título no puede estar vacío")
        String titulo,

        @NotBlank(message = "El mensaje no puede estar vacío")
        String mensaje,

        @NotBlank(message = "El autor no puede estar vacío")
        String autor,

        @NotBlank(message = "El curso no puede estar vacío")
        String curso

) {
}
