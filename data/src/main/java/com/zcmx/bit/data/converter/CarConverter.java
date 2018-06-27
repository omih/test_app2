package com.zcmx.bit.data.converter;

import com.zcmx.bit.data.model.dto.CarDto;
import com.zcmx.bit.data.model.dto.InfoDto;
import com.zcmx.bit.data.model.entity.CarEntity;

public class CarConverter {

    public static CarEntity toEntity(CarDto dto) {
        Long id = dto.getId();
        String name = dto.getName();
        InfoDto info = dto.getInfo();

        return new CarEntity(id, name, info.getDate(), info.getMileage(), info.getColor());
    }
}
