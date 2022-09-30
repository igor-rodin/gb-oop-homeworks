package phones.impl.fax;

public class BrotherFax_2940 extends AbstractFaxMachine{
    @Override
    public void makeCall() {
        System.out.printf("Call from %s\n", this.getClass().getSimpleName());
    }

    @Override
    public boolean sendFax(String text) {
        System.out.printf("Send fax %s from %s\n", text, this.getClass().getSimpleName());
        return true;
    }
}
