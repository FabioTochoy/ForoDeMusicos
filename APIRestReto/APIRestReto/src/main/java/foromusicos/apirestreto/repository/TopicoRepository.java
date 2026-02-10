package foromusicos.apirestreto.repository;


import foromusicos.apirestreto.domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
