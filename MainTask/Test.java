package MainTask;
import monster.Trainer;
import resourceManager.PokemonManager;

public class Test {
	public static void main(String[] args){
		PokemonManager pokemane = new PokemonManager();
		Trainer trainer = new Trainer("aaa","aaa","aaa",pokemane.getPokemon(0));
		System.out.println(trainer.getName()+trainer.getJob()+trainer.getPhrase());
		
		Battle battle = new Battle(trainer,trainer);
		boolean test = battle.battle();
	}
}

