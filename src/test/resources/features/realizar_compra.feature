#language: pt
#encoding: utf-8

Funcionalidade: Realizar Compra de produtos

  Cenario: Realizar compra para usuário já criado e pagamento com transferência
    Dado que acesso automationpractice
    Quando adicionar produto "Blouse" no carrinho
    E fazer checkout
    Então o produto adicionado consta no carrinho
    Quando fazer checkout no shopping cart
    E realizar login com email "allanpw.gautier@gmail.com" e senha "test321"
    E processar endereço
    E aceitar os termos de serviço
    E processar transportadora
    Então valida valor total da compra
    Quando escolher a forma de pagamento "Pay by check."
    E confirmar a ordem
    Então gera confirmação de ordem
    E valida valor da ordem