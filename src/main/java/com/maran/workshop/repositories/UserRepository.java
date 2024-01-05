package com.maran.workshop.repositories;

import com.maran.workshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//not needed @Repository, because extends JpaRepository. @Repository is optional.
public interface UserRepository extends JpaRepository<User,Long> {

}
