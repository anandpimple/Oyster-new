package com.oma.repositories.managestock;

import com.oma.domains.managestock.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by anandpimple on 01/11/2016.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
