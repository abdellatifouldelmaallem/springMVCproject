package dao;
import entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainerImpl implements ITrainer{

    @Autowired
    @Qualifier("transactionManager")
    private HibernateTransactionManager transactionManager;
    private Trainer trainer;

    @Override
    public void saveTrainer(Trainer trainer) {
        transactionManager.getSessionFactory().getCurrentSession().save(trainer);
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        transactionManager.getSessionFactory().getCurrentSession().update(trainer);
    }

    @Override
    public void deleteTrainer(Long id) {
      trainer = transactionManager.getSessionFactory().getCurrentSession().load(Trainer.class,id);
      if (trainer!=null){
          transactionManager.getSessionFactory().getCurrentSession().delete(trainer);
      }
    }

    @Override
    public Trainer getTrainer(Long id) {
        trainer = transactionManager.getSessionFactory().getCurrentSession().get(Trainer.class,id);
        return trainer;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Trainer> getAllTrainer() {
        List<Trainer> trainerList = transactionManager.getSessionFactory().getCurrentSession().createQuery("from Trainer").list();
        return trainerList;
    }
}
