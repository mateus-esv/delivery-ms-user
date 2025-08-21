package com.delivery.comuns;

import com.delivery.api.dto.UserIDDTO;
import com.delivery.api.dto.UserInputDTO;
import com.delivery.api.dto.UserOutputDTO;
import com.delivery.domain.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Convert {

    @Autowired
    private ModelMapper mapper;

    public User inputConverter(UserInputDTO userInputDto){
        return mapper.map(userInputDto, User.class);
    }

    public User inputConverter(UserIDDTO userIDDTO) {
        return mapper.map(userIDDTO, User.class);
    }

    public UserOutputDTO outputConverter(User user){
        return mapper.map(user, UserOutputDTO.class);
    }

    public List<UserOutputDTO> convertListToOutput(List<User> list){
        List<UserOutputDTO> listOut = new ArrayList<>();

        list.forEach(item -> {
            listOut.add(outputConverter(item));
        });

        return listOut;
    }


}
