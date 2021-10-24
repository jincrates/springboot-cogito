package com.jincrates.cogito.repository;

import com.jincrates.cogito.dto.UserDTO;
import com.jincrates.cogito.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from User m where m.fromSocial = :social and m.email = :email")
    Optional<User> findByEmail(@Param("email") String email, @Param("social") boolean social);

    /*
    @Transactional
    @Modifying
    @Query("delete from User m where m.email = :email")
    void deleteByEmail(@Param("email") String email);
    */
}
