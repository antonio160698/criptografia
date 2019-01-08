package Cripto;

public class Criptografia {
    public static void main(String[] args) {
        Seguridad seg = new Seguridad();
        seg.addKey("Bolivia");
        System.out.println("Hola Mundo");
        
        System.out.println("-----Encriptado-----");
        String texto = seg.encriptar("Hola mundo");
        System.out.println(texto);
        
        System.out.println("-----Desencriptar-----");
        System.out.println(seg.desencriptar(texto));
    }
}
