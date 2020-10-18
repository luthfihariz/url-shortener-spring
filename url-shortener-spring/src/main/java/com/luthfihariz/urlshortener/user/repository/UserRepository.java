package com.luthfihariz.urlshortener.user.repository;

import com.luthfihariz.urlshortener.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

}
