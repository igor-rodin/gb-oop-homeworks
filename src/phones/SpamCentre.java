package phones;

import phones.interfaces.Call;
import phones.interfaces.Sms;

import java.util.List;

public class SpamCentre {
     void callAll(List<Call> phones){
        for (Call phone : phones) {
            phone.makeCall();
        }
    }

    void  smsAll(List<Sms> phones){
        for (Sms phone : phones) {
            phone.sendSMS(String.format("SMS from %s", phone.getClass().getSimpleName()));
        }
    }
}
