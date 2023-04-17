package oophw2;

public class Location {
	int warehouseID;
	String warehouseName;
	String address;
	
	public Location(int warehouseID,String warehouseName,String address) {
		this.warehouseID=warehouseID;
		this.warehouseName=warehouseName;
		this.address=address;
	}
	public int getWarehouseID() {
		return warehouseID;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public String getAddress() {
		return address;
	}
}
