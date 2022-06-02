package gaming.trial.projetojogo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Jogo {

	private Long id;
	private String name;
	private String genero;
	private String empresaDev;
	private boolean status;
	private String plataforma;
	private double preco;

}
