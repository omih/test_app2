package com.zcmx.bit.data.converter;

import com.zcmx.bit.data.model.dto.UserDto;
import com.zcmx.bit.data.model.entity.UserEntity;

public class UserConverter {

    public static UserEntity toEntity(UserDto dto) {
        Long id = dto.getId();
        String name = dto.getName();
        Long carId = dto.getCarId();

        return new UserEntity(id, name, carId);
    }
}
