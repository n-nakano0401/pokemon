package MainTask;
import java.util.*;
import monster.Monster;

public class Battle {
	private String pl_name = "まえだ";
	private String en_name = "いまにし";
	private UImanager ui;
	
	private int pl_mon_HP = 0;
	private int en_mon_HP = 0;
	
	//戦闘時のフローについては全部ここに書く
	public static void main(String[] args){
		Battle battle = new Battle();
		Scanner sc = new Scanner(System.in);

		//プレイヤーのポケモンを参照(敵も味方も)
		Monster pl_mon = new Monster("ピカチュウ",60,15);
		Monster en_mon = new Monster("フシギダネ",50,10);
		
		//コマンドライン上の演出はuiで"すべて"管理する
		battle.ui = new UImanager(battle.pl_name, battle.en_name, pl_mon.getName(),en_mon.getName());
		
		//一番先頭にいるポケモンを出す(敵も味方も)
		battle.setBattleHP(pl_mon.getHp(),en_mon.getHp());
		battle.ui.battleEntry();

		//バトルループ
		while(battle.pl_mon_HP>0){
			battle.ui.battleVisual(battle.pl_mon_HP, pl_mon.getHp(), battle.en_mon_HP, en_mon.getHp());
			String menuchoice = sc.next();
			
			//選択
			if(menuchoice.matches("[+-]?\\d*(\\.\\d+)?")){
				if(menuchoice.equals("1")){
					battle.ui.attack(0,pl_mon.getPower());
					//技を選択し、ダメージの処理をする
					battle.en_mon_HP = battle.en_mon_HP - pl_mon.getPower();
				}else if(menuchoice.equals("2")){
					battle.ui.useItem();					
				}else{
					battle.ui.tempMessage();
				}
			}else{battle.ui.inputException();}
			
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
			ui.loseMessage();
			System.exit(0);

		}else if(en_mon_HP <= 0){
			ui.winMessage();
			System.exit(0);
		}
	}
	
	//敵の思考ルーチン
	public void enemyTactics(String pl_mon, String en_mon, int enPower){
		ui.attack(1,enPower);
		pl_mon_HP = pl_mon_HP - enPower;
	}
}
