package com.delivery.api.controller;

import com.delivery.api.dto.*;
import com.delivery.comuns.Convert;
import com.delivery.domain.entity.User;
import com.delivery.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/user"})
public class UserController {

    @Autowired
    private Convert convert;

    @Autowired
    private UserService service;

    @PostMapping("/save")
    public ResponseEntity<Message> save(@RequestBody UserInputDTO userInputDto){
        System.out.println(userInputDto.toString());
        User user = convert.inputConverter(userInputDto);
        service.save(user);
        return new ResponseEntity<Message>(Message.builder().message("Usuário criado com sucesso.").build(), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Message> update(@RequestBody UserUpdateInputDTO userUpdateInputDto){
        User user = convert.inputConverter(userUpdateInputDto);
        service.update(user);
        return new ResponseEntity<Message>(Message.builder().message("Usuário atualizado com sucesso.").build(), HttpStatus.OK);
    }

    @PostMapping("/list")
    public ResponseEntity<UserOutputDTO> list(@RequestBody UserIDDTO userIDDTO){
        User user = convert.inputConverter(userIDDTO);
        return ResponseEntity.ok(convert.outputConverter(service.findById(userIDDTO)));
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<UserOutputDTO>> listAll(){
        List<UserOutputDTO> list = convert.convertListToOutput(service.listAll());
        return ResponseEntity.ok(list);
    }

}
