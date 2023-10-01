package pl.gr.veterinaryapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

    private String name;
    private String surname;
    private String username;
}

