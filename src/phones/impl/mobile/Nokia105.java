package phones.impl.mobile;

public class Nokia105 extends  AbstractMobilePhone{
    @Override
    public void makeCall() {
        System.out.println("Call from Nokia105");
    }

    @Override
    public boolean sendSMS(String message) {
        System.out.println(message);
        return true;
    }
}
