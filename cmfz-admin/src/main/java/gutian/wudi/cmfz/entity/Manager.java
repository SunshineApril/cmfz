package gutian.wudi.cmfz.entity;

public class Manager {
    private String mgrId;
    private  String mgrName;
    private String mgrPwd;
    private String mgrSolt;
    private Integer mgrStatus;

    public String getMgrId() {
        return mgrId;
    }

    public String getMgrName() {
        return mgrName;
    }

    public String getMgrPwd() {
        return mgrPwd;
    }

    public String getMgrSolt() {
        return mgrSolt;
    }

    public Integer getMgrStatus() {
        return mgrStatus;
    }

    public void setMgrStatus(Integer mgrStatus) {
        this.mgrStatus = mgrStatus;
    }

    public void setMgrId(String mgrId) {
        this.mgrId = mgrId;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public void setMgrPwd(String mgrPwd) {
        this.mgrPwd = mgrPwd;
    }

    public void setMgrSolt(String mgrSolt) {
        this.mgrSolt = mgrSolt;
    }

    public Manager(String mgrId, String mgrName, String mgrPwd, String mgrSolt, Integer mgrStatus) {
        this.mgrId = mgrId;
        this.mgrName = mgrName;
        this.mgrPwd = mgrPwd;
        this.mgrSolt = mgrSolt;
        this.mgrStatus = mgrStatus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mgrId='" + mgrId + '\'' +
                ", mgrName='" + mgrName + '\'' +
                ", mgrPwd='" + mgrPwd + '\'' +
                ", mgrSolt='" + mgrSolt + '\'' +
                ", mgrStatus=" + mgrStatus +
                '}';
    }

    public Manager() {
    }


}
