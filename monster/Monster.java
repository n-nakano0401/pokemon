package monster;

public class Monster {
	//フィールド
	private String name;
	private int hp;
	private int power;
	
	//コンストラクタ
	public Monster(){
		
	}
	
	public Monster(String name,int hp,int power){
		this.name = name;
		this.hp = hp;
		this.power = power;
	}
	
	//メソッド
	public int attack(int power){
		return power;
	}
	
	//getter setter
	public String getName(){
		return name;
	}
	
	public int getHp(){
		return hp;
	}
	
	public int getPower(){
		return power;
	}
	
}
