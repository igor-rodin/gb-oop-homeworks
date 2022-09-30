package phones.impl;

import phones.interfaces.GPS;

public class AnotherProducerGPS implements GPS {
    public AnotherProducerGPS() {
        System.out.println("AnotherProducerGps");
    }

    @Override
    public String getPosition() {
        return "9866, 365";
    }

    @Override
    public boolean sendPosition(String position) {
        System.out.println("Position: 866, 365");
        return true;
    }
}
