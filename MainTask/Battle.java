package MainTask;
import java.util.*;
import monster.Monster;

public class Battle {
	String pl_name = "�܂���";
	String en_name = "���܂ɂ�";
	String justNext;
	
	int pl_mon_HP = 0;
	int en_mon_HP = 0;
	
	//�퓬���̃t���[�ɂ��Ă͑S�������ɏ���
	public static void main(String[] args){
		Battle battle = new Battle();
		Scanner sc = new Scanner(System.in);

		//�v���C���[�̃|�P�������Q��(�G��������)
		Monster pl_mon = new Monster("�s�J�`���E",60,15);
		Monster en_mon = new Monster("�t�V�M�_�l",50,10);
		
		
		//����
		System.out.println("�|�P�����g���[�i�[��"+ battle.en_name +"�����傤�Ԃ��������Ă����I��(Enter�Ői�݂܂�)");
		battle.justNext = sc.nextLine();
		
		//��Ԑ擪�ɂ���|�P�������o��(�G��������)
		battle.setBattleHP(pl_mon.getHp(),en_mon.getHp());
		
		System.out.println("�����Ă�"+ en_mon.getName() +"�����肾�����I��(Enter�Ői�݂܂�)");
		battle.justNext = sc.nextLine();
		System.out.println("�����I"+ pl_mon.getName() +"�I��(Enter�Ői�݂܂�)");
		battle.justNext = sc.nextLine();

		//�o�g�����[�v
		while(battle.pl_mon_HP>0){
			System.out.println("| " + battle.en_mon_HP + "/" + en_mon.getHp() +" |" +en_mon.getName());
			System.out.println("");
			System.out.println(pl_mon.getName() +"| " + battle.pl_mon_HP + "/" + pl_mon.getHp() +" |");
			
			System.out.println("-------------------");
			System.out.println(pl_mon.getName() + "�͂ǂ�����H(1~4�̐��������)");
			System.out.println("-------------------");
			System.out.println("1:�������� 2:�ǂ���");
			System.out.println("3:�|�P���� 4:�ɂ���");
			System.out.println("-------------------");

			String menuchoice = sc.next();
			
			//�I��
			if(menuchoice.matches("[+-]?\\d*(\\.\\d+)?")){
				if(menuchoice.equals("1")){
					System.out.println(pl_mon.getName() + "�̂��������I");
					System.out.println(en_mon.getName() + "��" + pl_mon.getPower() +"�̃_���[�W�I");
					//�Z��I�����A�_���[�W�̏���������
					battle.en_mon_HP = battle.en_mon_HP - pl_mon.getPower();
				}else if(menuchoice.equals("2")){
					System.out.println(pl_mon.getName() + "�͂ǂ����ɂ͂����Ȃ����������߂����I");					
				}else{
					System.out.println("�����������Ƃ������͂ł��Ȃ��I");
				}
				
				
				
			}else{System.out.println("��������͂��Ă�������");}
			
			System.out.println("");
			//���̂Ƃ��GHP��0�ɂȂ�����퓬�I���ł���
			battle.winCheck(pl_mon.getName(),en_mon.getName());
			//�G�̃^�[��
			battle.enemyTactics(pl_mon.getName(),en_mon.getName(),en_mon.getPower());
			//���̂Ƃ�����HP��0�ɂȂ�����퓬�I���ł���
			battle.winCheck(pl_mon.getName(),en_mon.getName());
			System.out.println("");
		}
		
	}
	
	//�o�g���Ŏg�p����HP�̐ݒ�
	public void setBattleHP(int plHP, int enHP){
		pl_mon_HP = plHP;
		en_mon_HP = enHP;
	}
	
	//�I������
	public void winCheck(String pl_mon, String en_mon){
		Scanner sc = new Scanner(System.in);
		if(pl_mon_HP <= 0){
			System.out.println(pl_mon + "�͂����ꂽ�I��(Enter�Ői�݂܂�)");
			justNext = sc.nextLine();
			System.out.println(pl_name + "��" + en_name + "�ɂ�Ԃꂽ��(Enter�Ői�݂܂�)");
			justNext = sc.nextLine();
			System.out.println("�߂̂܂����܂�����ɂȂ�����(Enter�Ői�݂܂�)");
			justNext = sc.nextLine();
			System.exit(0);

		}else if(en_mon_HP <= 0){
			System.out.println(en_mon + "�͂����ꂽ�I��(Enter�Ői�݂܂�)");
			justNext = sc.nextLine();
			System.out.println(pl_name + "��" + en_name + "�ɂ������I��(Enter�Ői�݂܂�)");
			justNext = sc.nextLine();
			System.out.println("���ꂵ���������ɂȂ����I��(Enter�Ői�݂܂�)");
			justNext = sc.nextLine();
			System.exit(0);
		}

	}
	
	//�G�̎v�l���[�`��
	public void enemyTactics(String pl_mon, String en_mon, int enPower){
		System.out.println(en_mon + "�̂��������I");
		System.out.println(pl_mon + "��" + enPower +"�̃_���[�W�I");
		pl_mon_HP = pl_mon_HP - enPower;
	}
}
