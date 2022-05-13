package MainTask;
import java.util.*;

//特定のイベントで繰り返し呼び出されるテキストなどはここで定義する
public class UImanager {
	//手続きに必要な要素
	private String justNext;
	private Scanner sc = new Scanner(System.in);

	//テキスト内で使う自由入力要素
	private String pl_name;
	private String en_name;
	private String pl_mon;
	private String en_mon;
	
	//Battle関連のテキストを管理する
	public UImanager(String pl_name, String en_name, String pl_mon, String en_mon){
		this.pl_name = pl_name;
		this.en_name = en_name;
		this.pl_mon = pl_mon;
		this.en_mon = en_mon;
	}
	
	public void battleEntry(){
		System.out.println("ポケモントレーナーの"+ en_name +"がしょうぶをしかけてきた！▼(Enterで進みます)");
		justNext = sc.nextLine();

		System.out.println("あいては"+ en_mon +"をくりだした！▼(Enterで進みます)");
		justNext = sc.nextLine();
		System.out.println("いけ！"+ pl_mon +"！▼(Enterで進みます)");
		justNext = sc.nextLine();
	}
	
	public void battleVisual(int pl_HP, int pl_maxHP, int en_HP, int en_maxHP){
		System.out.println("| " + en_HP + "/" + en_maxHP +" |" +en_mon);
		System.out.println("");
		System.out.println(pl_mon +"| " + pl_HP + "/" + pl_maxHP +" |");
		
		System.out.println("-------------------");
		System.out.println(pl_mon + "はどうする？(1~4の数字を入力)");
		System.out.println("-------------------");
		System.out.println("1:たたかう 2:どうぐ");
		System.out.println("3:ポケモン 4:にげる");
		System.out.println("-------------------");
	}
		
	public void attack(int attacker, int damage){
		if(attacker == 0){
			System.out.println(pl_mon + "のこうげき！");
			System.out.println(en_mon + "に" + damage +"のダメージ！");
		}else if(attacker == 1){
			System.out.println(en_mon + "のこうげき！");
			System.out.println(pl_mon + "に" + damage +"のダメージ！");
		}
		
	}
	
	public void useItem(){
		System.out.println(pl_mon + "はどうぐにはたよらないいしをしめした！");	
	}
	
	public void tempMessage(){
		System.out.println("たたかうこといがいはできない！");
	}
	
	public void inputException(){
		System.out.println("数字を入力してください");
	}
	
	public void winMessage(){
		System.out.println(en_mon + "はたおれた！▼(Enterで進みます)");
		justNext = sc.nextLine();
		System.out.println(pl_name + "は" + en_name + "にかった！▼(Enterで進みます)");
		justNext = sc.nextLine();
		System.out.println("うれしいきもちになった！▼(Enterで進みます)");
		justNext = sc.nextLine();
	}
	
	public void loseMessage(){
		System.out.println(pl_mon + "はたおれた！▼(Enterで進みます)");
		justNext = sc.nextLine();
		System.out.println(pl_name + "は" + en_name + "にやぶれた▼(Enterで進みます)");
		justNext = sc.nextLine();
		System.out.println("めのまえがまっくらになった▼(Enterで進みます)");
		justNext = sc.nextLine();
	}
	
}
