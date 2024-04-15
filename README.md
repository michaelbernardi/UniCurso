# UniCurso

O UniCursosCP2 é um sistema de gestão acadêmica desenvolvido para uma universidade fictícia, que permite gerenciar alunos, cursos e inscrições de forma eficiente. Este projeto é uma aplicação web construída em Java com o framework Spring Boot, oferecendo uma API RESTful para interação com o sistema.

# Funcionalidades Principais
Gerenciamento de Alunos: Cadastro, atualização, listagem e exclusão de alunos. <br>
Gerenciamento de Professores: Cadastro, atualização, listagem e exclusão de professores. <br>
Gerenciamento de Cursos: Cadastro, atualização, listagem e exclusão de cursos. <br>
Inscrições em Cursos: Possibilidade de inscrição de alunos em cursos disponíveis. <br>

# Tecnologias Utilizadas
Java: Linguagem de programação utilizada para desenvolver a aplicação. <br>
Spring Boot: Framework que facilita a criação de aplicativos Java baseados em Spring. <br>
Spring Data JPA: Biblioteca que facilita o acesso e a manipulação de dados em bancos de dados relacionais com o Spring Framework. <br>
H2 Database: Banco de dados em memória utilizado para desenvolvimento. <br>
Hibernate: Framework de mapeamento objeto-relacional (ORM) para a persistência de dados. <br>
Gradle: Sistema de automação de compilação utilizado para gerenciar as dependências e construir o projeto. <br>
Swagger: Ferramenta de código aberto que simplifica a geração, a visualização e a interação com a documentação da API. 

# Configuração do Ambiente de Desenvolvimento

Certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina.
Instale o Gradle. Você pode seguir as instruções de instalação na documentação oficial do Gradle.
Clonar este repositório em sua máquina local: git clone https://github.com/seu-usuario/UniCursosCP2.git

Abra o projeto em sua IDE preferida (como IntelliJ IDEA ou Eclipse).

# Configuração do Banco de Dados
O projeto utiliza o banco de dados H2 para desenvolvimento. A configuração do banco de dados pode ser encontrada no arquivo application.properties.

# Executando o Projeto
Você pode executar o projeto a partir de sua IDE, ou usando o Gradle. Para executar usando o Gradle, vá para o diretório raiz do projeto e execute o seguinte comando:gradle bootRun
Isso iniciará o servidor Spring Boot. O projeto estará disponível em http://localhost:8080.

# Endpoints da API
A API oferece endpoints para interagir com os recursos do sistema:

# Alunos

GET /alunos: Retorna todos os alunos cadastrados. <br> 
GET /alunos/{id}: Retorna o aluno com o ID especificado. <br> 
POST /alunos: Cria um novo aluno. <br> 
PUT /alunos/{id}: Atualiza os dados de um aluno existente. <br> 
DELETE /alunos/{id}: Exclui um aluno existente. <br> 

# Cursos

GET /cursos: Retorna todos os cursos cadastrados. <br> 
GET /cursos/{id}: Retorna o curso com o ID especificado. <br> 
POST /cursos: Cria um novo curso. <br> 
PUT /cursos/{id}: Atualiza os dados de um curso existente. <br> 
DELETE /cursos/{id}: Exclui um curso existente. <br> 

# Inscrições

POST /alunos/{id}/inscricoes/{cursoId}: Realiza a inscrição de um aluno em um curso.

# Contribuição

Michael Jose Bernardi da Silva - RM99409 <br>
Maria Eduarda Sousa de Oliveira - RM552477 <br>
Isadora Tatajuba Moreira Pinto - RM552522 <br>

