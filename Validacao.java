package Caminho_Minado;

import java.util.Random;

public class Validacao {
	Random random = new Random();
	
	int campo;
	int bomba;
	int escolha;
	
	int validacaoCampo() {
		if(campo > 1) {
			return campo;
		}
		else {
			campo = 0;
			return campo;
		}
	}
	
	int validacaoBomba() {
		if(bomba > 0) {
			return bomba;
		}
		else {
			bomba = 0;
			return bomba;
		}
	}
}

