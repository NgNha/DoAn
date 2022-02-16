package ConnectSQL;

public class KhachHang 
{

	private int id;
	private String Name;
	private String PhoneNumber;
	private String IDHOUSE;
	private String TimeRent;
	
	public KhachHang() {	
	}
	public KhachHang(int id,String Name,String PhoneNumber,String IDHOUSE,String TimeRent) {
		this.id=id;
		this.Name=Name;
		this.PhoneNumber=PhoneNumber;
		this.IDHOUSE=IDHOUSE;
		this.TimeRent=TimeRent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getIDHOUSE() {
		return IDHOUSE;
	}
	public void setIDHOUSE(String iDHOUSE) {
		IDHOUSE = iDHOUSE;
	}
	public String getTimeRent() {
		return TimeRent;
	}
	public void setTimeRent(String timeRent) {
		TimeRent = timeRent;
	}
	@Override
	public String toString() {
		return "KhachHang [id=" + id + ", Name=" + Name + ", PhoneNumber=" + PhoneNumber + ", IDHOUSE=" + IDHOUSE
				+ ", TimeRent=" + TimeRent + "]";
	}
	
}
