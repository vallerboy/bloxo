package pl.oskarpolak.bloxo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentEntity extends CrudRepository<CommentEntity, Integer> {
}
