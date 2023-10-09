package com.afiliadoxp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Tabelas {

    public String runlinha() {
        System.out.println("_______________________________________________________________________________________");
        return "\t\tNovo Conteudo ou Recurso:\n\n\t";
    }
    
    public String runPom() {
        System.out.println(runlinha() + "Verção do Afiliado: \n"
        		+ " |_ 1.0.0.0-AFILIADO-XP \n");
        return "";
    }
    
    public String runServer() {
        System.out.println(runlinha() + " |_ Arrumar o codigo da pagina com o BootStrep \n"
        		+ " |_ Emplimentar o Serve no JAVA \n");
        return "";
    }
    
    public String runAfiliadoXP() {
        System.out.println(runlinha() + " |_ Mudar para AfiliadoXP \n"
        		+ " |_ Mudar para a verção 3.00 do Spring Boot \n"
        		+ " |_ Arrumar o botão de pesquizar produto \n");
        return "";
    }
        
    public String runCatPriForGen_id() {
        System.out.println(runlinha() + " |_ Arrumar o codigo da pagina com o BootStrep \n"
        		+ " |_ Emplimentar o modal \n"
        		+ " |_ Privaciadade SQL \n");
        return "";
    }

    public String runCategorias() {
        System.out.println(runlinha() + "Tabela do tipo CATEGORIA\n "
                + "|_ id \n |_ nome \n |_ descricao");
        return "";
    }
    
    public String runRodape() {
        System.out.println(runlinha() + "Rodapé da pagina com CSS e HTML \n "
                + " |_ id \n |_ https://www.youtube.com/watch?v=SUFzgCwJZkk \n"
                + " |_ Icones ____________________\n"
                + " |_ https://fontawesome.com/");
        return "";
    }

    public String runPlataformas() {
        System.out.println(runlinha() + "Tabela do tipo PLATAFORMA\n "
                + "|_ id \n |_ nome \n |_ plataforma \n |_ imagem");
        return "";
    }

    public String runDescricao() {
        System.out.println(runlinha() + "Tabela do tipo DESCRICAO\n "
                + "|_ id \n |_ titulo \n |_ descricao");
        return "";
    }

    public String runProdutos() {
        System.out.println(runlinha() + "Tabela do tipo PRODUTO\n "
                + "|_ id \n |_ nome \n |_ preco  \n |_ link \n |_ imagem");
        return "";
    }
    
    public String runUsuario() {
        System.out.println(runlinha() + "Tabela do tipo USUARIO\n "
                + "|_ id \n |_ ativo \n |_ email  \n |_ senha \n |_ codigo_verificador");
        return "";
    }
    
    public String runUsuarioTemPerfil() {
        System.out.println(runlinha() + "Tabela do tipo USUARIO_TEM_PERFIL\n "
                + "|_ usuario_id \n |_ perfil_id");
        return "";
    }
    
    public String runPerfil() {
        System.out.println(runlinha() + "Tabela do tipo USUARIO_TEM_PERFIL\n "
                + "|_ id \n |_ descricao");
        return "";
    }
    
    public String runRecurssos() {
        System.out.println(runlinha() + "https://www.youtube.com/watch?v=HWFwgQYdEJE"
        		+ "\nLink para o Debug no codigo: \n"
                + "https://www.youtube.com/watch?v=zS7UG63we4g"
                + "\nSpring Security: \n");
        System.out.println(runlinha() + "Documentação do Spring Security: * Table 11.1. Common built-in expressions *\n"
				+ "https://docs.spring.io/spring-security/site/docs/5.5.8/reference/html5/ \n"
				+ "https://docs.spring.io/spring-security/site/docs/5.1.5.RELEASE/reference/htmlsingle/ \n"
				+ "Melhor opção para configuração de segurança: \n"
				+ "* hasAuthority([authority]) e hasAnyAuthority([authority1,authority2]) *");
        System.out.println(runlinha() + "Curso de spring boot: \n" 
				+ "https://www.youtube.com/watch?v=7aoQTEzagKE");
        return "";
    }
    public String runBCrypt() {
        System.out.println(runlinha() + "Curso de spring boot: \n"
                + "https://www.youtube.com/watch?v=7aoQTEzagKE"
                + "\nSenha Cripitografado no banco:\n"
                + "Senha: "+ new BCryptPasswordEncoder().encode("123") 
                + "\n\n Site do BCRYPT: ( https://bcrypt-generator.com/ )");
        return "";
    }


    public String runImagem() {
        System.out.println(runlinha() + "Tabela do tipo IMAGEM\n "
                + "|_ id \n |_ nome \n |_ imagem");
        return "";
    }

    public String runInternet() {
        System.out.println(runlinha() + "Fazer um biuld da aplicação, Comandos: \n"
                + "|_ Java-build-package\n"
                + "|_ package -e\n\n"
                + "\tSubir a Aplicação no CMD, Comandos: \n"
                + "|_ C:\\Users> cd * local do build *"
                + "|_ java -jar * build do APP *"
                + "\n\n\tAplicação OK -> Link de acesso: http://localhost:8080/"
        );
        return "";
    }
    
    public String runPerfisDeUsuario() {
        System.out.println(runlinha() + "* Categoriais de Afiliados: *" 
        		+ "\n|_ * 1 = .Afiliado_Start  *"
        		+ "\n|_ * 2 = .Afiliado_Junior * "
        		+ "\n|_ * 3 = .Afiliado_Pleno  * "
        		+ "\n|_ * 4 = .Afiliado_Senior * "
        		+ "\n|_ * 5 = .Afiliado_Pro    * "
        		+ "\n|_ * 6 = .Afiliado_Master * "			
				);
        
        return "";
    }
    
    public String runAutocomplete() {
        System.out.println(runlinha() + "* https://jqueryui.com/autocomplete/#multiple-remote * "			
				);
        
        return "";
    }
    
    public String runBuildingAfiliado() {
        System.out.println(runlinha() + "* Building do progeto Afiliado * \n\n"
        		+ "|_ cd C:\\IDEs\\ProgetosVideos\\ProgetosVideos\\afiliado_24 \n"
        		+ "|_ C:\\IDEs\\ProgetosVideos\\ProgetosVideos\\afiliado_24> mvn package \n"
        		+ "|_ C:\\IDEs\\ProgetosVideos\\ProgetosVideos\\afiliado_24> cd .\\target \n"
        		+ "|_ C:\\IDEs\\ProgetosVideos\\ProgetosVideos\\afiliado_24\\target> java -jar afiliado-0.0.1.40-AFILIADO.jar \n\n"
        		+ "___________________________________________________________________________\n"
        		+ "\t\t * Mini Servidor por Computador, Celular, etc * \n\n"
        		+ "|_ C:\\Windows\\System32> ipconfig \n"
        		+ "|_ Endereço IPv4. . . . . . . .  . . . . . . . : 192.168.0.112 \n"
        		+ "|_ http://192.168.0.112:8082/exibirProdutosVenda \n");
        
        return "";
    }
    
    

}
