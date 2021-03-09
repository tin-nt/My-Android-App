package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;


import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Random;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "AAA";
    private SecretKey secretKey;
    private Cipher cipher;
    private byte[] encrypted;
    private String decrypted;
    private byte[] IV = new byte[16];
    private SecureRandom random;

    private SecretKeySpec secretKeySpec;
    private IvParameterSpec ivParameterSpec;
    KeyGenerator keyGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StringBuilder builder = new StringBuilder();
        for (Provider provider : Security.getProviders()) {
            builder.append("provider: ")
                    .append(provider.getName())
                    .append(" ")
                    .append(provider.getVersion())
                    .append("(")
                    .append(provider.getInfo())
                    .append(")\n");
        }
        String providers = builder.toString();
        Log.d(TAG, providers);

//        for (Provider provider : Security.getProviders()) {
//            Log.i(TAG, "provider: " + provider.getName());
//            Set<Provider.Service> services = provider.getServices();
//            for (Provider.Service service : services) {
//                Log.i(TAG, "  algorithm: " + service.getAlgorithm());
//            }
//        }

        // java.util.Random
//        Random number = new Random(123L);
////...
//        for (int i = 0; i < 20; i++) {
//            // Generate another random integer in the range [0, 20]
//            System.out.println(number.nextInt(21));
//        }

        // java.security.SecureRandom
//        SecureRandom number = new SecureRandom();
//        // Generate 20 integers 0..20
//        for (int i = 0; i < 20; i++) {
//            System.out.println(number.nextInt(21));
//        }


        EditText editText = findViewById(R.id.editText_input_for_encryption);
        TextView textViewEncrypt = findViewById(R.id.textView_retrieve_encrypted);
        TextView textViewDecrypt = findViewById(R.id.textView_retrieve_decrypted);
        Button buttonEncrypt = findViewById(R.id.button_encrypt);
        Button buttonDecrypt = findViewById(R.id.button_decrypt);

        // getting instance
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            secretKey = keyGenerator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonEncrypt.setOnClickListener(v -> {
            try {
                encrypted = encrypt(editText.getText().toString().getBytes(StandardCharsets.UTF_8), secretKey, IV);
                String ret = encodeHexString(encrypted);
                textViewEncrypt.setText(ret);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonDecrypt.setOnClickListener(v -> {
            decrypted = decrypt(encrypted, secretKey, IV);
            textViewDecrypt.setText(decrypted);
        });
    }

    public String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }

    public String encodeHexString(byte[] byteArray) {
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            hexStringBuffer.append(byteToHex(byteArray[i]));
        }
        return hexStringBuffer.toString();
    }

    public byte[] encrypt(byte[] plaintext, SecretKey secretKey, byte[] IV) throws Exception {
        random = new SecureRandom();
        random.nextBytes(IV);
        cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
        secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
        ivParameterSpec = new IvParameterSpec(IV);
        // where encryption going
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] cipherText = cipher.doFinal(plaintext);
        return cipherText;
    }

    public String decrypt(byte[] cipherText, SecretKey secretKey, byte[] IV) {
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
            ivParameterSpec = new IvParameterSpec(IV);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] decryptedText = cipher.doFinal(cipherText);
            return new String(decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}