package main.services;

import main.entities.Maker;
import main.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import main.repositories.MakerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MakerServiceImplementation implements MakerService {
    MakerRepository makerRepository;

    @Override
    public List<Maker> getAllMakers() {
        return makerRepository.findAll();
    }

    @Override
    public Maker getMakerById(Integer id) {
        return makerRepository.findById(id).orElseThrow (() -> new NotFoundException("Product not found"));
    }

    @Override
    public Maker addMaker(Maker maker) {
        return makerRepository.save(maker);
    }

    @Override
    public Maker updateMaker(Integer id, Maker maker) {
        Optional<Maker> existingMaker = makerRepository.findById(id);

        if (existingMaker.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with id " + id);
        }

        existingMaker.get().setMakerName(maker.getMakerName());

        return makerRepository.save(existingMaker.get());
    }
}
