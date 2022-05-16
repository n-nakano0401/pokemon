package MainTask;
import java.util.*;
import monster.Monster;
import monster.Trainer;

public class Battle {
	
	//フィールド
	private Random rand = new Random();
	
	private Trainer pl;
	private Trainer en;
	
	private String pl_name;
	private String en_name;
	private UImanager ui;
	
	private int pl_mon_HP = 0;
	private int en_mon_HP = 0;
	private int first = 0;//先手をどちらがとるか判定
	
	//コンストラクタ
	public Battle(){}
	
	public Battle(Trainer pl,Trainer en){
		this.pl = pl;
		this.en = en;
	}
	
	//戦闘時のフローについては全部ここに書く
	public boolean battle(){
		//-----------------変数の設定-----------------
		//仕様上の処理
		//Battle battle = new Battle();
		Scanner sc = new Scanner(System.in);

		//プレイヤーとポケモンを参照(敵も味方も)
		pl_name = pl.getName();
		en_name = en.getName();
		Monster pl_mon = pl.getPokemon();
		Monster en_mon = en.getPokemon();
		
		//コマンドライン上の演出はuiで"すべて"管理する
		ui = new UImanager(pl_name, en_name, pl_mon.getName(),en_mon.getName());
		
		
		//------------------ここから処理-------------------
		//一番先頭にいるポケモンを出す(敵も味方も)
		setBattleHP(pl_mon.getHp(),en_mon.getHp());
		ui.battleEntry();

		//バトルループ
		while(pl_mon_HP>0){
			ui.battleVisual(pl_mon_HP, pl_mon.getHp(), en_mon_HP, en_mon.getHp());
			String menuchoice = sc.next();

			
			//選択
			if(menuchoice.matches("[+-]?\\d*(\\.\\d+)?")){
				//どちらが先手をとれるか判定する
				first = firstMoveSetter(pl_mon.getSpeed(),en_mon.getSpeed());

				if(menuchoice.equals("1")){
					if(first == 0){
						ui.attack(0,pl_mon.getPower());
						//技を選択し、ダメージの処理をする
						en_mon_HP = en_mon_HP - pl_mon.getPower();
					}else if(first == 1){
						enemyTactics(pl_mon.getName(),en_mon.getName(),en_mon.getPower());
					}
					
				}else if(menuchoice.equals("2")){
					ui.useItem();
					first = 0;
				}else{
					ui.tempMessage();
					first = 0;
				}
			}else{ui.inputException();}
			
			System.out.println("");
			//このとき敵HPが0になったら戦闘終了である
			int check1 = winCheck(pl_mon.getName(),en_mon.getName());
			if(check1 == 0){
				return false;
			}else if(check1 == 1){
				return true;
			}
			//敵のターン
			if(first == 1){
				ui.attack(0,pl_mon.getPower());
				//技を選択し、ダメージの処理をする
				en_mon_HP = en_mon_HP - pl_mon.getPower();
			}else if(first == 0){
				enemyTactics(pl_mon.getName(),en_mon.getName(),en_mon.getPower());
			}
			//このとき味方HPが0になったら戦闘終了である
			int check2 = winCheck(pl_mon.getName(),en_mon.getName());
			if(check2 == 0){
				return false;
			}else if(check2 == 1){
				return true;
			}
			System.out.println("");
		}
		return true;
	}
	
	//バトルで使用するHPの設定
	public void setBattleHP(int plHP, int enHP){
		pl_mon_HP = plHP;
		en_mon_HP = enHP;
	}
	
	//終了処理
	public int winCheck(String pl_mon, String en_mon){
		if(pl_mon_HP <= 0){
			ui.loseMessage();
			return 0;
		}else if(en_mon_HP <= 0){
			ui.winMessage();
			return 1;
		}else{
			return 2;
		}
	}
	
	//敵の思考ルーチン
	public void enemyTactics(String pl_mon, String en_mon, int enPower){
		ui.attack(1,enPower);
		pl_mon_HP = pl_mon_HP - enPower;
	}
	
	//先手をとるほうを決定する処理
	public int firstMoveSetter(int pl_monS, int en_monS){
		if(pl_monS > en_monS){
			return 0;
		}else if(pl_monS < en_monS){
			return 1;
		}else{
			return rand.nextInt(2);
		}
		
	}
}
