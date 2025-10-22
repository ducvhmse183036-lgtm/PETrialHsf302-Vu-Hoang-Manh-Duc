package sum25.se183036.pehsf302trialexamse183036.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyProducts;

import java.util.List;

@Repository
public interface SonyProductsRepository extends JpaRepository<SonyProducts, Integer> {
    @Query("SELECT p FROM SonyProducts p ORDER BY p.createAt DESC")
    List<SonyProducts> findAllByOrderByCreateAtDesc();

}
