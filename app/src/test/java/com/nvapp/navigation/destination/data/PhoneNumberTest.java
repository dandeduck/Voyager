package com.nvapp.navigation.destination.data;

import android.net.Uri;
import android.telephony.PhoneNumberUtils;

import com.navapp.navigation.destination.data.PhoneNumber;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class PhoneNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void create_tooShortNumber_throwsException() {
        new PhoneNumber("12345");
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_tooLongNumber_throwsException() {
        new PhoneNumber("1234567890123456");
    }

    @Test
    public void create_normal_returnsSameNumberWithTel() {
        final String NUMBER = "123456";
        PhoneNumber phoneNumber = new PhoneNumber(NUMBER);

        assertEquals(Uri.parse("tel:"+NUMBER), phoneNumber.getCallUri());
    }

    @Test
    public void create_normalWithLetters_returnsNormalizedNumberWithTel() {
        final String NUMBER = "123456TEST";
        PhoneNumber phoneNumber = new PhoneNumber(NUMBER);

        assertEquals(Uri.parse(String.format("tel:%s%s", NUMBER.substring(0,6), "8378")), phoneNumber.getCallUri());
    }
}
