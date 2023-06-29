# Desafio-Dbc

<a href="https://www.linkedin.com/in/leonardovalves/">
      <img alt="Leonardo Vaz Alves" src="https://img.shields.io/badge/-Leonardo Alves-004088?style=flat&logo=Linkedin&logoColor=white" />
   </a>

Desafio técnico para a vaga desenvolvedor Java.

--------

## 💻 Tecnologias/ferramentas:
- [Java](https://java.com/pt-BR/)
- [Spring Boot](https://spring.io/projects/spring-boot) - Framework para criação de aplicações Java.
- [Render](https://render.com/) - Serviço de hospedagem de aplicações.
- [Git](https://git-scm.com/) - Sistema de controle de versão distribuído.
- [IntelliJ](https://www.jetbrains.com/pt-br/idea/) - IDE para desenvolvimento Java.
## 🔌 Como rodar o projeto:

**Clone este repositório**
```
https://github.com/AlvesLeoo/Desafio-Dbc.git
```
**Instale os pacotes Maven**

Abra o terminal de certifique-se de que está na pasta raiz do projeto, onde se encontra o arquivo pom.xml, e execute o comando:
``` 
mvn clean install
```

Ou se preferir, abra o projeto na IDE no lateral direita procure por ```Maven >desafio >lifeCycle >package``` e dê dois cliques.


**Execute a aplicação**

Pressionando as teclas ```Shift + F10``` ou clicando no botão de play verde na classe DesafioDbcApplication.java

# Swagger
http://localhost:8090/api/swagger-ui/index.html

## 📚 Tarefas bônus

**Tarefa Bônus 1 - Integração com sistemas externos**

Infelizmente o heroku deixou ter seus bancos de dados gratuitos, então não foi possível realizar a integração com o sistema externo já que o endpoint
GET https://user-info.herokuapp.com/users/{cpf} estava fora do ar.

**Tarefa Bônus 4 - Versionamento da API**

- [Versionamento Git](https://micaelpereira.com.br/fluxo-de-versionamento-com-git/) - Para o versionamento desta API iria utilizar o padarao de versionamento por branchs, onde teriamos branchs features baseadas na develop
que após serem testadas e aprovadas seriam mergeadas na develop, a partir da branch develop criaria a branch release que seria a versão de produção, que após seria mergeada na master, mantendo assim sempre uma release estavel em PRD e a branch main sempre atualizada.
