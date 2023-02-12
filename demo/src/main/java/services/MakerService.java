package services;

import entities.Maker;

import java.util.List;

public interface MakerService {
    List<Maker> getAllMakers();

    Maker getMakerById(Integer id);

    Maker addMaker(Maker maker);

    Maker updateMaker(Integer id, Maker maker);
}
