package pojos;
public class EmployeesExpectedPojo {
    /*
    {
    "status": "success",
    "data": {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}
     */
    private String status;
    private Data data;
    private String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public EmployeesExpectedPojo() {
    }
    public EmployeesExpectedPojo(String status, Data data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
    @Override
    public String toString() {
        return "EmployeesExpectedPojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}