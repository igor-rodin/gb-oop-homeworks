package phones.impl.mobile;

import phones.interfaces.Bluetooth;
import phones.interfaces.GPS;
import phones.interfaces.Internet;

import java.io.File;
import java.util.List;

public class ApplePhone extends  AbstractMobilePhone implements Internet, Bluetooth {
    private final GPS gpsModule;

    public ApplePhone(GPS gpsModule){
        this.gpsModule = gpsModule;
    }
    @Override
    public void sendFiles(String... fileNames) {
        System.out.println("Sending files by bluetooth (iPhone)");
    }

    @Override
    public List<File> getFiles() {
        System.out.println("Getting files by bluetooth (iPhone)");
        return null;
    }

    @Override
    public void makeCall() {
        System.out.println("Make call from iPhone");
    }


    public String getPosition() {
        return  gpsModule.getPosition();
    }

    public boolean sendPosition(String position) {
        return gpsModule.sendPosition(position);
    }

    @Override
    public boolean sendEmail(String message) {
        System.out.println(message);
        return true;
    }

    @Override
    public boolean sendSMS(String message) {
        System.out.println(message);
        return true;
    }
}
