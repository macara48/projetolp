package gaming.trial.projetojogo.service;

import gaming.trial.projetojogo.domain.Jogo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JogoService {
    private static List<Jogo> jogos;

    static {
        jogos = new ArrayList<>(List.of(new Jogo(1L,"GTA V","Ação-aventura","Rockstar Games",true,"Console e PC", 69.99), new Jogo(2L,"Super Mario","Aventura e plataforma","Nintendo",false,"Console",0.0)));
    }

    // private final JogoRepository jogoRepository;
    public List<Jogo> listAll() {

        return jogos;
    }

    public Jogo findById(long id) {
        return jogos.stream()
                .filter(jogo -> jogo.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Jogo not Found"));
    }

    public Jogo save(Jogo jogo) {
        jogo.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        jogos.add(jogo);
        return jogo;
    }

    public void delete(long id) {
        jogos.remove(findById(id));
    }

    public void replace(Jogo jogo) {
        delete(jogo.getId());
        jogos.add(jogo);
    }
}
