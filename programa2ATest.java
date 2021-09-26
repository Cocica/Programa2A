package programa2A;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class programa2ATest {
	@Test
	public void TestcalculaPontosRecebidos() {
		programa2A teste = new programa2A();
		int [][] matrizEntrada = new int [][] {
			{1,100,2,99},
			{2,159,3,150},
			{3,100,1,119}
		};
		int [] respEsperada = new int[] {199,250,278};
		int [] vetorPontosRecebidos = new int [3];
		
		vetorPontosRecebidos = teste.calculaPontosRecebidos(matrizEntrada, vetorPontosRecebidos, 3);
		
		assertArrayEquals(respEsperada,vetorPontosRecebidos);

	}
	
	@Test
	public void TestcalculaPontosMarcados () {
		programa2A teste = new programa2A();
		int [][] matrizEntrada = new int [][] {
			{1,100,2,99},
			{2,159,3,150},
			{3,100,1,119}
		};
		int [] respEsperada = new int[] {219,258,250};
		int [] vetorPontosMarcados = new int [3];
		
		vetorPontosMarcados = teste.calculaPontosMarcados(matrizEntrada,vetorPontosMarcados,3);
		
		assertArrayEquals(respEsperada,vetorPontosMarcados);
	}
	
	@Test
	public void TestcalculaPontosTotais() {
		programa2A teste = new programa2A();
		int [][] matrizEntrada = new int [][] {
			{1,100,2,99},
			{2,159,3,150},
			{3,100,1,119}
		};
		int [] respEsperada = new int[] {4,3,2};
		int [] vetorVitoria = new int [3];
		
		vetorVitoria = teste.calculaPontosTotais(matrizEntrada,vetorVitoria,3);
		

		assertArrayEquals(respEsperada,vetorVitoria);
		
		
	}
	@Test
	public void TestcalculaCestaAVG() {
		programa2A teste = new programa2A();
		double [] respEsperada = new double[] {1.0,1.0,0};
		double [] vetorCestaAVG = new double [3];
		int [] vetorPontosMarcados = new int [] {219,258,250};
		int [] vetorPontosRecebidos = new int [] {199,250,278};
		
		vetorCestaAVG = teste.calculaCestaAVG(vetorPontosRecebidos,vetorPontosMarcados,vetorCestaAVG,3);
		
		assertArrayEquals(respEsperada,vetorCestaAVG);
		
	}
	
	@Test
	public void TestordenaVitoria() {
		programa2A teste = new programa2A();
		int [] vetorVitoria = new int [] {10,7,9,8,6}; //pontos de cada posição
		int [] respEsperada = new int [] {4,1,3,2,0};
		vetorVitoria = teste.ordenaVitoria(vetorVitoria,5);
		assertArrayEquals(vetorVitoria,respEsperada);
	}
	
	@Test
	public void TestverificaEmpate() {
		programa2A teste = new programa2A();
		int [] vetorVitoria = new int [] {4,4,0};
		int [] vetorPontosMarcados = new int [] {219,200,50};
		double [] vetorCestaAVG = new double [] {2,1,0};
		int [] respEsperada = new int [] {5,4,0};
		
		vetorVitoria = teste.verificaEmpate(vetorVitoria, vetorCestaAVG, vetorPontosMarcados, 3);
		assertArrayEquals(vetorVitoria,respEsperada);
	}
	
	@Test
	public void TestverificaEmpate2() {
		programa2A teste = new programa2A();
		int [] vetorVitoria = new int [] {4,4,0};
		int [] vetorPontosMarcados = new int [] {200,201,50};
		double [] vetorCestaAVG = new double [] {1,1,0};
		int [] respEsperada = new int [] {4,5,0};
		
		vetorVitoria = teste.verificaEmpate(vetorVitoria, vetorCestaAVG, vetorPontosMarcados, 3);
		assertArrayEquals(vetorVitoria,respEsperada);
	}
	
	@Test
	public void TestverificaEmpate3() {
		programa2A teste = new programa2A();
		int [] vetorVitoria = new int [] {4,4,0};
		int [] vetorPontosMarcados = new int [] {200,200,50};
		double [] vetorCestaAVG = new double [] {1,1,0};
		int [] respEsperada = new int [] {5,4,0};
		
		vetorVitoria = teste.verificaEmpate(vetorVitoria, vetorCestaAVG, vetorPontosMarcados, 3);
		assertArrayEquals(vetorVitoria,respEsperada);
	}
}



