package com.delivery.comuns;

import com.delivery.api.dto.UserIDDTO;
import com.delivery.api.dto.UserInputDTO;
import com.delivery.api.dto.UserOutputDTO;
import com.delivery.api.dto.UserUpdateInputDTO;
import com.delivery.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Convert {

    public User inputConverter(UserInputDTO userInputDto) {
        return User.builder()
                .fullname(userInputDto.fullname())
                .email(userInputDto.email())
                .password(userInputDto.password())
                .phone(userInputDto.phone())
                .level(userInputDto.level())
                .build();
    }

    public User inputConverter(UserUpdateInputDTO userUpdateInputDto) {
        return User.builder()
                .fullname(userUpdateInputDto.fullname())
                .email(userUpdateInputDto.email())
                .password(userUpdateInputDto.password())
                .phone(userUpdateInputDto.phone())
                .level(userUpdateInputDto.level())
                .build();
    }

    public User inputConverter(UserIDDTO userIDDTO) {
        return User.builder()
                .id(userIDDTO.id())
                .build();
    }

    public UserOutputDTO outputConverter(User user) {
        return new UserOutputDTO(
                user.getFullname(),
                user.getEmail(),
                user.getPhone(),
                user.getLevel()
        );
    }

    public List<UserOutputDTO> convertListToOutput(List<User> list) {
        List<UserOutputDTO> listOut = new ArrayList<>();

        list.forEach(item -> {
            listOut.add(outputConverter(item));
        });

        return listOut;
    }


}
