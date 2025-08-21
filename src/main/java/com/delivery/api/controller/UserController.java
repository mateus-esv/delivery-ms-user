package com.delivery.api.controller;

import com.delivery.api.dto.UserIDDTO;
import com.delivery.api.dto.UserInputDTO;
import com.delivery.api.dto.UserOutputDTO;
import com.delivery.comuns.Convert;
import com.delivery.domain.entity.User;
import com.delivery.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ResponseEntity<String> save(@RequestBody UserInputDTO userInputDto){
        User user = convert.inputConverter(userInputDto);
        service.save(user);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/list")
    private ResponseEntity<UserOutputDTO> list(@RequestBody UserIDDTO userIDDTO){
        User user = convert.inputConverter(userIDDTO);
        return ResponseEntity.ok(convert.outputConverter(service.findById(userIDDTO)));
    }

    @GetMapping("/list-all")
    private ResponseEntity<List<UserOutputDTO>> listAll(){
        List<UserOutputDTO> list = convert.convertListToOutput(service.listAll());
        return ResponseEntity.ok(list);
    }

}
