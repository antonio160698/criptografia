package Cripto;

import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Seguridad {
    private SecretKey key;
    private Cipher cifrado;
    private String algoritmo="AES";
    private int Keysize = 16;
    
    public void addKey (String valor){
        byte[] valuebytes = valor.getBytes();
        key = new SecretKeySpec(Arrays.copyOf(valuebytes, Keysize),algoritmo);
    }
    public String encriptar (String texto){
        String value = "";
        try {
            cifrado = Cipher.getInstance(algoritmo);
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] textbytes = texto.getBytes();
            byte[] cipherbytes = cifrado.doFinal(textbytes);
            value = new BASE64Encoder().encode(cipherbytes);
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
        return value;
    }
    public String desencriptar(String texto){
        String str="";
        try {
            byte[] value = new BASE64Decoder().decodeBuffer(texto);
            cifrado = Cipher.getInstance(algoritmo);
            cifrado.init(Cipher.DECRYPT_MODE, key);
            byte[] cipherbytes = cifrado.doFinal(value);
            str = new String(cipherbytes);
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
        return str;
    }
}
