package MainTask;
import resourceManager.PokemonManager;
import monster.Trainer;

//バトル前の基本的なイベント（ポケモンの選択など）を行う
public class Event {
	
	
	public static void main(String[] args){
		
		PokemonManager pokemane = new PokemonManager();
		int count = 0; //連勝数
		
		Trainer pl = new Trainer("サトシ","ポケモントレーナー","aaa",pokemane.getPokemon(0));
		
		System.out.println("ここはポケモンバトルアリーナ！");
		System.out.println("君はここで3連勝できるかな？");
		System.out.println("あ、そうそう、バトルで使いたいポケモンを選んでくれるかな？");
		System.out.println("");
		pokemane.pokeGuide();
		System.out.println("");
		System.out.println("それじゃあさっそく始めよう！レッツバトル！");
		System.out.println("");
		

		for(int i=0; i<3; i++){
			//バトルを呼び出すときにバトルにかかわるトレーナーを入力する
			Trainer en = pl.randomTrainer();
			Battle battle = new Battle(pl,en);
			
			boolean result = battle.battle();//バトルの処理（勝利か否かの結果を返す）
			
			//戦いの処理
			if(result){
				count++;
				System.out.println("すごい！これで" +count+"連勝だね！");
			}else if(!result){
				System.out.println("ざんねん！おしかったね！");
				System.out.println("でもまた挑戦してね！");
				break;
			}
			
			//勝利数による判定
			if(count < 3){
				System.out.println("じゃあつぎのあいてはどうかな？");
				System.out.println("");
			}else if(count == 3){
				System.out.println("すごいすごい！ぜんいんたおしちゃった！");
				System.out.println("つぎはもっとつよくなるから、またちょうせんしてね！");
			}
			
		}
		
		
	}
}
