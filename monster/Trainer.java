package monster;
import java.util.*;
import resourceManager.PokemonManager;

//ポケモントレーナーを設定する
public class Trainer {
	//フィールド
	Random rand = new Random();
	PokemonManager pokemane = new PokemonManager();
	
	private String name;//トレーナーの名前
	private String job;//トレーナーの職業
	private String phrase;//トレーナーの勝負後のセリフ
	private Monster pokemon;//トレーナーのてもちポケモン
	
	private String[] random_name = {"イマニシ", "オクダ", "オカザキ", "ナカノ", "ノムラ", "マエダ", "マツウラ"};
	private String[] random_job = {"うちゅうはかせ", "えいぎょう", "プログラマー", "システムエンジニア", "そうむか", "しゃちょう", "しゅにん"};
	private String[] random_phrase = {"くやしい！","あついしょうぶだったよ！","まけた～"};
	
	//コンストラクタ
	public Trainer(String name, String job, String phrase, Monster pokemon){
		this.name = name;
		this.job = job;
		this.phrase = phrase;
		this.pokemon = pokemon;
	}
	
	//トレーナーを生成するメソッド
	public Trainer randomTrainer(){
		String r_name = random_name[rand.nextInt(random_name.length)];
		String r_job = random_job[rand.nextInt(random_job.length)];
		String r_phrase = random_phrase[rand.nextInt(random_phrase.length)];
		Monster r_pokemon = pokemane.getPokemon(rand.nextInt(pokemane.guideLength()));
		
		Trainer trainer = new Trainer(r_name,r_job,r_phrase,r_pokemon);
		return trainer;
	}
	
	//getter
	public String getName(){
		return name;
	}

	public String getJob(){
		return job;
	}
	
	public String getPhrase(){
		return phrase;
	}
	
	public Monster getPokemon(){
		return pokemon;
	}
}
