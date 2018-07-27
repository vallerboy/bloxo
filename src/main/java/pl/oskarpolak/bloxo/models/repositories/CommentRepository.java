package pl.oskarpolak.bloxo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.oskarpolak.bloxo.models.CommentEntity;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
    List<CommentEntity> findAllByPost_Id(int id);
}
