package pl.gr.veterinaryapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddressDto {
    private final String postalCode;
    private final String streetName;
    private final DescriptionDto description;
}

// new AddressDto("13-132", "Krotka", new DescriptionDto("aaa", "bbb"));

// List.of(new AddressDto("13-132", "Krotka", new DescriptionDto("aaa", "bbb")),
// new AddressDto("123-432", "Dluga", new DescriptionDto("qwe", "ewq")))
