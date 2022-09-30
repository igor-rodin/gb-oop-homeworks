package phones;

import phones.impl.AnotherProducerGPS;
import phones.impl.SomeProducerGps;
import phones.impl.fax.BrotherFax_2940;
import phones.impl.landline.Alcatel_1500;
import phones.impl.mobile.ApplePhone;
import phones.impl.mobile.Nokia105;
import phones.impl.mobile.PhilipsE590;
import phones.interfaces.Call;
import phones.interfaces.GPS;
import phones.interfaces.Sms;

import java.util.List;

public class Main {
    public static void main(String... args) {
        GPS gpsModule = new SomeProducerGps();
        GPS gpsModule2 = new AnotherProducerGPS();

        List<Call> phones = List.of(new ApplePhone(gpsModule), new Nokia105(), new PhilipsE590(), new Alcatel_1500(), new BrotherFax_2940());
        List<Sms> smsListPhones = List.of(new ApplePhone(gpsModule2), new Nokia105(), new PhilipsE590());

        SpamCentre spamCentre = new SpamCentre();
        spamCentre.callAll(phones);
        spamCentre.smsAll(smsListPhones);
    }
}
