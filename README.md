# ZG-HERO-Project

Projetos ZG-Hero do Acelera ZG Linketinder

## Nome

Pedro gama

## Como Executar

Após as ultimas refatorações o projeto assumiu uma estrutura de micro serviços, portanto surge a necessidade de iniciar cada micro serviço separadamente uma vez que eles são por natureza independentes. No momento ainda estou em processo de refatoração dos readmes, porém assim que eu terminar voce encontrará em cada um dos microserviços um readme indicando como inicia-lo apropriadamente.

## Executando com Docker

Se eu estiver correto basta ter o docker instalado corretamente e executar `sudo docker compose up -d na raiz do projeto`
caso isso não funcione será necessario buildar imagem por imagem dentro dos Microservicos e depois executar o compose

Detalhe: Dado a falta de tempo para executar a tarefa algumas liberdades foram tomadas e acabei utilizando alguns shortcuts por exemplo me livrei dos testes de integracão pois eles estavam gerando erros na hora de buildar com o gradlew que não usaria normalmente portanto é provavel que eu tenha deixado passar um problema ou outro mas é algo que ainda devo corrigir.

## Linketinder

Até o momento o projeto só possui duas funcionalidades para registrar candidatos (ainda sem descricao, data de nascimento CPF, CEP e competencias) e para listar todos os candidatos, isso se deve a necessidade de entender a dimensão da aplicação e também a refatoração do código seguindo principios SOLID e clean code. Por tanto decidir manter aqui uma lista de TODOs da aplicação. WARNIN: O servico de email necessita de uma chave secreta, é necessario registra-la manualmente por tanto caso seja necessario fazer a testagem deste MS entre em contato ;)

### TO-DOs

- useCase de procurar usuario por email
- useCase de registar descricao, CPF, CEP e data de nascimento do usuario
- useCase atualizar informações do usuario
- regras de negocio para criação de usuario
- regras de negocio para leitura de informações do usuario
- todos os useCases relacionados as empresas e suas respectivas regras de negocio
- useCases de registro de competencias dos usuarios
- useCases de registro de vagas da empresa
- função de MATCH
