package service;

import dao.ITrainer;
import entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleTrainer {
    @Autowired
    private ITrainer trainerDAO;

    public void RsaveTrainer(Trainer trainer){
        trainerDAO.saveTrainer(trainer);
    }

    public void RdeleteTrainer(Long id){
        trainerDAO.deleteTrainer(id);
    }

    public void Rupdate(Trainer trainer){
        trainerDAO.updateTrainer(trainer);
    }

    public Trainer RgetById(Long id){
        Trainer t = trainerDAO.getTrainer(id);
        return  t;
    }

    public List<Trainer> getAllTrainer(){
        List<Trainer> trainerList = trainerDAO.getAllTrainer();
        return trainerList;
    }
}
