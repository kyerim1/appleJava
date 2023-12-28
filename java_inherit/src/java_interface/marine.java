package java_interface;

public class marine implements unit{
	
	private int hp;
	private int atk;
	private String damageType;
	
	public marine() {
		this.hp=40;
		this.atk=6;
		this.damageType="일반";
	}

	@Override
	public void attack() {
		System.out.println("마린 공격 ");
	}
	@Override
	public void move() {
		System.out.println("마린 이동");
	}
	@Override
	public void dead() {
		System.out.println("마린 사망...");
	}
	
	
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public String getDamageType() {
		return damageType;
	}

	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}
	
	
}




