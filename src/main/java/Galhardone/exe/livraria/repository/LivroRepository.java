package Galhardone.exe.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository<livro> extends JpaRepository<livro, Long> {
}
