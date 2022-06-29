package Caminho_Minado;

import java.util.Random;
import javax.swing.JOptionPane;

public class Jogo {
	public static void main(String[] args) {
		Random random = new Random();
		int contador = 0; 
		int escolha = 0;
		int contc = 0; 
		int contbp = 0; 
		
		Validacao vcampo = new Validacao(); // Função que valiida o tamanho do campo
			while(vcampo.campo < 2) { 
				int n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor "
						+ "do tamanho do caminho"));
				vcampo.campo = n1; //mandando o tamanho do campo para validação 
				}
			
		Validacao vbomba = new Validacao(); // Função que valida a quantidade de bombas
			while(vbomba.bomba < 1) { 
				int n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de "
						+ "bombas que tera no caminho"));
				vbomba.bomba = n2; // mandando a quantidade dee bombas para a validação
		}
			
		int jogo [] = new int [vcampo.campo+1]; // Array que ficara armazenado os 0 e 1
		int numeroAleatorio;
			for(int cc = 0; cc < vbomba.bomba; cc++) { // quantidade de lugares onde o programa colocara a bomba
				do {
					numeroAleatorio = random.nextInt(vcampo.campo); // sorteio do lugar de acordo com o tamanho do campo
			}
				while(jogo[numeroAleatorio] == 1);
				jogo[numeroAleatorio] = 1;
			}
			
			String visor [] = new String [vcampo.campo]; // Visor é oque aparecera ao usuario
			for(int cc = 0; cc < visor.length; cc++) {
				visor[cc] = " _ ";
				System.out.print(visor[cc]);
			}
			
		do {
		contador++;
			do {
			escolha = Integer.parseInt(JOptionPane.showInputDialog("Digite uma posição"));
			if (escolha > 0) {
				if (visor[escolha-1] == " X ") {
					escolha = 0;
				}
			}
			escolha = escolha -1;
			}
			while ((escolha < 0));
		
			if(jogo[escolha] == 0) {
				visor[escolha] = " X ";
				contc++;
			}
			
			else if(jogo[escolha] == 1){
				visor[escolha] = " B ";
			}
			
		System.out.printf("%n%n");
		for(int j = 0; j < visor.length; j++) {
			System.out.print(visor[j]);
		}
		
		
		if((jogo[escolha] == 1)) {
			System.out.printf("%n%n");
			JOptionPane.showMessageDialog(null, "GAME OVER");
			for(int r = 0; r < visor.length; r++) {
				if(jogo[r] == 0) {
					visor[r] = " X ";
				}
				
				else if(jogo[r] == 1){
					visor[r] = " B ";
				}
				if (contbp == 0) {
					JOptionPane.showMessageDialog(null, "Você acertou " + contc + "/" + (vcampo.campo - vbomba.bomba));
				}
				contbp++;
				System.out.print(visor[r]);
			}
			break;
		}
		
		if(contc == (vcampo.campo - vbomba.bomba)) {
			System.out.printf("%n%n");
			JOptionPane.showMessageDialog(null, "Parabéns, você ganhou o jogo!");
			for(int r = 0; r < visor.length; r++) {
				if(jogo[r] == 0) {
					visor[r] = " X ";
				}
				
				else if(jogo[r] == 1){
					visor[r] = " B ";
				}
				if (contbp == 0) {
					JOptionPane.showMessageDialog(null, "Você acertou " + contc + "/" + (vcampo.campo - vbomba.bomba));
				}
				contbp++;
				System.out.print(visor[r]);
			}
			break;
		}
		
		
		contbp = 0;
		if (jogo[escolha+1] == 1) {
			contbp++;
			System.out.print(" CUIDADO: Bomba Proxima!");
		}
		
		if (escolha > 0 && contbp == 0) {
		if (jogo[escolha-1] == 1) {
			System.out.print(" CUIDADO: Bomba Proxima!");
		}
		}
		else {
			continue;
		}
		}
		
		while(contador < vcampo.campo);
}
}



	


