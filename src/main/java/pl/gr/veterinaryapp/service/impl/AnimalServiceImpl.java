package pl.gr.veterinaryapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gr.veterinaryapp.exception.IncorrectDataException;
import pl.gr.veterinaryapp.exception.ResourceNotFoundException;
import pl.gr.veterinaryapp.mapper.AnimalMapper;
import pl.gr.veterinaryapp.model.dto.AnimalDto;
import pl.gr.veterinaryapp.model.dto.AnimalRequestDto;
import pl.gr.veterinaryapp.model.entity.Animal;
import pl.gr.veterinaryapp.repository.AnimalRepository;
import pl.gr.veterinaryapp.service.AnimalService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalMapper mapper;

    @Override
    public AnimalDto getAnimalById(long id) {
        return mapper.toDto(animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wrong id.")));
    }

    @Transactional
    @Override
    public AnimalDto createAnimal(AnimalRequestDto animalRequestDto) {
        if (animalRepository.findBySpecies(animalRequestDto.getSpecies()).isPresent()) {
            throw new IncorrectDataException("Species exists.");
        }
        return mapper.toDto(animalRepository.save(mapper.map(animalRequestDto)));
    }

    @Transactional
    @Override
    public void deleteAnimal(long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wrong id."));
        animalRepository.delete(animal);
    }

    @Override
    public List<AnimalDto> getAllAnimals() {
        return animalRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
