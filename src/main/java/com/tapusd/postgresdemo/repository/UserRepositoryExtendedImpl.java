package com.tapusd.postgresdemo.repository;

import com.tapusd.postgresdemo.dto.response.UserDTO;
import com.tapusd.postgresdemo.repository.support.ExtendedRepositoryBase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A demo of spring data jpa Composable Repositories
 * and how to expose and utilize persistence context's entity manager a convenient way
 */
@Repository
public class UserRepositoryExtendedImpl extends ExtendedRepositoryBase implements UserRepositoryExtended {

    public UserRepositoryExtendedImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<UserDTO> findAllDTO() {
        return getSession()
                // user is a keyword in postgres, so escaping that keyword with double quote
                .createNativeQuery("SELECT id, name, email, age FROM \"user\"", Tuple.class)
                .getResultStream()
                .map(tuple -> new UserDTO(Long.valueOf(tuple.get(0, Integer.class)),
                        tuple.get(1, String.class),
                        tuple.get(2, String.class),
                        tuple.get(3, Integer.class)))
                .toList();
    }
}
