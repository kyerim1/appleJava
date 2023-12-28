package java_interface;

public class hydra implements unit{
	
	private int hp;
	private int atk;
	private String damageType;
	
	public hydra() {
		this.hp=80;
		this.atk=10;
		this.damageType="폭발";
	}
	
	public void attack() {
		System.out.println("히드라 공격");
	}
	public void move() {
		System.out.println("히드라 이동");
	}
	public void dead() {
		System.out.println("히드라 사망...");
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




