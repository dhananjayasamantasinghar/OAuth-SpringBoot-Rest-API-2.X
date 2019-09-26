package ai.auth.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ai.auth.jwt.domain.User;
	
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
