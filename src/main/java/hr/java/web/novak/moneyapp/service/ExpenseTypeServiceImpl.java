package hr.java.web.novak.moneyapp.service;

import hr.java.web.novak.moneyapp.model.ExpenseType;
import hr.java.web.novak.moneyapp.repository.ExpenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Repository
public class ExpenseTypeServiceImpl implements ExpenseTypeService{

    private final ExpenseTypeRepository typeRepository;

    @Autowired
    public ExpenseTypeServiceImpl(ExpenseTypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    @Transactional
    public Set<ExpenseType> findAll() {
        return new HashSet<>(typeRepository.findAll());
    }

    @Override
    public ExpenseType findById(Long aLong) {
        return null;
    }

    @Override
    public ExpenseType save(ExpenseType object) {
        return null;
    }

    @Override
    public void delete(ExpenseType object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
