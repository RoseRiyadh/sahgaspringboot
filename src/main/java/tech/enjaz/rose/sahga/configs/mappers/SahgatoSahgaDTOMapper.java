package tech.enjaz.rose.sahga.configs.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

import tech.enjaz.rose.sahga.dto.SahgaDTO;
import tech.enjaz.rose.sahga.entity.Sahga;

@Component
public class SahgatoSahgaDTOMapper extends ModelMapper {
    //Entity to DTO
    public SahgatoSahgaDTOMapper() {
        this.typeMap(Sahga.class, SahgaDTO.class)
                .addMapping(Sahga::getName, SahgaDTO::setTheSaheg)
                .addMapping(Sahga::getWordSahga, SahgaDTO::setSahga)
                .addMapping(Sahga::getWordCorrection, SahgaDTO::setSahgaCorrection);
    }

}
