package resourceManager;
import monster.Monster;

//Monster�N���X�̃C���X�^���X�Ƃ��Ă̋�̓I�ȃ|�P������ݒ肷��
public class PokemonManager {
	//---------------field-------------------------
	//�|�P�����ŗL�̐��\
	private Monster pikachu = new Monster("�s�J�`���E",60,30,30);
	private Monster fushigidane = new Monster("�t�V�M�_�l",70,20,20);
	private Monster zenigame = new Monster("�[�j�K��",50,25,25);
	private Monster hitokage = new Monster("�q�g�J�Q",70,35,10);
	
	//�|�P�����̃��X�g
	private Monster[] guide = {pikachu, fushigidane, zenigame, hitokage};
	
	
	//---------------Method-------------------------
	
	//�|�P�����̏��ꗗ��Ԃ�
	public void pokeGuide(){
		System.out.println("�y�|�P�����ꗗ�z");
		System.out.println("---------------------");
		for(int i=0; i< guide.length; i++){
			System.out.println((i+1) +": " + guide[i].getName());
		}
		System.out.println("---------------------");
	}
	
	//getter
	//�����ɉ������|�P������Ԃ�
	public Monster getPokemon(int pokeNum){
		return guide[pokeNum];
	}
	
	//�|�P�����}�ӂ̒�����Ԃ�
	public int guideLength(){
		return guide.length;
	}
	
	
}
