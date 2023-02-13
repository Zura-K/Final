package main.controller;

import main.entities.Maker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import main.repositories.MakerRepository;
import main.services.MakerServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("/makers")
@RequiredArgsConstructor
public class MakerController {

    private final MakerRepository makerRepository;
    MakerServiceImplementation makerService;
    @GetMapping
    public List<Maker> getAllMakers() {
        return makerService.getAllMakers();
    }

    @GetMapping("/{id}")
    public Maker getMakerById(@PathVariable Integer id) {
        return makerService.getMakerById(id);
    }

    @PostMapping
    public Maker addMaker(@RequestBody Maker maker) {
        return makerService.addMaker(maker);
    }

    @PutMapping("/{id}")
    public Maker updateMaker(@PathVariable Integer id, @RequestBody Maker maker) {
        return makerService.updateMaker(id,maker);
    }

    @DeleteMapping("/{id}")
    public void deleteMaker(@PathVariable Integer id) {
        makerRepository.deleteById(id);
    }
}