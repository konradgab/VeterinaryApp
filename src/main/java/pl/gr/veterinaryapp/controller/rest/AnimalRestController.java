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
import pl.gr.veterinaryapp.model.dto.AnimalRequestDto;
import pl.gr.veterinaryapp.model.entity.Animal;
import pl.gr.veterinaryapp.service.AnimalService;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/animals")
public class AnimalRestController {

    private final AnimalService animalService;

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable long id) {
        log.info("Getting animal with id:" + id);
        return animalService.getAnimalById(id);
    }

    @PostMapping
    public Animal createAnimal(@RequestBody AnimalRequestDto animalRequestDTO) {
        log.info("Creating animal:"+ animalRequestDTO);
        return animalService.createAnimal(animalRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        log.info("Delete animal with id:"+ id);
        animalService.deleteAnimal(id);
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
        log.info("Getting animals");
        return animalService.getAllAnimals();
    }
}
