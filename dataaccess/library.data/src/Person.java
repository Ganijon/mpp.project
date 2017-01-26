
import java.io.Serializable;

public class Person implements Serializable{
	private String name, ssn;
	public Person(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
        
        @Override
        public String toString() {
            return "Name:" + name + " SSN:" + ssn;
        }
}
