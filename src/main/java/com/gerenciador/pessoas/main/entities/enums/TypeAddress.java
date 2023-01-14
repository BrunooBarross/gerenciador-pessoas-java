package com.gerenciador.pessoas.main.entities.enums;

public enum TypeAddress {
	PRINCIPAL(0), SECUNDARIO(1);

	private int code;

	private TypeAddress(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TypeAddress valueOf(int code) {
		for (TypeAddress value : TypeAddress.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalide TypeAddress code");
	}
}
