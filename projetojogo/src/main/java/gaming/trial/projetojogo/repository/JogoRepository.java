package gaming.trial.projetojogo.repository;

import gaming.trial.projetojogo.domain.Jogo;

import java.util.List;

public interface JogoRepository {
    List<Jogo> listAll();
}