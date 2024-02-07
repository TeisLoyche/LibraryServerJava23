package library.LibraryServerJava.repository;

import library.LibraryServerJava.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
