package hr.java.web.novak.moneyapp.service;

import hr.java.web.novak.moneyapp.model.TransactionCategory;
import hr.java.web.novak.moneyapp.repository.TransactionCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TransactionCategoryServiceImpl implements TransactionCategoryService {

    private final TransactionCategoryRepository tryCategoryRepository;

    @Autowired
    public TransactionCategoryServiceImpl(TransactionCategoryRepository tryCategoryRepository) {
        this.tryCategoryRepository = tryCategoryRepository;
    }

    @Override
    public Set<TransactionCategory> findAll() {
        return new HashSet<>(tryCategoryRepository.findAll());
    }

    @Override
    public TransactionCategory findById(Long aLong) {
        return null;
    }

    @Override
    public TransactionCategory save(TransactionCategory object) {
        return null;
    }

    @Override
    public void delete(TransactionCategory object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
