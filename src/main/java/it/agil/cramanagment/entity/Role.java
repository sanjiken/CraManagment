package it.agil.cramanagment.entity;

public enum Role {

	D("Directeur", RoleType.A), R("Rh", RoleType.A), COM("Commercial", RoleType.C), CON("Consultant", RoleType.C);

	private final String name;
	private final RoleType roleType;

	private Role(final String name, final RoleType roleType) {
		this.name = name;
		this.roleType = roleType;
	}

	public String getName() {
		return name;
	}

	public RoleType getRoleType() {
		return roleType;
	}

}
