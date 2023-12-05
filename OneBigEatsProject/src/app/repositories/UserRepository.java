package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.User;

public interface UserRepository extends JpaRepository<User, String>
{
	User findByUsername(String username);
	User findByUsernameAndPassword(String username, String password);
}
