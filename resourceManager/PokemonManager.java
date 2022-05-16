package resourceManager;
import monster.Monster;

//Monsterクラスのインスタンスとしての具体的なポケモンを設定する
public class PokemonManager {
	//---------------field-------------------------
	//ポケモン固有の性能
	private Monster pikachu = new Monster("ピカチュウ",60,30,30);
	private Monster fushigidane = new Monster("フシギダネ",70,20,20);
	private Monster zenigame = new Monster("ゼニガメ",50,25,25);
	private Monster hitokage = new Monster("ヒトカゲ",70,35,10);
	
	//ポケモンのリスト
	private Monster[] guide = {pikachu, fushigidane, zenigame, hitokage};
	
	
	//---------------Method-------------------------
	
	//ポケモンの情報一覧を返す
	public void pokeGuide(){
		System.out.println("【ポケモン一覧】");
		System.out.println("---------------------");
		for(int i=0; i< guide.length; i++){
			System.out.println((i+1) +": " + guide[i].getName());
		}
		System.out.println("---------------------");
	}
	
	//getter
	//引数に応じたポケモンを返す
	public Monster getPokemon(int pokeNum){
		return guide[pokeNum];
	}
	
	//ポケモン図鑑の長さを返す
	public int guideLength(){
		return guide.length;
	}
	
	
}
