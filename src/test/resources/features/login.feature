#language: pt
#encoding: utf-8

Funcionalidade: Login

Cenario: Login válido
  Dado que estou no sistema automationpractice
  Quando abrir tela de login
  E preencher email "allanpw.gautier@gmail.com"
  E preencher senha "test321"
  E realizar login
  Então o sistema encaminha para página my account do usuário "testuser"
  E realiza logout

Cenario: Login inválido
  Dado que estou no sistema automationpractice
  Quando abrir tela de login
  E preencher email "test@gmail.com"
  E preencher senha "pwdtest"
  E realizar login
  Então o sistema apresenta mensagem de login inválido