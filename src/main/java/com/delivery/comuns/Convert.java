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
                .fullName(userInputDto.fullName())
                .email(userInputDto.email())
                .phone(userInputDto.phone())
                .level(userInputDto.level())
                .build();
    }

    public User inputConverter(UserUpdateInputDTO userUpdateInputDTO) {
        return User.builder()
                .id(userUpdateInputDTO.id())
                .fullName(userUpdateInputDTO.fullName())
                .email(userUpdateInputDTO.email())
                .phone(userUpdateInputDTO.phone())
                .level(userUpdateInputDTO.level())
                .build();
    }

    public User inputConverter(UserIDDTO userIDDTO) {
        return User.builder()
                .id(userIDDTO.id())
                .build();
    }

    public UserOutputDTO outputConverter(User user) {
        return new UserOutputDTO(
                user.getId(),
                user.getFullName(),
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
