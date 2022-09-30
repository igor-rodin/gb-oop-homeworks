package phones.impl.mobile;

import phones.interfaces.Bluetooth;

import java.io.File;
import java.util.List;

public class PhilipsE590 extends AbstractMobilePhone implements Bluetooth {
    @Override
    public void sendFiles(String... fileNames) {
        System.out.println("Sending files by bluetooth (Philips E590)");
    }

    @Override
    public List<File> getFiles() {
        System.out.println("Getting files by bluetooth (Philips E590)");
        return null;
    }

    @Override
    public void makeCall() {
        System.out.println("Make call from mobile Philips");
    }

    @Override
    public boolean sendSMS(String message) {
        System.out.println(message);
        return true;
    }
}
