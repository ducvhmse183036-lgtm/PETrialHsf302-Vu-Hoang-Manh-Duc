package sum25.se183036.pehsf302trialexamse183036.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyCategories;
import sum25.se183036.pehsf302trialexamse183036.repository.SonyCategoriesRepository;

import java.util.List;

@Service
public class SonyCategoriesServiceImpl implements  SonyCategoriesService {
    @Autowired
    private SonyCategoriesRepository SonyCategoriesRepository;
    @Override
    public boolean addSonyCategories(SonyCategories category) {
        return SonyCategoriesRepository.save(category)!=null;
    }

    @Override
    public List<SonyCategories> getAllCategories() {
        return SonyCategoriesRepository.findAll();
    }
    @Override
    public SonyCategories getCategoryById(int id) {
        return SonyCategoriesRepository.findById(id).orElse(null);
    }
}
