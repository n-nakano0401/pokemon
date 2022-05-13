package monster;

public class Monster {
	//フィールド
	private String name;
	private int hp;
	private int power;
	private int speed;
	
	//コンストラクタ
	public Monster(){
		
	}
	
	public Monster(String name,int hp,int power ,int speed){
		this.name = name;
		this.hp = hp;
		this.power = power;
		this.speed = speed;
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
	
	public int getSpeed(){
		return speed;
	}
	
}
