package phones.impl.landline;

public class Alcatel_1500 extends AbstractLandLinePhone{
    @Override
    public void makeCall() {
        System.out.printf("Call from landline %s\n", this.getClass().getSimpleName());
    }
}
