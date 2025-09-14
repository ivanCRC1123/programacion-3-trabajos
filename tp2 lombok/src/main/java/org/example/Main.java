package org.example;

public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = Usuario.builder()
                .id(1L)
                .nombre("Juan pedro")
                .email("juan@example.com")
                .build();

        Usuario usuario2 = Usuario.builder()
                .id(2L)
                .nombre("Ana gomez")
                .email("ana@example.com")
                .build();

        System.out.println(usuario1);
        System.out.println(usuario2);
    }
}
