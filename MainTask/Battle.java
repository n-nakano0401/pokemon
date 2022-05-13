package MainTask;
import java.util.*;
import monster.Monster;
import monster.Trainer;

public class Battle {
	
	//�t�B�[���h
	private Random rand = new Random();
	
	private Trainer pl;
	private Trainer en;
	
	private String pl_name;
	private String en_name;
	private UImanager ui;
	
	private int pl_mon_HP = 0;
	private int en_mon_HP = 0;
	private int first = 0;//�����ǂ��炪�Ƃ邩����
	
	//�R���X�g���N�^
	public Battle(){}
	
	public Battle(Trainer pl,Trainer en){
		this.pl = pl;
		this.en = en;
	}
	
	//�퓬���̃t���[�ɂ��Ă͑S�������ɏ���
	public boolean battle(){
		//-----------------�ϐ��̐ݒ�-----------------
		//�d�l��̏���
		//Battle battle = new Battle();
		Scanner sc = new Scanner(System.in);

		//�v���C���[�ƃ|�P�������Q��(�G��������)
		pl_name = pl.getName();
		en_name = en.getName();
		Monster pl_mon = pl.getPokemon();
		Monster en_mon = en.getPokemon();
		
		//�R�}���h���C����̉��o��ui��"���ׂ�"�Ǘ�����
		ui = new UImanager(pl_name, en_name, pl_mon.getName(),en_mon.getName());
		
		
		//------------------�������珈��-------------------
		//��Ԑ擪�ɂ���|�P�������o��(�G��������)
		setBattleHP(pl_mon.getHp(),en_mon.getHp());
		ui.battleEntry();

		//�o�g�����[�v
		while(pl_mon_HP>0){
			ui.battleVisual(pl_mon_HP, pl_mon.getHp(), en_mon_HP, en_mon.getHp());
			String menuchoice = sc.next();

			
			//�I��
			if(menuchoice.matches("[+-]?\\d*(\\.\\d+)?")){
				//�ǂ��炪�����Ƃ�邩���肷��
				first = firstMoveSetter(pl_mon.getSpeed(),en_mon.getSpeed());

				if(menuchoice.equals("1")){
					if(first == 0){
						ui.attack(0,pl_mon.getPower());
						//�Z��I�����A�_���[�W�̏���������
						en_mon_HP = en_mon_HP - pl_mon.getPower();
					}else if(first == 1){
						enemyTactics(pl_mon.getName(),en_mon.getName(),en_mon.getPower());
					}
					
				}else if(menuchoice.equals("2")){
					ui.useItem();
					first = 0;
				}else{
					ui.tempMessage();
					first = 0;
				}
			}else{ui.inputException();}
			
			System.out.println("");
			//���̂Ƃ��GHP��0�ɂȂ�����퓬�I���ł���
			int check1 = winCheck(pl_mon.getName(),en_mon.getName());
			if(check1 == 0){
				return false;
			}else if(check1 == 1){
				return true;
			}
			//�G�̃^�[��
			if(first == 1){
				ui.attack(0,pl_mon.getPower());
				//�Z��I�����A�_���[�W�̏���������
				en_mon_HP = en_mon_HP - pl_mon.getPower();
			}else if(first == 0){
				enemyTactics(pl_mon.getName(),en_mon.getName(),en_mon.getPower());
			}
			//���̂Ƃ�����HP��0�ɂȂ�����퓬�I���ł���
			int check2 = winCheck(pl_mon.getName(),en_mon.getName());
			if(check2 == 0){
				return false;
			}else if(check2 == 1){
				return true;
			}
			System.out.println("");
		}
		return true;
	}
	
	//�o�g���Ŏg�p����HP�̐ݒ�
	public void setBattleHP(int plHP, int enHP){
		pl_mon_HP = plHP;
		en_mon_HP = enHP;
	}
	
	//�I������
	public int winCheck(String pl_mon, String en_mon){
		if(pl_mon_HP <= 0){
			ui.loseMessage();
			return 0;
		}else if(en_mon_HP <= 0){
			ui.winMessage();
			return 1;
		}else{
			return 2;
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
