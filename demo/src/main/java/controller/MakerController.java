package controller;

import entities.Maker;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/makers")
public class MakerController {

    @GetMapping
    public List<Maker> getAllMakers() {
        // Implementation to retrieve all makers from database
        return null;
    }

    @GetMapping("/{id}")
    public Maker getMakerById(@PathVariable Integer id) {
        // Implementation to retrieve maker by id from database
        return null;
    }

    @PostMapping
    public Maker addMaker(@RequestBody Maker maker) {
        // Implementation to add a new maker to database
        return null;
    }

    @PutMapping("/{id}")
    public Maker updateMaker(@PathVariable Integer id, @RequestBody Maker maker) {
        // Implementation to update an existing maker in database
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMaker(@PathVariable Integer id) {
        // Implementation to delete a maker from database
    }
}