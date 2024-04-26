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
import pl.gr.veterinaryapp.mapper.ClientMapper;
import pl.gr.veterinaryapp.model.dto.ClientRequestDto;
import pl.gr.veterinaryapp.model.dto.ClientResponseDto;
import pl.gr.veterinaryapp.service.ClientService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/clients")
public class ClientRestController {

    private final ClientService clientService;
    private final ClientMapper mapper;

    @GetMapping("/{id}")
    public ClientResponseDto getClient(@PathVariable long id) {
        return mapper.map(clientService.getClientById(id));
    }

    @PostMapping
    public ClientResponseDto createClient(@RequestBody ClientRequestDto clientRequestDTO) {
        ClientResponseDto clientResponseDto = mapper.map(clientService.createClient(clientRequestDTO));
        log.info("Created client with ID {}.", clientResponseDto.getId());
        return clientResponseDto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        clientService.deleteClient(id);
        log.info("Deleted client with ID {}.", id);
    }

    @GetMapping
    public List<ClientResponseDto> getAllClients() {
        return mapper.mapAsList(clientService.getAllClients());
    }
}
