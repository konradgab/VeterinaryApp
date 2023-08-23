package pl.gr.veterinaryapp.service;

import pl.gr.veterinaryapp.model.dto.AnimalDto;
import pl.gr.veterinaryapp.model.dto.AnimalRequestDto;
import pl.gr.veterinaryapp.model.entity.Animal;

import java.util.List;

public interface AnimalService {

    AnimalDto getAnimalById(long id);

    AnimalDto createAnimal(AnimalRequestDto animalRequestDTO);

    void deleteAnimal(long id);

    List<AnimalDto> getAllAnimals();
}
