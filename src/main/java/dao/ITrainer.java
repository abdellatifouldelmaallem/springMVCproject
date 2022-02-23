package dao;

import java.util.List;
import entities.Trainer;

public interface ITrainer {
    void saveTrainer(Trainer trainer);

    void updateTrainer(Trainer trainer);

    void deleteTrainer(Long id);

    Trainer getTrainer(Long id);

    List< Trainer > getAllTrainer();
}
