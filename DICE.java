package itp11;

public class DICE {
	int top; //1
	int S; //2
	int E; //3
	int W; //4
	int N; //5
	int bottom; //6
	int tmp; //代入用	
	
	public DICE(int s1, int s2, int s3, int s4, int s5, int s6){
		top = s1;
		S = s2;
		E = s3;
		W = s4;
		N = s5;
		bottom = s6;
	}
	
	public void turnE() {
		tmp = top;
		top = W;
		W = bottom;
		bottom = E;
		E = tmp;
	}
	
	public void turnN() {
		tmp = top;
		top = S;
		S = bottom;
		bottom = N;
		N = tmp;
	}
	
	
	public void turnS() {
		tmp = top;
		top = N;
		N = bottom;
		bottom = S;
		S = tmp;
	}
	
	public void turnW() {
		tmp = top;
		top = E;
		E = bottom;
		bottom = W;
		W = tmp;
	}
	
	public void rotateright() {
		tmp = S;
		S = W;
		W = N;
		N = E;
		E = tmp;
	}
}
