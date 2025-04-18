package model;

import java.util.Map;

public class DrinkOrder {
	private String type;
	private String size;
	private String ice;
	private int price;
	
	//價格對照表
	private static final Map <String, Map<String, Integer>> priceTable = Map.of(
			"greenTea", Map.of("S", 30, "M", 50, "L", 50),
			"blackTea", Map.of("S" , 45, "M", 55, "L", 65),
			"milkTea", Map.of("S", 40, "M", 45, "L", 60));
	
	private static final Map<String, String> sizeTable = Map.of("S","小","M","中","L","大");
	private static final Map<String, String> iceTable = Map.of("YES","有加冰","NO","去冰");
	
	public DrinkOrder(String type, String size, String ice) {
		this.type = type;
		this.size = size;
		this.ice = ice;
		this.price = priceTable.get(type.toLowerCase()).get(size);
	}
	
	public String getInfo() {
		String sizeText = sizeTable.get(size.toUpperCase());
		String iceText = iceTable.get(ice.toUpperCase());
		return String.format("您點了一杯%s（%s，%s）價格為 %d 元",type, sizeText, iceText, price);
	}


	public String getType() {
		return type;
	}

	public String getSize() {
		return size;
	}

	public String getIce() {
		return ice;
	}

	public int getPrice() {
		return price;
	}
	
	
}