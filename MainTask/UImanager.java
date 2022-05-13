package MainTask;
import java.util.*;

//����̃C�x���g�ŌJ��Ԃ��Ăяo�����e�L�X�g�Ȃǂ͂����Œ�`����
public class UImanager {
	//�葱���ɕK�v�ȗv�f
	private String justNext;
	private Scanner sc = new Scanner(System.in);

	//�e�L�X�g���Ŏg�����R���͗v�f
	private String pl_name;
	private String en_name;
	private String pl_mon;
	private String en_mon;
	
	//Battle�֘A�̃e�L�X�g���Ǘ�����
	public UImanager(String pl_name, String en_name, String pl_mon, String en_mon){
		this.pl_name = pl_name;
		this.en_name = en_name;
		this.pl_mon = pl_mon;
		this.en_mon = en_mon;
	}
	
	public void battleEntry(){
		System.out.println("�|�P�����g���[�i�[��"+ en_name +"�����傤�Ԃ��������Ă����I��(Enter�Ői�݂܂�)");
		justNext = sc.nextLine();

		System.out.println("�����Ă�"+ en_mon +"�����肾�����I��(Enter�Ői�݂܂�)");
		justNext = sc.nextLine();
		System.out.println("�����I"+ pl_mon +"�I��(Enter�Ői�݂܂�)");
		justNext = sc.nextLine();
	}
	
	public void battleVisual(int pl_HP, int pl_maxHP, int en_HP, int en_maxHP){
		System.out.println("| " + en_HP + "/" + en_maxHP +" |" +en_mon);
		System.out.println("");
		System.out.println(pl_mon +"| " + pl_HP + "/" + pl_maxHP +" |");
		
		System.out.println("-------------------");
		System.out.println(pl_mon + "�͂ǂ�����H(1~4�̐��������)");
		System.out.println("-------------------");
		System.out.println("1:�������� 2:�ǂ���");
		System.out.println("3:�|�P���� 4:�ɂ���");
		System.out.println("-------------------");
	}
		
	public void attack(int attacker, int damage){
		if(attacker == 0){
			System.out.println(pl_mon + "�̂��������I");
			System.out.println(en_mon + "��" + damage +"�̃_���[�W�I");
		}else if(attacker == 1){
			System.out.println(en_mon + "�̂��������I");
			System.out.println(pl_mon + "��" + damage +"�̃_���[�W�I");
		}
		
	}
	
	public void useItem(){
		System.out.println(pl_mon + "�͂ǂ����ɂ͂����Ȃ����������߂����I");	
	}
	
	public void tempMessage(){
		System.out.println("�����������Ƃ������͂ł��Ȃ��I");
	}
	
	public void inputException(){
		System.out.println("��������͂��Ă�������");
	}
	
	public void winMessage(){
		System.out.println(en_mon + "�͂����ꂽ�I��(Enter�Ői�݂܂�)");
		justNext = sc.nextLine();
		System.out.println(pl_name + "��" + en_name + "�ɂ������I��(Enter�Ői�݂܂�)");
		justNext = sc.nextLine();
		System.out.println("���ꂵ���������ɂȂ����I��(Enter�Ői�݂܂�)");
		justNext = sc.nextLine();
	}
	
	public void loseMessage(){
		System.out.println(pl_mon + "�͂����ꂽ�I��(Enter�Ői�݂܂�)");
		justNext = sc.nextLine();
		System.out.println(pl_name + "��" + en_name + "�ɂ�Ԃꂽ��(Enter�Ői�݂܂�)");
		justNext = sc.nextLine();
		System.out.println("�߂̂܂����܂�����ɂȂ�����(Enter�Ői�݂܂�)");
		justNext = sc.nextLine();
	}
	
}
