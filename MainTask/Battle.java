package MainTask;
import java.util.*;
import monster.Monster;

public class Battle {
	String pl_name = "まえだ";
	String en_name = "いまにし";
	String justNext;
	
	int pl_mon_HP = 0;
	int en_mon_HP = 0;
	
	//戦闘時のフローについては全部ここに書く
	public static void main(String[] args){
		Battle battle = new Battle();
		Scanner sc = new Scanner(System.in);

		//プレイヤーのポケモンを参照(敵も味方も)
		Monster pl_mon = new Monster("ピカチュウ",60,15);
		Monster en_mon = new Monster("フシギダネ",50,10);
		
		
		//口上
		System.out.println("ポケモントレーナーの"+ battle.en_name +"がしょうぶをしかけてきた！▼(Enterで進みます)");
		battle.justNext = sc.nextLine();
		
		//一番先頭にいるポケモンを出す(敵も味方も)
		battle.setBattleHP(pl_mon.getHp(),en_mon.getHp());
		
		System.out.println("あいては"+ en_mon.getName() +"をくりだした！▼(Enterで進みます)");
		battle.justNext = sc.nextLine();
		System.out.println("いけ！"+ pl_mon.getName() +"！▼(Enterで進みます)");
		battle.justNext = sc.nextLine();

		//バトルループ
		while(battle.pl_mon_HP>0){
			System.out.println("| " + battle.en_mon_HP + "/" + en_mon.getHp() +" |" +en_mon.getName());
			System.out.println("");
			System.out.println(pl_mon.getName() +"| " + battle.pl_mon_HP + "/" + pl_mon.getHp() +" |");
			
			System.out.println("-------------------");
			System.out.println(pl_mon.getName() + "はどうする？(1~4の数字を入力)");
			System.out.println("-------------------");
			System.out.println("1:たたかう 2:どうぐ");
			System.out.println("3:ポケモン 4:にげる");
			System.out.println("-------------------");

			String menuchoice = sc.next();
			
			//選択
			if(menuchoice.matches("[+-]?\\d*(\\.\\d+)?")){
				if(menuchoice.equals("1")){
					System.out.println(pl_mon.getName() + "のこうげき！");
					System.out.println(en_mon.getName() + "に" + pl_mon.getPower() +"のダメージ！");
					//技を選択し、ダメージの処理をする
					battle.en_mon_HP = battle.en_mon_HP - pl_mon.getPower();
				}else if(menuchoice.equals("2")){
					System.out.println(pl_mon.getName() + "はどうぐにはたよらないいしをしめした！");					
				}else{
					System.out.println("たたかうこといがいはできない！");
				}
				
				
				
			}else{System.out.println("数字を入力してください");}
			
			System.out.println("");
			//このとき敵HPが0になったら戦闘終了である
			battle.winCheck(pl_mon.getName(),en_mon.getName());
			//敵のターン
			battle.enemyTactics(pl_mon.getName(),en_mon.getName(),en_mon.getPower());
			//このとき味方HPが0になったら戦闘終了である
			battle.winCheck(pl_mon.getName(),en_mon.getName());
			System.out.println("");
		}
		
	}
	
	//バトルで使用するHPの設定
	public void setBattleHP(int plHP, int enHP){
		pl_mon_HP = plHP;
		en_mon_HP = enHP;
	}
	
	//終了処理
	public void winCheck(String pl_mon, String en_mon){
		Scanner sc = new Scanner(System.in);
		if(pl_mon_HP <= 0){
			System.out.println(pl_mon + "はたおれた！▼(Enterで進みます)");
			justNext = sc.nextLine();
			System.out.println(pl_name + "は" + en_name + "にやぶれた▼(Enterで進みます)");
			justNext = sc.nextLine();
			System.out.println("めのまえがまっくらになった▼(Enterで進みます)");
			justNext = sc.nextLine();
			System.exit(0);

		}else if(en_mon_HP <= 0){
			System.out.println(en_mon + "はたおれた！▼(Enterで進みます)");
			justNext = sc.nextLine();
			System.out.println(pl_name + "は" + en_name + "にかった！▼(Enterで進みます)");
			justNext = sc.nextLine();
			System.out.println("うれしいきもちになった！▼(Enterで進みます)");
			justNext = sc.nextLine();
			System.exit(0);
		}

	}
	
	//敵の思考ルーチン
	public void enemyTactics(String pl_mon, String en_mon, int enPower){
		System.out.println(en_mon + "のこうげき！");
		System.out.println(pl_mon + "に" + enPower +"のダメージ！");
		pl_mon_HP = pl_mon_HP - enPower;
	}
}
