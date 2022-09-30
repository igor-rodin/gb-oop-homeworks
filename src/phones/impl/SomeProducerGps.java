package phones.impl;

import phones.interfaces.GPS;

public class SomeProducerGps implements GPS {
    public SomeProducerGps() {
        System.out.println("SomeProducerGps");
    }

    @Override
    public String getPosition() {
        return "123. 345";
    }

    @Override
    public boolean sendPosition(String position) {
        System.out.println("Position: 123, 345");
        return true;
    }
}
