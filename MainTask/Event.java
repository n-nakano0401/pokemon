package MainTask;
import resourceManager.PokemonManager;
import monster.Trainer;

//�o�g���O�̊�{�I�ȃC�x���g�i�|�P�����̑I���Ȃǁj���s��
public class Event {
	
	
	public static void main(String[] args){
		
		PokemonManager pokemane = new PokemonManager();
		int count = 0; //�A����
		
		Trainer pl = new Trainer("�T�g�V","�|�P�����g���[�i�[","aaa",pokemane.getPokemon(0));
		
		System.out.println("�����̓|�P�����o�g���A���[�i�I");
		System.out.println("�N�͂�����3�A���ł��邩�ȁH");
		System.out.println("���A���������A�o�g���Ŏg�������|�P������I��ł���邩�ȁH");
		System.out.println("");
		pokemane.pokeGuide();
		System.out.println("");
		System.out.println("���ꂶ�Ⴀ���������n�߂悤�I���b�c�o�g���I");
		System.out.println("");
		

		for(int i=0; i<3; i++){
			//�o�g�����Ăяo���Ƃ��Ƀo�g���ɂ������g���[�i�[����͂���
			Trainer en = pl.randomTrainer();
			Battle battle = new Battle(pl,en);
			
			boolean result = battle.battle();//�o�g���̏����i�������ۂ��̌��ʂ�Ԃ��j
			
			//�킢�̏���
			if(result){
				count++;
				System.out.println("�������I�����" +count+"�A�����ˁI");
			}else if(!result){
				System.out.println("����˂�I�����������ˁI");
				System.out.println("�ł��܂����킵�ĂˁI");
				break;
			}
			
			//�������ɂ�锻��
			if(count < 3){
				System.out.println("���Ⴀ���̂����Ă͂ǂ����ȁH");
				System.out.println("");
			}else if(count == 3){
				System.out.println("�������������I���񂢂񂽂�����������I");
				System.out.println("���͂����Ƃ悭�Ȃ邩��A�܂����傤���񂵂ĂˁI");
			}
			
		}
		
		
	}
}
