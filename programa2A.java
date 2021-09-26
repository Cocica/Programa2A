package programa2A;

import java.util.Arrays;
import java.util.Scanner;

public class programa2A {
	
	public static void main(String[] args) { //Complexidade ciclomática: 5
		Scanner entrada = new Scanner(System.in);
		int n = entrada.nextInt();
		int linhas = (n*n-n)/2; 
		int [] vetorPontosMarcados = new int [n];
		int [] vetorPontosRecebidos = new int [n];
		double [] vetorCestaAVG = new double [n];
		int [] vetorVitoria = new int [n];
		int [][] matrizEntrada = new int [linhas][4];
		
		for (int i=0;i<n;i++) {
			vetorVitoria[i]=0;
			vetorPontosMarcados[i]=0;
			vetorPontosRecebidos[i]=0;
			vetorCestaAVG[i]=0;
		}
		
		for (int i=0;i<linhas;i++) {
			for (int j=0;j<4;j++) {
				matrizEntrada[i][j] = entrada.nextInt();
			}
		}
		
		vetorVitoria = calculaPontosTotais(matrizEntrada,vetorVitoria,linhas);
		vetorPontosMarcados = calculaPontosMarcados(matrizEntrada,vetorPontosMarcados,linhas);
		vetorPontosRecebidos = calculaPontosRecebidos(matrizEntrada,vetorPontosRecebidos,linhas);
		vetorCestaAVG = calculaCestaAVG(vetorPontosRecebidos,vetorPontosMarcados,vetorCestaAVG,n);
		vetorVitoria = verificaEmpate(vetorVitoria,vetorCestaAVG,vetorPontosMarcados,n);
		int[] resp = new int [n];
		resp = ordenaVitoria(vetorVitoria,n);
		
		for (int i=n-1;i>=0;i--) {
			System.out.println(resp[i]+1);
		}
		
	}
	public static int[] verificaEmpate(int[] vetorVitoria,double[] vetorCestaAVG,int[] vetorPontosMarcados,int n) { //complexidade ciclomática: 14
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if(vetorVitoria[i] == vetorVitoria[j] && i != j) {
					if(vetorCestaAVG[i]>vetorCestaAVG[j]) vetorVitoria[i]+=1; //adiciona 1 ponto para desempatar
					if(vetorCestaAVG[i]<vetorCestaAVG[j]) vetorVitoria[j]+=1;
					if(vetorCestaAVG[i]==vetorCestaAVG[j] && i != j) {
						if(vetorPontosMarcados[i]>vetorPontosMarcados[j]) vetorVitoria[i]+=1;
						if(vetorPontosMarcados[i]<vetorPontosMarcados[j]) vetorVitoria[j]+=1;
						if(vetorPontosMarcados[i]==vetorPontosMarcados[j] && i != j) {
							if(i>j) vetorVitoria[j] +=1;
							if(j>i) vetorVitoria[i] +=1;
						}
					}
				}
			}
		}
		return vetorVitoria;
	}
	public static int[] ordenaVitoria(int [] vetorVitoria, int n) {//complexidade ciclomática: 5
		int [] vetorAUX = new int [n];
		int [] vetorFIM = new int [n];
		
		for (int i=0;i<n;i++) {
			vetorAUX[i]=vetorVitoria[i];
		}
		
		Arrays.sort(vetorAUX);
		for(int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if (vetorAUX[i]==vetorVitoria[j])
					vetorFIM[i] = j;
			}
		}
		
		return vetorFIM;
		
	}
	public static double[] calculaCestaAVG (int [] vetorPontosRecebidos,int [] vetorPontosMarcados, double [] vetorCestaAVG,int n) {//complexidade ciclomática: 3
		for (int i=0;i<n;i++) {
			if(vetorPontosRecebidos[i]==0) vetorCestaAVG[i] = vetorPontosMarcados[i];
			else {
				vetorCestaAVG[i] = vetorPontosMarcados[i]/vetorPontosRecebidos[i];
			}
		}
		return vetorCestaAVG;
	}
	
	public static int[] calculaPontosTotais(int[][] matrizEntrada,int[]vetorVitoria,int linhas) {//complexidade ciclomática: 4
		for (int i=0;i<linhas;i++) {
			if (matrizEntrada[i][1] > matrizEntrada[i][3]) {
				vetorVitoria[matrizEntrada[i][0]-1] += 2;
				vetorVitoria[matrizEntrada[i][2]-1] += 1;
			}
			if (matrizEntrada[i][1] < matrizEntrada[i][3]) {
				vetorVitoria[matrizEntrada[i][0]-1] += 1;
				vetorVitoria[matrizEntrada[i][2]-1] += 2;	
			}
		}
		return vetorVitoria;
	}
	
	public static int[] calculaPontosMarcados(int[][] matrizEntrada,int [] vetorPontosMarcados,int linhas) { //complexidade ciclomática: 4
		for (int i=0;i<linhas;i++) {
			for (int j=0;j<4;j++) {
				if (j==0 || j==2) {
					vetorPontosMarcados[matrizEntrada[i][j]-1] += matrizEntrada[i][j+1];
				}
			}
		}
		return vetorPontosMarcados;
	}
	
	public static int[] calculaPontosRecebidos(int[][] matrizEntrada,int [] vetorPontosRecebidos,int linhas) { //complexidade ciclomática: 5
		for (int i=0;i<linhas;i++) {
			for (int j=0;j<4;j++) {
				if (j==0) {
					vetorPontosRecebidos[matrizEntrada[i][j]-1] += matrizEntrada[i][j+3];
				}
				if (j==2) {
					vetorPontosRecebidos[matrizEntrada[i][j]-1] += matrizEntrada[i][j-1];
				}
			}
		}
		return vetorPontosRecebidos;
	}
}
