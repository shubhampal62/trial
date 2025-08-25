package com.natwest.costcontrol.repository;

import com.natwest.costcontrol.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(String userId);
    List<Transaction> findByCategoryId(String categoryId);
    List<Transaction> findByUserIdAndCategoryId(String userId, String categoryId);
}
