package phones.interfaces;

public interface Sms extends Call{
    boolean sendSMS(String message);
}
