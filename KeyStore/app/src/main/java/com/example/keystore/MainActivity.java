package com.example.keystore;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;

import java.security.KeyStore;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private TextView textViewEncrypted;
    private TextView textViewDecrypted;
    byte[] iv, encrypted;
    private KeyGenerator keyGenerator;
    private SecretKey secretKey;
    private SecretKeySpec secretKeySpec;
    private IvParameterSpec ivParameterSpec;
    private KeyGenParameterSpec keyGenParameterSpec;
    private KeyStore.SecretKeyEntry secretKeyEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText_input);
        textViewEncrypted = findViewById(R.id.textView_encrypted);
        textViewDecrypted = findViewById(R.id.textView_decrypted);
        Button buttonEncrypt = findViewById(R.id.button_encrypt);
        Button buttonDecrypt = findViewById(R.id.button_decrypt);
//        try {
//            keyGenerator = KeyGenerator.getInstance(, "AndroidKeyStore");
//            KeyGenParameterSpec keyGenParameterSpec = new KeyGenParameterSpec.Builder("MyKeyAlias",
//                    KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
//                    .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
//                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
//                    .build();
//            keyGenerator.init(keyGenParameterSpec);
//            secretKey = keyGenerator.generateKey();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //1. instantiate SecretKey

        try {
            generateSecretKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
        buttonEncrypt.setOnClickListener(this);
        buttonDecrypt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_encrypt: {
                try {
                    encrypted = encrypt(editText.getText().toString());
                    textViewEncrypted.setText(new String(encrypted, StandardCharsets.UTF_8));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
            case R.id.button_decrypt: {
                try {
                    textViewDecrypted.setText(decrypt(encrypted));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void generateSecretKey() throws Exception {
        keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
        keyGenParameterSpec = new KeyGenParameterSpec.Builder("MyAlias",
                KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .build();
        keyGenerator.init(keyGenParameterSpec);
        keyGenerator.generateKey();
    }

    public SecretKey getSecretKey() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        secretKeyEntry = (KeyStore.SecretKeyEntry) keyStore.getEntry("MyAlias", null);
//        if(secretKeyEntry.getSecretKey() != null){
        return secretKeyEntry.getSecretKey();
//        }else {
//            return generateSecretKey();
//        }
    }

    public byte[] encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());
        iv = cipher.getIV();
        return cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
    }

    public String decrypt(byte[] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, iv);
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(), gcmParameterSpec);
        return new String(cipher.doFinal(encrypted), StandardCharsets.UTF_8);
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
}