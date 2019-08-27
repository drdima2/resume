package net.devstudy.resume.repository.storage;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.entity.ProfileRestore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.sql.Timestamp;
import java.util.List;

@RepositoryDefinition(domainClass=Profile.class, idClass=Long.class)
public interface ProfileRestoreRepository extends CrudRepository<ProfileRestore,Long> {



    ProfileRestore findByToken(String token);


}
