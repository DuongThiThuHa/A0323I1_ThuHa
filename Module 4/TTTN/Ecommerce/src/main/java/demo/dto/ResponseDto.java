package demo.dto;

public class ResponseDto {
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseDto(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
