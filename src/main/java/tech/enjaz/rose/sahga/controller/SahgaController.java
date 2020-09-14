package tech.enjaz.rose.sahga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import tech.enjaz.rose.sahga.dto.SahgaDTO;
import tech.enjaz.rose.sahga.service.SahgaService;

@RestController
public class SahgaController {

    SahgaService sahgaService;

    @Autowired
    public SahgaController(SahgaService sahgaService) {
        this.sahgaService = sahgaService;
    }

    @GetMapping("/sahgat")
    public @ResponseBody
    List<SahgaDTO> getAllSahgat() {
        return sahgaService.getAllSahgat();
    }

    @GetMapping("/sahgat/{id}")
    public @ResponseBody
    SahgaDTO getSahga(@PathVariable Long id) {
        return sahgaService.getSahga(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "BOOOOOOOOOOO"));
    }

    @PostMapping("/add")
    public @ResponseBody
    SahgaDTO addNewSahga(@RequestBody SahgaDTO sahgaDTO) {
        return sahgaService.addSahga(sahgaDTO);
    }

}
