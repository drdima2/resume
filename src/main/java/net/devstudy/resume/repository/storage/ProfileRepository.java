package net.devstudy.resume.repository.storage;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.entity.SkillCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.sql.Timestamp;
import java.util.List;

@RepositoryDefinition(domainClass=Profile.class, idClass=Long.class)
public interface ProfileRepository extends PagingAndSortingRepository<Profile,Long> {

    // List<Profile> findAll(Sort sort);

    Profile findByUid(String uid);
    Profile findByEmail(String email);
    Profile findByPhone(String phone);
    int countByUid(String uid);
    Page<Profile> findAllByCompletedTrue(Pageable pageable);
    List<Profile> findByCompletedFalseAndCreatedBefore(Timestamp oldDate);

}
