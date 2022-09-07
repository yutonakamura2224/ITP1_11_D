package itp11;

import java.io.IOException;
import java.util.Scanner;

public class ITP1_11_D {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		//サイコロの数
		int number = scan.nextInt();
		
		DICE[] dicelist = new DICE [number];
		
		//number個分サイコロ作成
		for(int i = 0; i < number; i++) {
			dicelist[i] = new DICE(scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt(),scan.nextInt());
		}
		scan.close();
		
		for(int i = 0; i < number; i++) {
			for(int j = (i+1); j < number; j++) {
				if(rotate(dicelist[i],dicelist[j])){
					System.out.println("No");
					return;
				}
			}
		}
		
		System.out.println("Yes");
		
	}
	
	
	/*
	 *サイコロを回転させる 
	 */
	public static boolean rotate (DICE dice1,DICE dice2) {
		boolean check = false;
		
		//回転させるサイコロを作成
		DICE dice3 = new DICE(dice2.top, dice2.S, dice2.E, dice2.W, dice2.N, dice2.bottom);
		
		//上面そのまま、上面を軸として右回転で一致するか確認
		if(check(dice1, dice3)) {
			check = true;
			return check;
		}
		
		//上面を問題中の4になるようにサイコロを転がす
		dice3.turnE();
		if(check(dice1, dice3)) {
			check = true;
			return check;
		}
		
		//上面を問題中の6になるようにサイコロを転がす
		dice3.turnE();
		if(check(dice1, dice3)) {
			check = true;
			return check;
		}
		
		//上面を問題中の6になるようにサイコロを転がす
		dice3.turnE();
		if(check(dice1, dice3)) {
			check = true;
			return check;
		}
		
		//上面を問題中の5になるようにサイコロを転がす
		dice3.turnS();
		if(check(dice1, dice3)) {
			check = true;
			return check;
		}
		
		//上面を問題中の2になるようにサイコロを転がす
		dice3.turnS();
		dice3.turnS();
		if(check(dice1, dice3)) {
			check = true;
			return check;
		}
		//ここまで返り値無い場合false、対象の2個のサイコロは一致しない
		return check;
	}
	
	/*
	 * 上面固定で右に回転させ、correspondingで一致するか判断
	 */
	public static boolean check(DICE dice1, DICE dice2) {
		boolean check = false;
		for(int i = 0; i < 4; i++) {
			dice2.rotateright();
			if(corresponding(dice1, dice2)) {
				check = corresponding(dice1, dice2);
				return check;
			}
		}
		
		return check;
	}
	
	/*
	 * 一致するかしないか判断
	 */
	public static boolean corresponding(DICE dice1, DICE dice2) {
		boolean check = false;
		if (dice1.top == dice2.top &&
				dice1.bottom == dice2.bottom &&
				dice1.E == dice2.E &&
				dice1.N == dice2.N &&
				dice1.S == dice2.S &&
				dice1.W == dice2.W) {
				check = true;
				return check;
			}
		return check;
	}

}
