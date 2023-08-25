package pl.gr.veterinaryapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gr.veterinaryapp.exception.IncorrectDataException;
import pl.gr.veterinaryapp.exception.ResourceNotFoundException;
import pl.gr.veterinaryapp.mapper.VetMapper;
import pl.gr.veterinaryapp.model.dto.VetRequestDto;
import pl.gr.veterinaryapp.model.dto.VetResponseDto;
import pl.gr.veterinaryapp.model.entity.Vet;
import pl.gr.veterinaryapp.repository.VetRepository;
import pl.gr.veterinaryapp.service.VetService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VetServiceImpl implements VetService {

    private final VetRepository vetRepository;
    private final VetMapper mapper;

    @Override
    public VetResponseDto getVetById(long id) {
        return vetRepository.findById(id).stream()
                .map(mapper::mapToDto)
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Wrong id."));
    }

    @Override
    public List<VetResponseDto> getAllVets() {
        return vetRepository.findAll().stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public VetResponseDto createVet(VetRequestDto vetRequestDTO) {
        if (vetRequestDTO.getSurname() == null || vetRequestDTO.getName() == null) {
            throw new IncorrectDataException("Name and Surname cannot be null.");
        }
        Vet vet = vetRepository.save(mapper.map(vetRequestDTO));
        return mapper.mapToDto(vet);
    }

    @Transactional
    @Override
    public void deleteVet(long id) {
        Vet result = vetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wrong id."));
        vetRepository.delete(result);
    }
}
