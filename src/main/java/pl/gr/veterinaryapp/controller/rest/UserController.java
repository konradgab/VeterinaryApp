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
import pl.gr.veterinaryapp.mapper.VetAppUserMapper;
import pl.gr.veterinaryapp.model.dto.UserDto;
import pl.gr.veterinaryapp.service.UserService;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/users")
@RestController
public class UserController {

    private final UserService userService;
    private final VetAppUserMapper mapper;

    @GetMapping
    public List<UserDto> getAllUsers() {
        log.info("Gettinh all users");
        return mapper.mapAsList(userService.getAllUsers());
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        log.info("Creating user:"+ user);
        return mapper.map(userService.createUser(user));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        log.info("Delete user by id: "+ id);
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable long id) {
        log.info("Get user by id: "+id);
        return mapper.map(userService.getUser(id));
    }
}
