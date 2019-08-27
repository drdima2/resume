package net.devstudy.resume.repository.storage;

import net.devstudy.resume.entity.SkillCategory;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;


public interface SkillCategoryRepository2 extends PagingAndSortingRepository<SkillCategory, Long> {

}
