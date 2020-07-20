package tech.enjaz.rose.sahga.configs.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import tech.enjaz.rose.sahga.dto.SahgaDTO;
import tech.enjaz.rose.sahga.entity.Sahga;

@Component
public class SahgaDTOtoSahgaMapper extends ModelMapper {
    // from DTO to Entity
    public SahgaDTOtoSahgaMapper() {
        this.typeMap(SahgaDTO.class, Sahga.class)
                .addMapping(SahgaDTO::getSahga, Sahga::setWordSahga)
                .addMapping(SahgaDTO::getSahgaCorrection, Sahga::setWordCorrection)
                .addMapping(SahgaDTO::getTheSaheg, Sahga::setName);
    }

}
