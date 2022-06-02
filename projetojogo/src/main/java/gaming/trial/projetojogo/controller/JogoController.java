package gaming.trial.projetojogo.controller;

import gaming.trial.projetojogo.domain.Jogo;
import gaming.trial.projetojogo.service.JogoService;
import gaming.trial.projetojogo.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("jogos")
@Log4j2
@RequiredArgsConstructor
public class JogoController {
    private final DateUtil dateUtil;
    private final JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<Jogo>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(jogoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Jogo> findById(@PathVariable long id) {

        return ResponseEntity.ok(jogoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Jogo> save(@RequestBody Jogo jogo) {
        return new ResponseEntity<>(jogoService.save(jogo), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        jogoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Jogo jogo) {
        jogoService.replace(jogo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}