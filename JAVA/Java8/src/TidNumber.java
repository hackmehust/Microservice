
public class TidNumber {
    private String custId;
    private String custName;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public String toString() {
        return "TidNumber{" +
                "custId='" + custId + '\'' +
                ", custName='" + custName + '\'' +
                '}';
    }
}
