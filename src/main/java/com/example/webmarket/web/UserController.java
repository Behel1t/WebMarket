package com.example.webmarket.web;

import com.example.webmarket.Dto.SearchDto;
import com.example.webmarket.Dto.UserDto;
import com.example.webmarket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;
    @PostMapping
    public UserDto save(@RequestBody UserDto dto){
        return service.save(dto);
    }
    @GetMapping
    public List<UserDto> find(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public UserDto find(@PathVariable(name = "id") Integer id){
        return service.find(id);
    }
    @PutMapping("/{id}")
    public UserDto update(@PathVariable(name = "id") Integer id, @RequestBody UserDto request){
        return service.update(id,request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        service.delete(id);
    }
    @PostMapping("/find")
    public List<UserDto> find(@RequestBody SearchDto searchDto){
        return service.find(searchDto);
    }
    @GetMapping("/resolve/{username}")
    public UserDto findByUsername(@PathVariable(name = "username") String username){
        return service.findByUsername(username);
    }
}
