package monster;
import java.util.*;
import resourceManager.PokemonManager;

//�|�P�����g���[�i�[��ݒ肷��
public class Trainer {
	//�t�B�[���h
	Random rand = new Random();
	PokemonManager pokemane = new PokemonManager();
	
	private String name;//�g���[�i�[�̖��O
	private String job;//�g���[�i�[�̐E��
	private String phrase;//�g���[�i�[�̏�����̃Z���t
	private Monster pokemon;//�g���[�i�[�̂Ă����|�P����
	
	private String[] random_name = {"�C�}�j�V", "�I�N�_", "�I�J�U�L", "�i�J�m", "�m����", "�}�G�_", "�}�c�E��"};
	private String[] random_job = {"�����イ�͂���", "�������傤", "�v���O���}�[", "�V�X�e���G���W�j�A", "�����ނ�", "���Ⴟ�傤", "����ɂ�"};
	private String[] random_phrase = {"���₵���I","�������傤�Ԃ�������I","�܂����`"};
	
	//�R���X�g���N�^
	public Trainer(String name, String job, String phrase, Monster pokemon){
		this.name = name;
		this.job = job;
		this.phrase = phrase;
		this.pokemon = pokemon;
	}
	
	//�g���[�i�[�𐶐����郁�\�b�h
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
