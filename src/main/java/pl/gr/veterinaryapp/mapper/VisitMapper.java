package pl.gr.veterinaryapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.gr.veterinaryapp.model.dto.VisitResponseDto;
import pl.gr.veterinaryapp.model.entity.Visit;
import pl.gr.veterinaryapp.service.PetService;
import pl.gr.veterinaryapp.service.VetService;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", uses = {VetService.class, PetService.class})
public interface VisitMapper {


    @Mappings({
            @Mapping(source = "vet.id", target = "vetId"),
            @Mapping(source = "pet.id", target = "petId"),
            @Mapping(source = "treatmentRoom.id", target = "treatmentRoomId")
    })
    VisitResponseDto map(Visit visit);

    List<VisitResponseDto> mapAsList(Collection<Visit> visit);
}
