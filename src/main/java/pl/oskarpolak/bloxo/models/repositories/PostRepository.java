package pl.oskarpolak.bloxo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.bloxo.models.PostEntity;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {
}
