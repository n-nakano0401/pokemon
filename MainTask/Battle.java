package MainTask;
import java.util.*;
import monster.Monster;

public class Battle {
	private Random rand = new Random();
	
	private String pl_name = "�܂���";
	private String en_name = "���܂ɂ�";
	private UImanager ui;
	
	private int pl_mon_HP = 0;
	private int en_mon_HP = 0;
	private int first = 0;//�����ǂ��炪�Ƃ邩����
	
	//�퓬���̃t���[�ɂ��Ă͑S�������ɏ���
	public static void main(String[] args){
		//-----------------�ϐ��̐ݒ�-----------------
		//�d�l��̏���
		Battle battle = new Battle();
		Scanner sc = new Scanner(System.in);

		//�v���C���[�̃|�P�������Q��(�G��������)
		Monster pl_mon = new Monster("�s�J�`���E",60,15,30);
		Monster en_mon = new Monster("�t�V�M�_�l",50,10,20);
		
		//�R�}���h���C����̉��o��ui��"���ׂ�"�Ǘ�����
		battle.ui = new UImanager(battle.pl_name, battle.en_name, pl_mon.getName(),en_mon.getName());
		
		
		//------------------�������珈��-------------------
		//��Ԑ擪�ɂ���|�P�������o��(�G��������)
		battle.setBattleHP(pl_mon.getHp(),en_mon.getHp());
		battle.ui.battleEntry();

		//�o�g�����[�v
		while(battle.pl_mon_HP>0){
			battle.ui.battleVisual(battle.pl_mon_HP, pl_mon.getHp(), battle.en_mon_HP, en_mon.getHp());
			String menuchoice = sc.next();

			
			//�I��
			if(menuchoice.matches("[+-]?\\d*(\\.\\d+)?")){
				//�ǂ��炪�����Ƃ�邩���肷��
				battle.first = battle.firstMoveSetter(pl_mon.getSpeed(),en_mon.getSpeed());

				if(menuchoice.equals("1")){
					if(battle.first == 0){
						battle.ui.attack(0,pl_mon.getPower());
						//�Z��I�����A�_���[�W�̏���������
						battle.en_mon_HP = battle.en_mon_HP - pl_mon.getPower();
					}else if(battle.first == 1){
						battle.enemyTactics(pl_mon.getName(),en_mon.getName(),en_mon.getPower());
					}
					
				}else if(menuchoice.equals("2")){
					battle.ui.useItem();
					battle.first = 0;
				}else{
					battle.ui.tempMessage();
					battle.first = 0;
				}
			}else{battle.ui.inputException();}
			
			System.out.println("");
			//���̂Ƃ��GHP��0�ɂȂ�����퓬�I���ł���
			battle.winCheck(pl_mon.getName(),en_mon.getName());
			//�G�̃^�[��
			if(battle.first == 1){
				battle.ui.attack(0,pl_mon.getPower());
				//�Z��I�����A�_���[�W�̏���������
				battle.en_mon_HP = battle.en_mon_HP - pl_mon.getPower();
			}else if(battle.first == 0){
				battle.enemyTactics(pl_mon.getName(),en_mon.getName(),en_mon.getPower());
			}
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
		if(pl_mon_HP <= 0){
			ui.loseMessage();
			System.exit(0);

		}else if(en_mon_HP <= 0){
			ui.winMessage();
			System.exit(0);
		}
	}
	
	//�G�̎v�l���[�`��
	public void enemyTactics(String pl_mon, String en_mon, int enPower){
		ui.attack(1,enPower);
		pl_mon_HP = pl_mon_HP - enPower;
	}
	
	//�����Ƃ�ق������肷�鏈��
	public int firstMoveSetter(int pl_monS, int en_monS){
		if(pl_monS > en_monS){
			return 0;
		}else if(pl_monS < en_monS){
			return 1;
		}else{
			return rand.nextInt(2);
		}
		
	}
}
