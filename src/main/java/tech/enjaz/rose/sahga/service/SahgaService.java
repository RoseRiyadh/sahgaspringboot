package tech.enjaz.rose.sahga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import tech.enjaz.rose.sahga.dto.SahgaDTO;
import tech.enjaz.rose.sahga.entity.Sahga;
import tech.enjaz.rose.sahga.repository.SahgaRepository;
import tech.enjaz.rose.sahga.configs.mappers.SahgaDTOtoSahgaMapper;
import tech.enjaz.rose.sahga.configs.mappers.SahgatoSahgaDTOMapper;

@Service
public class SahgaService {

    SahgaRepository sahgaRepository;
    SahgaDTOtoSahgaMapper sahgaDTOtoSahgaMapper;
    SahgatoSahgaDTOMapper sahgatoSahgaDTOMapper;

    @Autowired
    public SahgaService(SahgaRepository sahgaRepository,
                        SahgaDTOtoSahgaMapper sahgaDTOtoSahgaMapper,
                        SahgatoSahgaDTOMapper sahgatoSahgaDTOMapper) {
        this.sahgaRepository = sahgaRepository;
        this.sahgatoSahgaDTOMapper = sahgatoSahgaDTOMapper;
        this.sahgaDTOtoSahgaMapper = sahgaDTOtoSahgaMapper;
    }

    public List<SahgaDTO> getAllSahgat() {
        return sahgaRepository.findAll().stream()
                .map(sahga -> sahgatoSahgaDTOMapper.map(sahga, SahgaDTO.class))
                .collect(Collectors.toList());
    }

    public SahgaDTO addSahga(SahgaDTO sahgaDTO) {
        sahgaRepository.save(sahgaDTOtoSahgaMapper.map(sahgaDTO, Sahga.class));
        return sahgaDTO;
    }

    public Optional<SahgaDTO> getSahga(Long id) {
        return sahgaRepository.findById(id).map(sahga -> sahgatoSahgaDTOMapper.map(sahga, SahgaDTO.class));

    }

}
