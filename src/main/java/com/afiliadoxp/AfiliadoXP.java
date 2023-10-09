package com.afiliadoxp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AfiliadoXP {

	public static void main(String[] args) {
		Tabelas recursos = new Tabelas();
	
		SpringApplication.run(AfiliadoXP.class, args);

		//System.out.println(recursos.runServer());
		//System.out.println(recursos.runCategorias());
		//System.out.println(recursos.runRodape());
		//System.out.println(recursos.runPlataformas());
		//System.out.println(recursos.runProdutos());
		//System.out.println(recursos.runDescricao());

		//System.out.println(recursos.runRecurssos());
		//System.out.println(recursos.runPerfisDeUsuario());
		//System.out.println(recursos.runUsuario());
		//System.out.println(recursos.runUsuarioTemPerfil());
		//System.out.println(recursos.runPerfil());
		//System.out.println(recursos.runBCrypt());
		
		
		System.out.println(recursos.runPom());
		//System.out.println(recursos.runAfiliadoXP());
		System.out.println(recursos.runBuildingAfiliado());
		//System.out.println(recursos.runInternet());
		//System.out.println(recursos.runImagem());

	}
}
