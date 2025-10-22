package sum25.se183036.pehsf302trialexamse183036.service;

import sum25.se183036.pehsf302trialexamse183036.entity.SonyCategories;

import java.util.List;

public interface SonyCategoriesService{
    public boolean addSonyCategories(SonyCategories category);
    SonyCategories getCategoryById(int id);
    List<SonyCategories> getAllCategories();
}
