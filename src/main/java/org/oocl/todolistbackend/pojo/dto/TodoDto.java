package org.oocl.todolistbackend.pojo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto {
    @NotBlank(message = "Unprocessable Entity")
    private String text;
    @NotNull(message = "Unprocessable Entity")
    private Boolean done;
}
