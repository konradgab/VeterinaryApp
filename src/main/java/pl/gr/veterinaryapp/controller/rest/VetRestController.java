package pl.gr.veterinaryapp.controller.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gr.veterinaryapp.model.dto.VetRequestDto;
import pl.gr.veterinaryapp.model.entity.Vet;
import pl.gr.veterinaryapp.service.VetService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/vets")
public class VetRestController {

    private final VetService vetService;

    @GetMapping("/{id}")
    public Vet getVet(@PathVariable long id) {
        return vetService.getVetById(id);
    }

    @PostMapping
    public Vet addVet(@RequestBody VetRequestDto vetRequestDTO) {
        Vet vet = vetService.createVet(vetRequestDTO);
        log.info("Created vet with ID {}.", vet.getId());
        return vet;
    }

    @GetMapping
    public List<Vet> getAllVets() {
        return vetService.getAllVets();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        vetService.deleteVet(id);
        log.info("Deleted vet with ID {}.", id);
    }
}
